/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Lesson;
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
 * @author AAdmin
 */
public class LessonDAOimplement implements lessonDAO {

    DBContext context = new DBContext();
    Connection con;

    @Override
    public List<Lesson> getLessonOfCourseByWeek(int i) {
        List<Lesson> listLesson = new ArrayList<>();
        try {
            con = context.getConnection();
            String sql = "SELECT LessonId, WeekId, Title, VideoPath, Script FROM lesson WHERE WeekId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Lesson lesson = new Lesson(rs.getInt("LessonId"),
                        rs.getInt("WeekId"), rs.getString("Title"),
                        rs.getString("VideoPath"), rs.getString("Script"));
                listLesson.add(lesson);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(LessonDAOimplement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listLesson;
    }

    public int addNewLesson(Lesson lesson) {
        int generatedId = 0;
        try {
            String sql = "INSERT INTO lesson (WeekId, Title, VideoPath, Script) VALUES (?, ?, ?, ?)";
            Connection conn = context.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, lesson.getWeekId());
            ps.setString(2, lesson.getTitle());
            ps.setString(3, lesson.getVideoPath());
            ps.setString(4, lesson.getScript());
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

    public static void main(String[] args) {
        lessonDAO dao = new LessonDAOimplement();
        List<Lesson> d = dao.getLessonOfCourseByWeek(5);
        for (Lesson les : d) {
            System.err.println(les);
        }
    }

    @Override
    public List<Lesson> getAllLesson() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
