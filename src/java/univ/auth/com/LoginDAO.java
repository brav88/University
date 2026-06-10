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

            PreparedStatement pstat = conn.prepareStatement("SELECT * FROM user WHERE email = ? AND pwd = ?");

            pstat.setString(1, user.getEmail());
            pstat.setString(2, user.getPwd());

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {                                
                user.setName(rs.getString("name"));
                return user;
            }

            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
