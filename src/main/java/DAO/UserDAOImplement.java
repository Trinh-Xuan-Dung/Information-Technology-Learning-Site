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
import java.sql.Date;
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
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO users (Username,Password,FirstName,LastName,Email,Phone,AddressId)"
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, enc.encodePassByBase64(user.getPassword()));
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPhone());
            ps.setInt(7, user.getAddressId());

            generatedId = ps.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, e);
        }
        return generatedId;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAOImplement();
//////        
//        int i = dao.AddNewUser(new Users("longdhhe", "12345678", "Dao", "Long", "daohoanglong20002310@gmail.com", "0705846251",
//                14));
        Users u = dao.SignIn("longdhhe", "12345678");

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
    public Users SignIn(String username, String password) {
        PasswordLogic enc = new PasswordLogic();
        String password2 = enc.encodePassByBase64(password);
        try {
            
            String sql = "SELECT * FROM itls.users where Username = ? and Password = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password2);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setAddressId(rs.getInt(8));
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
            String sql = "SELECT * FROM users Where Username = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setAddressId(rs.getInt(8));
                user.setImage(rs.getBlob(9));
                user.setDob(rs.getDate(10));
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
            String sql = "SELECT * FROM users Where Username = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPhone(rs.getString(7));
                user.setAddressId(rs.getInt(8));
                user.setImage(rs.getBlob(9));
                user.setDob(rs.getDate(10));
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
        PasswordLogic enc = new PasswordLogic();
        try {
            String sql = "update users set password = ? where email = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, enc.encodePassByBase64(password));
            ps.setString(2, email);
            n = ps.executeUpdate();
            return n;
        } catch (Exception e) {
            Logger.getLogger(UserDAOImplement.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
}