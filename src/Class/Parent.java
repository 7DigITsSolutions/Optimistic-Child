/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author mazen
 */
public class Parent {
    private String p_name;
    private String k_name;
    private String email;
    private String phone_number;
    private String n_id;
    private String password;

    public Parent() {
    }

    public Parent(String p_name, String k_name, String email, String phone_number, String n_id, String password) {
        this.p_name = p_name;
        this.k_name = k_name;
        this.email = email;
        this.phone_number = phone_number;
        this.n_id = n_id;
        this.password = password;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getK_name() {
        return k_name;
    }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the p_name
     */
  
}
