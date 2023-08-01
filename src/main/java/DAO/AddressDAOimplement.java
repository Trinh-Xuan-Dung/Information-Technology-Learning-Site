/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class AddressDAOimplement  implements AddressDAO {
    DBContext context =new DBContext();

    @Override
    public int AddNewAddress(Address address) {
        int generatedId = 0;
        try {
            Connection con = context.getConnection();
            String sql = "INSERT INTO learning_site.address(Alley, HouseNumber)VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, address.getAlley());
            ps.setString(2, address.getHouseNumber());
            

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

}
