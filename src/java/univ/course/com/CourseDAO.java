/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.course.com;

import java.sql.*;
import java.util.*;
import univ.career.com.Career;
import univ.career.com.CareerDAO;
import univ.database.com.Database;

/**
 *
 * @author Personal
 */
public class CourseDAO {
     public List<Course> getAll(int id) {
        try {
            List<Course> courseList = new ArrayList<>();
            Database db = new Database();
            PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * FROM courses WHERE careerId = ? ORDER BY 3 ASC;");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("courseId"));              
                course.setName(rs.getString("name"));
                course.setCategory(rs.getString("category"));              
                course.setCredits(rs.getInt("credits"));              
                courseList.add(course);
            }

            return courseList;

        } catch (SQLException ex) {
            System.getLogger(CareerDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }
}
