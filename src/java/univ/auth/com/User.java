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

    private int Id;
    private String Name;
    private String Email;
    private String Pwd;

    private int CareerId;
    private int EnrollmentId;

    public User() {
    }

    public int getId() {
        return Id;
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

    public int getCareerId() {
        return CareerId;
    }
    
     public int getEnrollmentId() {
        return EnrollmentId;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public void setCareerId(int CareerId) {
        this.CareerId = CareerId;
    }
    
    public void setEnrollmentId(int EnrollmentId) {
        this.EnrollmentId = EnrollmentId;
    }
}
