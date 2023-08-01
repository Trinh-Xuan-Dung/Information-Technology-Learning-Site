/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Quiz;
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
public class QuizDAOimplement implements QuizDAO {

    Connection con;
    DBContext context = new DBContext();

    @Override
    public int AddnewQuiz(Quiz q) {
        int keygen = 0;
        try {
            con = context.getConnection();
            String sql = "INSERT INTO learning_site.quiz (QuizTopic, WeekId, QTime, QuizName) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, q.getQuizTopic());
            ps.setInt(2, q.getQuizWeekId());
            ps.setInt(3, q.getQuizTime());
            ps.setString(4, q.getQuizName());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    keygen = rs.getInt(1);
                    return keygen;
                }
            }

        } catch (Exception e) {
        }
        return keygen;
    }
    public static void main(String[] args) {
        QuizDAO dao = new QuizDAOimplement();
        int id = dao.AddnewQuiz(new Quiz(0,"151", "151",30,1));
        Quiz q = dao.getQuizById(1);
        System.out.println(q);
    }

    @Override
    public List<Quiz> getAllQuizbyWeekId(int id) {
        List<Quiz> quizzes = new ArrayList<>();
        try {
            con = context.getConnection();
            String sql = "SELECT QuizId, QuizName, QuizTopic, QTime, WeekId FROM learning_site.quiz WHERE WeekId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizId(rs.getInt("QuizId"));
                quiz.setQuizName(rs.getString("QuizName"));
                quiz.setQuizTopic(rs.getString("QuizTopic"));
                quiz.setQuizTime(rs.getInt("QTime"));
                quiz.setQuizWeekId(rs.getInt("WeekId"));
                quizzes.add(quiz);
            }
        } catch (Exception e) {
            // Handle any exceptions here
        } finally {
            // Close database connections and resources here (con, ps, rs, etc.)
        }
        return quizzes;
    }

    @Override
    public Quiz getQuizById(int i) {
        Quiz quiz =new Quiz();
        try {
            con = context.getConnection();
            String sql = "SELECT QuizId, QuizName, QuizTopic, QTime, WeekId FROM learning_site.quiz WHERE QuizId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                quiz.setQuizId(rs.getInt("QuizId"));
                quiz.setQuizName(rs.getString("QuizName"));
                quiz.setQuizTopic(rs.getString("QuizTopic"));
                quiz.setQuizTime(rs.getInt("QTime"));
                quiz.setQuizWeekId(rs.getInt("WeekId"));
                
            }
        } catch (Exception e) {
            // Handle any exceptions here
        } finally {
            // Close database connections and resources here (con, ps, rs, etc.)
        }
        return quiz;
    }

}
