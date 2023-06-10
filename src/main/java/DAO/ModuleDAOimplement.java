/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import Entity.Module;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ModuleDAOimplement implements ModuleDAO {

    DBContext context = new DBContext();
    Connection con;

    @Override
    public int addNewModule(int courseid, Module module) {
        int keygenarateInsert = 0;
        try {
            con = context.getConnection();
            if (courseid > 0) {
                String sql = "INSERT INTO Module (CourseId, ModuleName, ModuleDescription) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, courseid);
                ps.setString(2, module.getModuleName());
                ps.setString(3, module.getModuleDescription());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        keygenarateInsert = rs.getInt(1);
                    }
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return keygenarateInsert;
    }
   
    @Override
    public List<Module> getAllModuleOfCourseByCoureid(int i) {
        List<Module> listModule = new ArrayList<>();
        try {
            
            
            con = context.getConnection();
            String sql = "SELECT ModuleId, CourseId, ModuleName, ModuleDescription FROM learning_site.module WHERE CourseId =?";
            // ResultSet rs =  context.getDataByRawSQL(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Module module = new Module(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                listModule.add(module);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ModuleDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listModule;
    }
    public static void main(String[] args) {
        ModuleDAO dao = new ModuleDAOimplement();
        List<Module> d = dao.getAllModuleOfCourseByCoureid(1);
        for (Module module : d) {
            System.err.println(module);
        }
    }

    @Override
    public Module getModuleOfCourseByCoureid(int i) {
        Module module = new Module();
        try {
            
            
            con = context.getConnection();
            String sql = "SELECT ModuleId, CourseId, ModuleName, ModuleDescription FROM learning_site.module WHERE ModuleId =?";
            // ResultSet rs =  context.getDataByRawSQL(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                 module.setModuleId(rs.getInt(1));
                 module.setCourseId(rs.getInt(2));
                 module.setModuleName(rs.getString(3));
                 module.setModuleDescription(rs.getString(4));
                 
               
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ModuleDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return module;
    }
}
