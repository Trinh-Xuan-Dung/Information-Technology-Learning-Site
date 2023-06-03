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
public class ModuleDAOimplement implements ModuleDAO {

    DBContext context = new DBContext();
    Connection con;

    @Override
    public int addNewCourse(int courseid, Module module) {

        int keygenarateInsert =0;
        try {
            con = context.getConnection();
            if(courseid>0){
                String sql = "";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(courseid, courseid);
            }else{
                return 0;
            }
        } catch (Exception e) {
        }
        return keygenarateInsert;
    }

}
