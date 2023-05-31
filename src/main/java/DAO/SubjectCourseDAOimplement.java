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
public class SubjectCourseDAOimplement  implements  SubjectCourseDAO{
    DBContext context = new DBContext();
    @Override
    public boolean AddToSubjectCourse(int subjectId,int courseId) {
        boolean flag = false;
        
        try {
            String sql = "INSERT INTO learning_site.subjectcourse (SubjectId, CourseId) VALUES(?, ?)";
        Connection conn = context.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, subjectId);
        ps.setInt(2, courseId);
        
        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0) {
            flag = true;
        }
        } catch (Exception e) {
        }
        return flag;
        
    }
    
}
