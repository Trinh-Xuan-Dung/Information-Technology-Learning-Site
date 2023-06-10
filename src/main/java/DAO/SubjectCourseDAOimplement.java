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

/**
 *
 * @author HP
 */
public class SubjectCourseDAOimplement implements SubjectCourseDAO {

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

    @Override
    public Course getSubjectJoinReleaseCorseByCourseId(int courseId) {
        List<SubjectCourse> subjectCourseList = new ArrayList<>();
        Course course = new Course();
        try {
            String sql = "select Course.CourseId,Course.CourseName, Course.Image, Course.CourseDescription,Subject.SubjectId "
                    + ", Subject.SubjectName, Subject.SubjectDescription,SubjectCourse.CourseSubjectId "
                    + "FROM Course "
                    + "JOIN SubjectCourse ON Course.CourseId = SubjectCourse.CourseId "
                    + "JOIN Subject ON SubjectCourse.SubjectId = Subject.SubjectId WHERE Course.CourseId = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SubjectCourse sc = new SubjectCourse();
                sc.setSubjectCourseId(rs.getInt("CourseSubjectId"));
                sc.setSubjectId(rs.getInt("SubjectId"));
                sc.setCourseId(rs.getInt("CourseId"));
                
                sc.setSubject(new Subject(rs.getInt("SubjectId"), rs.getString("SubjectName"), rs.getString("SubjectDescription")));
                subjectCourseList.add(sc);

                if (rs.isLast()) {

                    course.setCourseId(rs.getInt("CourseId"));
                    course.setCourseName(rs.getString("CourseName"));
                    course.setImageUrlString(rs.getString("Image"));
                    course.setCourseDescription(rs.getString("CourseDescription"));
                    course.setSubjects(subjectCourseList);
                }

            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }

    public static void main(String[] args) {
        SubjectCourseDAO dao = new SubjectCourseDAOimplement();
        Course c = dao.getSubjectJoinReleaseCorseByCourseId(1);
        System.out.println(c);
    }

}
