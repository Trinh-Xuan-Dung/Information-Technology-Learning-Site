/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Address;
import Entity.User;
import Entity.Users;
import Logic.PasswordLogic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class UserDAOImplement extends DBContext implements UserDAO {

    Connection con;
    private DBContext context = new DBContext();
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

    @Override
    public User SignIn(String username, String password) {
        try {
            String sql = "SELECT * FROM learning_site.users Where Username = ? and Password = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setAddressId(rs.getInt(8));
                user.setBase64Image(rs.getString(9));
                user.setDOB(rs.getDate(10));
                return user;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean checkUserExist(String username) {
        try {
            String sql = "SELECT * FROM learning_site.users Where Username = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setAddressId(rs.getInt(8));
                user.setBase64Image(rs.getString(9));
                user.setDOB(rs.getDate(10));
                return true;
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public String checkEmailWithUsername(String username) {
        try {
            String sql = "SELECT * FROM learning_site.users Where Username = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setAddressId(rs.getInt(8));
                user.setBase64Image(rs.getString(9));
                user.setDOB(rs.getDate(10));
                return user.getEmail();
            }

        } catch (Exception ex) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public int updatePasswordByEmail(String email, String password) {
        int n = 0;
        try {
            String sql = "update users set password = ? where email = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            n = ps.executeUpdate();
            return n;
        } catch (Exception e) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
}
