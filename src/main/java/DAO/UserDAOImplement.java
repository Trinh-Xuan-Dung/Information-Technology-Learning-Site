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
        AddressDAO addressdao = new AddressImplement();
        int addresId = addressdao.AddNewAddress(new Address(0, "Alle1", "21-ngo 156 Ton That Tung"));
        if (addresId != 0) {
            Users user = new Users(0, "admin", "admin#01", "abc@123.com", 7);
            UserDAO dao = new UserDAOImplement();
            int userId = dao.AddNewUser(user);
            if (userId != 0) {
                System.out.println("insert user SUccress:+\n");
                user.setId(userId);
                System.out.println("User:" + user);
            }else{
                System.out.println("insert failed:");
            }
            
        } else {
            System.out.println("Insert");
        }

    }
}
