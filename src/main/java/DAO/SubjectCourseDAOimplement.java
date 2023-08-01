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
    public List<SubjectCourse> getAllSubjectCorseByCourseId(int courseId) {
        List<SubjectCourse> subjectCourseList = new ArrayList<>();

        try {
            String sql = "SELECT  SubjectId, CourseId FROM SubjectCourse WHERE CourseId = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SubjectCourse subjectCourse = new SubjectCourse();
                subjectCourse.setSubjectId(rs.getInt("SubjectId"));
                subjectCourse.setCourseId(rs.getInt("CourseId"));
                subjectCourseList.add(subjectCourse);
            }

            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }

        return subjectCourseList;
    }

    @Override
    public Course getSubjectJoinReleaseCorseByCourseId(int courseId) {
        Course course = new Course();
        List<SubjectCourse> subjectCourseList = new ArrayList<>();

        try {
            String sql = "SELECT Course.CourseId, Course.CourseName, Course.Image, Course.CourseDescription, "
                    + "Subject.SubjectId, Subject.SubjectName, Subject.SubjectDescription "
                    + "FROM Course "
                    + "left JOIN SubjectCourse ON Course.CourseId = SubjectCourse.CourseId "
                    + "left JOIN Subject ON SubjectCourse.SubjectId = Subject.SubjectId "
                    + "WHERE Course.CourseId = ?";

            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int currentCourseId = rs.getInt("CourseId");

                if (course.getCourseId() != currentCourseId) {
                    course.setCourseId(currentCourseId);
                    course.setCourseName(rs.getString("CourseName"));
                    course.setImageUrlString(rs.getString("Image"));
                    course.setCourseDescription(rs.getString("CourseDescription"));
                }

                SubjectCourse subjectCourse = new SubjectCourse();

                subjectCourse.setSubjectId(rs.getInt("SubjectId"));

                Subject subject = new Subject();
                subject.setSubjectId(rs.getInt("SubjectId"));
                subject.setSubjectName(rs.getString("SubjectName"));
                subject.setSubjectDescription(rs.getString("SubjectDescription"));
                subjectCourse.setSubject(subject);

                subjectCourseList.add(subjectCourse);
            }

            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }

        course.setSubjects(subjectCourseList);
        return course;
    }

    

    @Override
    public List<SubjectCourse> getAllOldSubjectbyCourseId(int i) {
        CourseDAO dao = new CourseDAOimplement();
        List<SubjectCourse> listSC = dao.getCourseJoin(i).getSubjects();
        return listSC;
    }

    @Override
    public boolean deleteAllSubjectById(int courseId) {
        try {
            String sql = "DELETE FROM SubjectCourse WHERE CourseId = ?";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean addAllNewSubjectById(int courseId, List<Subject> newSubjects) {
        try {
            String sql = "INSERT INTO SubjectCourse (SubjectId, CourseId) VALUES (?, ?) ";
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            for (Subject subject : newSubjects) {
                ps.setInt(1, subject.getSubjectId());
                ps.setInt(2, courseId);
                ps.addBatch();
            }

            int[] rowsInserted = ps.executeBatch();
            return rowsInserted.length == newSubjects.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        SubjectCourseDAO dao = new SubjectCourseDAOimplement();
       
    }
}
