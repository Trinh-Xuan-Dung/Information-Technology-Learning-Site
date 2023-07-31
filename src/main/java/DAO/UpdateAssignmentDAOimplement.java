/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Course;
import Entity.Subject;
import Entity.SubjectCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoan
 */
public class UpdateAssignmentDAOimplement implements UpdateAssignmentDAO{
    
    DBContext context = new DBContext();
    Connection con;
    public static void main(String[] args) {
        System.out.println("Test");
        UpdateAssignmentDAOimplement a = new UpdateAssignmentDAOimplement();
        a.updateAssignment();
    }
    
    @Override
    public boolean updateAssignment() {
        try {

            String sql = "SELECT CourseId, CourseName, Image, CourseDescription, DateCreate, CourseTitle\n" +
"FROM learning_site.course";

            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs.getInt(1));
            System.out.println("test method");
            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
