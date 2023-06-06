/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Course;
import com.mysql.cj.xdevapi.Result;
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
public class CourseDAOimplement implements CourseDAO {

    private DBContext context = new DBContext();

    @Override
    public List<Course> getAllCourse() {
        List<Course> listC = new ArrayList<>();

        try {
            Connection conn = context.getConnection();
            String sql = "SELECT CourseId, CourseName, Image, CourseDescription, DateCreate FROM learning_site.course";
            // ResultSet rs =  context.getDataByRawSQL(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Course course = new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toLocalDate());
                listC.add(course);
            }

        } catch (Exception e) {
        }
        return listC;

    }

    @Override
    public int addNewCourse(Course course) {
        int generatedId = 0;
        try {
            String sql = "INSERT INTO learning_site.course (CourseName, Image, CourseDescription, DateCreate) VALUES(?,?,?, CURRENT_TIMESTAMP)";
            Connection conn = context.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getImageUrlString());
            ps.setString(3, course.getCourseDescription());
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

    @Override
    public Course getCourseById(int i) {
        Course course = new Course();

        try {
            String sql = "SELECT CourseId, CourseName, Image, CourseDescription, DateCreate FROM learning_site.course Where CourseId =?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                course.setCourseId(rs.getInt(1));
                course.setCourseName(rs.getString(2));
                course.setImageUrlString(rs.getString(3));
                course.setCourseDescription(rs.getString(4));
                course.setDateCreate(rs.getDate(5).toLocalDate());
            }

        } catch (Exception ex) {
            Logger.getLogger(CourseDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return course;
    }

    @Override
    public boolean UpdateCourseById(Course course) {
        try {
            String sql = "UPDATE learning_site.course SET CourseName=?, Image=?, CourseDescription=? WHERE CourseId=?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getImageUrlString());
            ps.setString(3, course.getCourseDescription());
            ps.setInt(4, course.getCourseId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return true; 
            }else{
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(CourseDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Course> getAllCourseJoin() {
        List<Course> listC = new ArrayList<>();

        try {
            Connection conn = context.getConnection();
            String sql = "SELECT c.CourseId, c.CourseName, c.CourseDescription, c.ImageUrlString, s.SubjectId, s.SubjectName, s.SubjectDescription "
                    + "FROM Course c JOIN SubjectCourse sc ON c.CourseId = sc.CourseId JOIN Subject s ON sc.SubjectId = s.SubjectId";
            // ResultSet rs =  context.getDataByRawSQL(sql);
            

        } catch (Exception e) {
        }
        return listC;
    }

}
