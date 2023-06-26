/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class UserRoleDAOImplement extends DBContext implements UserRoleDAO {

    Connection con;

    @Override
    public boolean addUserRoleWhenRegis(int userId, int roleId) {

        try {
            con = getConnection();
            String sql = "INSERT INTO learning_site.userrole (UserId, RoleId) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, roleId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

}
