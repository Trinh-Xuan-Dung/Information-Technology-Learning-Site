/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Course;
import Entity.CourseEnrollment;
import Entity.Subject;
import Entity.SubjectCourse;
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            String sql = "SELECT CourseId, CourseName, Image, CourseDescription, DateCreate,CourseTitle FROM learning_site.course";
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
            } else {
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(CourseDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Course> getAllCourseJoin() {
        List<Course> courses = new ArrayList<>();

        try {
            String sql = "SELECT Course.CourseId, Course.CourseName, Course.Image, Course.CourseDescription, Course.DateCreate, Course.CourseTitle, "
                    + "SubjectCourse.SubjectId, "
                    + "Subject.SubjectName, Subject.SubjectDescription "
                    + "FROM Course "
                    + "left JOIN SubjectCourse ON Course.CourseId = SubjectCourse.CourseId "
                    + "left JOIN Subject ON SubjectCourse.SubjectId = Subject.SubjectId";
            System.out.println(sql);
            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            Map<Integer, Course> courseMap = new HashMap<>();

            while (rs.next()) {
                int courseId = rs.getInt("CourseId");

                if (!courseMap.containsKey(courseId)) {
                    Course course = new Course();
                    course.setCourseId(courseId);
                    course.setCourseName(rs.getString("CourseName"));
                    course.setCourseTitle(rs.getString("CourseTitle"));
                    course.setImageUrlString(rs.getString("Image"));
                    course.setCourseDescription(rs.getString("CourseDescription"));
                    course.setDateCreate(rs.getDate("DateCreate").toLocalDate());
                    List<SubjectCourse> s = new ArrayList<>();
                    course.setSubjects(s);
                    courseMap.put(courseId, course);
                }

                SubjectCourse subjectCourse = new SubjectCourse();
                subjectCourse.setSubjectId(rs.getInt("SubjectId"));
                subjectCourse.setSubject(new Subject(rs.getInt("SubjectId"), rs.getString("SubjectName"), rs.getString("SubjectDescription")));

                Course course = courseMap.get(courseId);
                course.getSubjects().add(subjectCourse);
            }

            courses.addAll(courseMap.values());

            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAOimplement();
        List<Course> list = new ArrayList<>();
//        list = dao.getPagingCourse(2);
//        for (Course course : list) {
//            System.out.println(course);
//        }    
        System.out.println(dao.getTotalCourse());
    }

    @Override
    public Course getCourseJoin(int courseId) {
        Course course = null;

        try {
            String sql = "SELECT Course.CourseId, Course.CourseName, Course.Image, Course.CourseDescription, Course.DateCreate, Course.CourseTitle, "
                    + "SubjectCourse.SubjectId, "
                    + "Subject.SubjectName, Subject.SubjectDescription "
                    + "FROM Course "
                    + "left JOIN SubjectCourse ON Course.CourseId = SubjectCourse.CourseId "
                    + "left JOIN Subject ON SubjectCourse.SubjectId = Subject.SubjectId "
                    + "WHERE Course.CourseId = ? ";

            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();

            Map<Integer, Course> courseMap = new HashMap<>();

            while (rs.next()) {
                int currentCourseId = rs.getInt("CourseId");

                if (!courseMap.containsKey(currentCourseId)) {
                    course = new Course();
                    course.setCourseId(currentCourseId);
                    course.setCourseName(rs.getString("CourseName"));
                    course.setCourseTitle(rs.getString("CourseTitle"));
                    course.setImageUrlString(rs.getString("Image"));
                    course.setCourseDescription(rs.getString("CourseDescription"));
                    course.setDateCreate(rs.getDate("DateCreate").toLocalDate());
                    List<SubjectCourse> subjects = new ArrayList<>();
                    course.setSubjects(subjects);
                    courseMap.put(currentCourseId, course);
                }

                SubjectCourse subjectCourse = new SubjectCourse();
                subjectCourse.setSubjectId(rs.getInt("SubjectId"));
                subjectCourse.setSubject(new Subject(rs.getInt("SubjectId"), rs.getString("SubjectName"), rs.getString("SubjectDescription")));

                course = courseMap.get(currentCourseId);
                course.getSubjects().add(subjectCourse);
            }

            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }

    private Course findCourseById(List<Course> courses, int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllCourseJoin1() {
        List<Course> courses = new ArrayList<>();

        try {
            String sql = "SELECT Course.CourseId, Course.CourseName, Course.Image, Course.CourseDescription, Course.DateCreate, Course.CourseTitle, "
                    + "SubjectCourse.SubjectId, "
                    + "Subject.SubjectName, Subject.SubjectDescription "
                    + "FROM Course "
                    + "JOIN SubjectCourse ON Course.CourseId = SubjectCourse.CourseId "
                    + "JOIN Subject ON SubjectCourse.SubjectId = Subject.SubjectId";

            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseId = rs.getInt("CourseId");

                // Check if the course already exists in the list
                Course existingCourse = findCourseById(courses, courseId);

                if (existingCourse == null) {
                    Course course = new Course();
                    course.setCourseId(courseId);
                    course.setCourseName(rs.getString("CourseName"));
                    course.setCourseTitle(rs.getString("CourseTitle"));
                    course.setImageUrlString(rs.getString("Image"));
                    course.setCourseDescription(rs.getString("CourseDescription"));
                    course.setDateCreate(rs.getDate("DateCreate").toLocalDate());
                    List<SubjectCourse> subjects = new ArrayList<>();
                    course.setSubjects(subjects);
                    courses.add(course);
                    existingCourse = course;
                }

                SubjectCourse subjectCourse = new SubjectCourse();
                subjectCourse.setSubjectId(rs.getInt("SubjectId"));
                subjectCourse.setSubject(new Subject(rs.getInt("SubjectId"), rs.getString("SubjectName"), rs.getString("SubjectDescription")));

                existingCourse.getSubjects().add(subjectCourse);
            }

            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public List<Course> getPagingCourse(int index) {
        List<Course> courses = new ArrayList<>();
        int limitCourse = 6;
        int offset = ((index - 1) * limitCourse);

        try {

            String sql = "SELECT Course.CourseId, Course.CourseName, Course.Image, Course.CourseDescription, Course.DateCreate, Course.CourseTitle, "
                    + "SubjectCourse.SubjectId, "
                    + "Subject.SubjectName, Subject.SubjectDescription "
                    + "FROM ( select * from Course limit " + offset + ", " + limitCourse + ") as Course "
                    + "left JOIN SubjectCourse ON Course.CourseId = SubjectCourse.CourseId "
                    + "left JOIN Subject ON SubjectCourse.SubjectId = Subject.SubjectId";

            Connection con = context.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseId = rs.getInt("CourseId");

                // Check if the course already exists in the list
                Course existingCourse = findCourseById(courses, courseId);

                if (existingCourse == null) {
                    Course course = new Course();
                    course.setCourseId(courseId);
                    course.setCourseName(rs.getString("CourseName"));
                    course.setCourseTitle(rs.getString("CourseTitle"));
                    course.setImageUrlString(rs.getString("Image"));
                    course.setCourseDescription(rs.getString("CourseDescription"));
                    course.setDateCreate(rs.getDate("DateCreate").toLocalDate());
                    List<SubjectCourse> subjects = new ArrayList<>();
                    course.setSubjects(subjects);
                    courses.add(course);
                    existingCourse = course;
                }

                SubjectCourse subjectCourse = new SubjectCourse();
                subjectCourse.setSubjectId(rs.getInt("SubjectId"));
                subjectCourse.setSubject(new Subject(rs.getInt("SubjectId"), rs.getString("SubjectName"), rs.getString("SubjectDescription")));

                existingCourse.getSubjects().add(subjectCourse);
            }

            rs.close();
            ps.close();
            con.close(); // Close the connection

        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }

    public int getTotalCourse() {
        int total = 0;

        try {
            Connection conn = context.getConnection();
            String sql = "SELECT count(*) FROM learning_site.course";
            // ResultSet rs =  context.getDataByRawSQL(sql);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    ;

    @Override
    public int enrollCourse(int userId, int courseId, String enrollmentDate) {
        int generatedId = 0;
        try {
            String sql = "INSERT INTO CourseEnrollment (UserId, CourseId, EnrollmentDate) VALUES (?, ?, ?)";
            Connection conn = context.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            ps.setString(3, enrollmentDate);

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    

}
