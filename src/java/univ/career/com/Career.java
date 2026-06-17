/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.career.com;

/**
 *
 * @author Personal
 */
public class Career {
    
    private int Id;
    private String Grade;
    private String Name;
    private String Description;
    private String Category;
    private String Photo;

    public Career() {
    }

    public int getId() {
        return Id;
    }

    public String getGrade() {
        return Grade;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getCategory() {
        return Category;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
}
