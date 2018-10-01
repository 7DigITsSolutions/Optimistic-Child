/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.Element;
import javax.swing.text.TableView;

import sun.security.pkcs.ParsingException;

/**
 *
 * @author Eslam PC
 */
public class SQL {

    Connection con = null;
    private Statement stmt = null;

    public Statement getStmt() {
        return stmt;

    }

    public SQL() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=superkid;user=sa;password=123456789";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//Driver name
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();

            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insert(Parent p) {

        String qv = "insert into parent(p_name,k_name,email,phone_number,national_id,password)\n"
                + "values('" + p.getP_name() + "','" + p.getK_name() + "','" + p.getEmail()
                + "','" + p.getPhone_number() + "','" + p.getN_id() + "','" + p.getPassword() + "')";

        try {

            System.out.println("Query: " + qv);

            int rv = stmt.executeUpdate(qv);

            if (rv > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet loginP(Parent p) {
        ResultSet rs = null;

        try {
            String query = ("SELECT email,password FROM parent WHERE email  = '" + p.getEmail() + "' and password = '" + p.getPassword() + "'");

            System.out.println("Query: " + query);
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public ResultSet view_id(Parent p) {
        ResultSet rs = null;

        try {
            String query = ("select p_id from parent where p_name= '" + p.getP_name() + "'");

            System.out.println("Query: " + query);
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public ResultSet view_idk(Parent p) {
        ResultSet rs = null;

        try {
            String query = ("select p_id from parent where k_name= '" + p.getK_name() + "'");

            System.out.println("Query: " + query);
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public ResultSet view_idkids(answers a) {
        ResultSet rs = null;

        try {
            String query = ("select k_id from kid where fk_p= '" + a.getFk_p() + "'");

            System.out.println("Query: " + query);
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public boolean insertkid(kids k) {

        String qv = "insert into kid \n"
                + "values(" + k.getAge() + "," + k.getGender() + "," + k.getP_id() + ")";

        try {

            System.out.println("Query: " + qv);

            int rv = stmt.executeUpdate(qv);

            if (rv > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertanswer(answers a) {

        String qv = "insert into answers \n"
                + "values(" + a.getAnswer() + "," + a.getFk_p() + "," + a.getFk_k() + ")";

        try {

            System.out.println("Query: " + qv);

            int rv = stmt.executeUpdate(qv);

            if (rv > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet sumgrade(answers a) {
        ResultSet rs = null;
       
        try {
            String query = ("select sum (answer)Grade from answers\n"
                    + "where fk_p ='" + a.getFk_p()+ "'");

            System.out.println("Query: " + query);
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }
}

//    public boolean insertcustomer(Customer c) {
//        String q = "insert into Customer\n"
//                //"values ('1234568798','omar','omar@gmail','maadi',50)"
//                + " values('" + c.getN_ID() + "',"
//                + "'" + c.getName() + "'"
//                + ",'" + c.getEmail() + "'"
//                + ",'" + c.getArea() + "'"
//                + "," + c.getTotalDue() + ")";
//        try {
//            System.out.println("Query: " + q);
//
//            int rc = stmt.executeUpdate(q);
//
//            if (rc > 0) {
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
////////////////search all///////////////
//    public ResultSet searchAll(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due,n.state\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)"
//                    + "WHERE National_ID  LIKE '%" + c.getN_ID() + "%' ";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//////////////////completed all///////////////
//
//    public ResultSet searchcompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query1 = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where n.state='completed' and National_ID  LIKE '%" + c.getN_ID() + "%' ";
//            rs = stmt.executeQuery(query1);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
////////////////in compledted all///////////////
//
//    public ResultSet searchincompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where National_ID LIKE '%" + c.getN_ID() + "%' and n.state='InCompleted'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    ///////////////voda all /////////////
//    public ResultSet vodaAll(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due,n.state\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)"
//                    + "WHERE National_ID  LIKE '%" + c.getN_ID() + "%' and FK_Comp_num = '" + n.getComp_num() + "'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    ///////////////voda completed //////////////////
//    public ResultSet vodacompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query1 = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where n.state='completed' and National_ID  LIKE '%" + c.getN_ID() + "%' and FK_Comp_num = '" + n.getComp_num() + "' ";
//            rs = stmt.executeQuery(query1);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//////////////voda incomplted //////////////
//
//    public ResultSet vodaincompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where National_ID LIKE '%" + c.getN_ID() + "%' and n.state='InCompleted' and FK_Comp_num = '" + n.getComp_num() + "'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
/////////////etisalate all //////////
//
//    public ResultSet etisAll(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due,n.state\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)"
//                    + "WHERE National_ID  LIKE '%" + c.getN_ID() + "%' and FK_Comp_num = '" + n.getComp_num() + "'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
////////////////etisalate completed////////////////
//
//    public ResultSet etiscompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query1 = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where n.state='completed' and National_ID  LIKE '%" + c.getN_ID() + "%' and FK_Comp_num = '" + n.getComp_num() + "' ";
//            rs = stmt.executeQuery(query1);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    /////////etisalate incompleted /////////////////
//    public ResultSet etisincompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where National_ID LIKE '%" + c.getN_ID() + "%' and n.state='InCompleted' and FK_Comp_num = '" + n.getComp_num() + "'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    //////////orange all///////
//    public ResultSet orgAll(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due,n.state\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)"
//                    + "WHERE National_ID  LIKE '%" + c.getN_ID() + "%' and FK_Comp_num = '" + n.getComp_num() + "'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    /////////////orange completed ///////
//    public ResultSet orgcompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query1 = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where n.state='completed' and National_ID  LIKE '%" + c.getN_ID() + "%' and FK_Comp_num = '" + n.getComp_num() + "' ";
//            rs = stmt.executeQuery(query1);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//    }
//
//    //////orange incompleted ///////////
//    public ResultSet orgincompleted(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select c.National_ID,c.Name,c.E_mail,c.Area,n.Mobile_Num,o.c_name,n.Due\n"
//                    + "from Customer C\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "INNER JOIN company o on( c_ID = FK_Comp_num)\n"
//                    + "where National_ID LIKE '%" + c.getN_ID() + "%' and n.state='InCompleted' and FK_Comp_num = '" + n.getComp_num() + "'";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    public ResultSet calculateview(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "SELECT Name,Total_Due "
//                    + "from Customer "
//                    + "where National_ID = '" + c.getN_ID() + "';";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }
//
//    public Boolean calculate(Customer c, Numbers n, company o) {
//        try {
//
//            String query = "UPDATE  Customer \n"
//                    + "SET Total_Due=(( \n"
//                    + "select sum (n.Due) AS TOTAL\n"
//                    + "from Customer c\n"
//                    + "INNER JOIN Numbers n on( National_ID = FK_N_ID)\n"
//                    + "where c.National_ID='" + c.getN_ID() + "')\n"
//                    + ")where National_ID='" + c.getN_ID() + "';";
//
//            int rc = stmt.executeUpdate(query);
//
//            if (rc > 1) {
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    }
//
//    public ResultSet viewdue(Customer c, Numbers n, company o) {
//        ResultSet rs = null;
//        try {
//            String query = "select National_ID,Name,Total_Due "
//                    + "from Customer "
//                    + "where National_ID LIKE '%" + c.getN_ID() + "%' ";
//
//            rs = stmt.executeQuery(query);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rs;
//
//    }

