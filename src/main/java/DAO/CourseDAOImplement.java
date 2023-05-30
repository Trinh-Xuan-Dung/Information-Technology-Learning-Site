/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Course;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CourseDAOImplement implements CourseDAO{
    private DBContext context = new DBContext();
    @Override
    public List<Course> getAllCourse() {
        List<Course> listC= new ArrayList<>();
       
        try {
            Connection conn = context.getConnection(); 
            String sql="SELECT CourseId, CourseName, CourseDescription, DateCreate FROM learning_site.course";
           // ResultSet rs =  context.getDataByRawSQL(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                Course course=new Course(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toLocalDate());
             listC.add(course);
            }
           
   
        } catch (Exception e) {
        }
        return listC;

    }
    
    public static void main(String[] args) {
        CourseDAO dao = new CourseDAOImplement();
        List<Course> list = new ArrayList<>();
        list=dao.getAllCourse();
        for (Course course : list) {
            System.out.println(course);
            
        }
        
        
    }
    
    
}
