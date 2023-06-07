/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.SubjectCourse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class SubjectCourseDAOimplement  implements  SubjectCourseDAO{
    DBContext context = new DBContext();
    @Override
    public boolean AddToSubjectCourse(SubjectCourse sc) {
        boolean flag = false;
        
        try {
            String sql = "INSERT INTO learning_site.subjectcourse (SubjectId, CourseId) VALUES(?, ?)";
        Connection conn = context.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, sc.getSubjectId());
        ps.setInt(2, sc.getCourseId());
        
        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0) {
            flag = true;
        }
        } catch (Exception e) {
        }
        return flag;
        
    }

    @Override
    public List<SubjectCourse> getAllSubjectCorseByCourseId(int i) {
        List<SubjectCourse> subjectCourseList = new ArrayList<>();
    
    try {
        String sql = "SELECT CourseSubjectId, SubjectId, CourseId FROM SubjectCourse WHERE CourseId = ?";
        Connection con = context.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, i);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            SubjectCourse subjectCourse = new SubjectCourse();
            subjectCourse.setSubjectCourseId(rs.getInt(1));
            subjectCourse.setSubjectId(rs.getInt(2));
            subjectCourse.setCourseId(rs.getInt(3));
            subjectCourseList.add(subjectCourse);
        }
        
        rs.close();
        ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return subjectCourseList;
    }

   
    
}
