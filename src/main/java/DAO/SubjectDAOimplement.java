/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Subject;
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
public class SubjectDAOimplement implements SubjectDAO{
 private DBContext context = new DBContext();
    @Override
    public List<Subject> getAllSubject() {
        List<Subject> listS= new ArrayList<>();
        try {
             Connection conn = context.getConnection(); 
            String sql="SELECT SubjectId, SubjectName, SubjectDescription FROM learning_site.subject";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Subject subject = new Subject(rs.getInt(1), rs.getString(2), rs.getString(3));
                if(subject!=null){
                    listS.add(subject);
                }
            }
        } catch (Exception e) {
        }
        return listS;
    }
    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAOimplement();
        List<Subject> list = new ArrayList<>();
        list=dao.getAllSubject();
        for (Subject course : list) {
            System.out.println(course);
            
        }
        
        
    }

    @Override
    public int getKeytoInsertCOurse(String name) {
        int key =0;
        try {
             String sql = "SELECT CourseSubjectId FROM learning_site.subjectcourse WHERE SubjectId = (SELECT SubjectId FROM learning_site.subject WHERE SubjectName = ?)";
        Connection conn = context.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            key = rs.getInt("CourseSubjectId");
        }
        } catch (Exception e) {
        }
     return key;
        
    }
}
