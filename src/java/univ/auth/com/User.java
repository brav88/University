/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.auth.com;

/**
 *
 * @author Personal
 */
public class User {
 
    private String Name;
    private String Email;
    private String Pwd;

    public User() {
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPwd(String Pwd) {
        this.Pwd = Pwd;
    }
}
