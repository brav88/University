/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.career.com;

import java.sql.*;
import java.util.*;
import univ.database.com.Database;

/**
 *
 * @author Personal
 */
public class CareerDAO {

    public List<Career> getAll() {
        try {
            List<Career> careerList = new ArrayList<>();
            Database db = new Database();
            PreparedStatement pstmt = db.getConnection().prepareStatement("SELECT * FROM careers;");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Career career = new Career();
                career.setId(rs.getInt("id"));
                career.setGrade(rs.getString("grade"));
                career.setName(rs.getString("name"));
                career.setDescription(rs.getString("description"));
                career.setPhoto(rs.getString("photo"));
                career.setCategory(rs.getString("category"));
                careerList.add(career);
            }

            return careerList;

        } catch (SQLException ex) {
            System.getLogger(CareerDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return null;
        }
    }
}
