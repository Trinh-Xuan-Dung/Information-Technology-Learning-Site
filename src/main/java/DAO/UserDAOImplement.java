/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Address;
import Entity.Users;
import Logic.PasswordLogic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class UserDAOImplement extends DBContext implements UserDAO {

    Connection con;

    @Override
    public int AddNewUser(Users user) {
        int generatedId = 0;
        PasswordLogic enc = new PasswordLogic();
        user.setPassword(enc.encodePassByBase64(user.getPassword()));
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO learning_site.users (Username, Password,Email,AddressId)"
                    + "VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getAddressId());
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }

        } catch (Exception e) {
        }
        return generatedId;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAOImplement();
        Users u = dao.getUserExsit("duannv");
        System.out.println(u);

    }

    @Override
    public Users getUserExsit(String userName) {
        

        try {
            con = getConnection();
            String sql = "SELECT  Username, Password FROM learning_site.users Where Username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userName);
          
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Users user = new Users();
                user.setUsername(rs.getString(1));         
                return user;
            }
        } catch (Exception e) {
        }
        return null;
    }

}
