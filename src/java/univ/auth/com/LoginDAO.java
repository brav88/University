/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univ.auth.com;

import java.sql.*;
import univ.database.com.Database;

/**
 *
 * @author Personal
 */
public class LoginDAO {

    public User validateLogin(User user) {
        try {
            Database db = new Database();
            Connection conn = db.getConnection();

            String sql = " SELECT * FROM user u " +
                         "    LEFT JOIN enrollment e " +
                         "    ON u.userId = e.userId " +
                         " WHERE u.email = ? AND u.pwd = ? ";
            
            PreparedStatement pstat = conn.prepareStatement(sql);

            pstat.setString(1, user.getEmail());
            pstat.setString(2, user.getPwd());

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {        
                user.setId(rs.getInt("userId"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setCareerId(rs.getInt("careerId"));
                user.setEnrollmentId(rs.getInt("enrollmentId"));
                return user;
            }

            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
