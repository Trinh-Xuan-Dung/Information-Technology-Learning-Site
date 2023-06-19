/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.WeekCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class WeekDAOimplement implements WeekDAO {

    DBContext context = new DBContext();
    Connection con;

    @Override
    public int AddNewWeekCOurse(int moduleId, WeekCourse week) {
        int genarateKey = 0;
        try {
            con = context.getConnection();
            if (moduleId > 0) {
                String sql = "INSERT INTO learning_site.weekcourse (ModuleId, WeekNumber, WeekTitle, WeekDescription) VALUES(?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, moduleId);
                ps.setInt(2, week.getWeekNumber());
                ps.setString(3, week.getWeekTilte());
                ps.setString(4, week.getWeekDes());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        genarateKey = rs.getInt(1);
                    }
                }
            }

            return genarateKey;

        } catch (Exception e) {
        }
        return genarateKey;
    }

    @Override
    public List<WeekCourse> getAllWeekByModule(int i) {
        List<WeekCourse> listweek = new ArrayList<>();
        try {

            con = context.getConnection();
            String sql = "SELECT WeekId, ModuleId, WeekNumber, WeekTitle, WeekDescription FROM learning_site.weekcourse WHERE ModuleId =? ORDER BY WeekNumber ASC";
            // ResultSet rs =  context.getDataByRawSQL(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                WeekCourse week = new WeekCourse(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listweek.add(week);

            }

        } catch (Exception ex) {
            Logger.getLogger(ModuleDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listweek;
    }

    @Override
    public WeekCourse getWeekByWId(int weekId) {
        WeekCourse weekCourse = null;

        try {
            con = context.getConnection();
            String query = "SELECT * FROM WeekCourse WHERE WeekId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, weekId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                weekCourse = new WeekCourse();
                weekCourse.setWeekId(rs.getInt("WeekId"));
                weekCourse.setModuleId(rs.getInt("ModuleId"));
                weekCourse.setWeekNumber(rs.getInt("WeekNumber"));
                weekCourse.setWeekTilte(rs.getString("WeekTitle"));
                weekCourse.setWeekDes(rs.getString("WeekDescription"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(WeekDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return weekCourse;

    }

    public static void main(String[] args) {
        WeekDAO dao = new WeekDAOimplement();
        WeekCourse week = dao.getWeekByWId(5);
        System.out.println(week);
    }

    @Override
    public boolean updateWeekById(int i, WeekCourse wc) {
        try {
            con = context.getConnection();
            String sql = "UPDATE learning_site.weekcourse set  WeekNumber=?, WeekTitle=?, WeekDescription=? WHERE WeekId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, wc.getWeekNumber());
            ps.setString(2, wc.getWeekTilte());
            ps.setString(3, wc.getWeekDes());
            ps.setInt(4, i);
            return ps.executeUpdate()>0;

        } catch (Exception e) {
        }
        return false;
    }

}
