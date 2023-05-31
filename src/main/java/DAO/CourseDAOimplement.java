/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CourseDAOimplement implements CourseDAO{
    private DBContext context = new DBContext();
    @Override
    public List<Course> getAllCourse() {
        List<Course> listC= new ArrayList<>();
       
        try {
            Connection conn = context.getConnection(); 
            String sql="SELECT CourseId, CourseName, Image, CourseDescription, DateCreate FROM learning_site.course";
           // ResultSet rs =  context.getDataByRawSQL(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Course course=new Course(rs.getInt(1), rs.getString(2), rs.getString(3) ,rs.getString(4), rs.getDate(5).toLocalDate());
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
            PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
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
    
    
}
