/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCOE.beans;

/**
 *
 * @author dreamboy
 */
public class RegistrationData {
    private String username;
    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String password;
    
}
