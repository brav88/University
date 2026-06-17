/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.course.com;

/**
 *
 * @author Personal
 */
public class Course {
    private int Id;
    private int CareerId;
    private String Category;
    private String Name;
    private int Credits;    

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setCareerId(int CareerId) {
        this.CareerId = CareerId;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setCredits(int credits) {
        this.Credits = credits;
    }

    public int getId() {
        return Id;
    }

    public int getCareerId() {
        return CareerId;
    }

    public String getCategory() {
        return Category;
    }

    public String getName() {
        return Name;
    }

    public int getCredits() {
        return Credits;
    }

    public Course() {
    }

}


