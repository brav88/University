/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.enrollment.com;

import java.sql.*;
import java.util.*;
import univ.career.com.CareerDAO;
import univ.course.com.Course;
import univ.database.com.Database;

/**
 *
 * @author Personal
 */
public class EnrollmentDAO {

    public List<Integer> getEnrollmentDetails(int userId, int enrollmentId) {
        try {
            List<Integer> courseEnrollmentList = new ArrayList<>();
            Database db = new Database();

            String sql = " SELECT courseId FROM enrollment e "
                    + "	INNER JOIN enrollment_detail ed "
                    + "    ON e.enrollmentId = ed.enrollmentId "
                    + " WHERE e.userId = ? AND e.enrollmentId = ?;";

            PreparedStatement pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, enrollmentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                courseEnrollmentList.add(rs.getInt("courseId"));
            }

            return courseEnrollmentList;

        } catch (SQLException ex) {
            System.getLogger(CareerDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }

    public void insertEnrollment(int userId, int careerId) {
        try {
            Database db = new Database();
            PreparedStatement pstmt = db.getConnection().prepareStatement("INSERT INTO enrollment (userId, careerId) VALUES (?, ?);");
            pstmt.setInt(1, userId);
            pstmt.setInt(2, careerId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(CareerDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void insertEnrollmentDetail(int enrollmentId, int courseId) {
        try {
            Database db = new Database();
            PreparedStatement pstmt = db.getConnection().prepareStatement("INSERT INTO enrollment_detail (enrollmentId, courseId) VALUES (?, ?);");
            pstmt.setInt(1, enrollmentId);
            pstmt.setInt(2, courseId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(CareerDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public void deleteEnrollmentDetail(int enrollmentId, int courseId) {
        try {
            Database db = new Database();
            PreparedStatement pstmt = db.getConnection().prepareStatement("DELETE FROM enrollment_detail WHERE enrollmentId = ? AND courseId = ?;");
            pstmt.setInt(1, enrollmentId);
            pstmt.setInt(2, courseId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(CareerDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
