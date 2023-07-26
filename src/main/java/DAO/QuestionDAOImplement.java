/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Question;
import com.mysql.cj.protocol.Resultset;
import java.sql.Array;
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
public class QuestionDAOImplement extends DBContext implements QuestionDAO {

    @Override
    public int addListQuestTionByQuizID(int qId, List<Question> listq) {
        int count = 0;
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO learning_site.questions (QuizId, QContent, OptionA, AnswerA, OptionB, AnswerB, OptionC, AnswerC, OptionD, AnswerD) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            int size = listq.size();
            if (size > 0) {
                for (int i = 0; i < sql.charAt(i); i++) {
                    ps.setInt(1, qId);
                    ps.setString(2, listq.get(i).getQuestContent());
                    ps.setString(3, listq.get(i).getOptionA());
                    ps.setBoolean(4, listq.get(i).isAnswerA());
                    ps.setString(5, listq.get(i).getOptionB());
                    ps.setBoolean(6, listq.get(i).isAnswerB());
                    ps.setString(7, listq.get(i).getOptionC());
                    ps.setBoolean(8, listq.get(i).isAnswerC());
                    ps.setString(9, listq.get(i).getOptionD());
                    ps.setBoolean(10, listq.get(i).isAnswerD());
                    int id = ps.executeUpdate();
                    if (id > 0) {
                        count++;
                    }
                }

            }

        } catch (Exception e) {
        }
        return count;
    }

    @Override
    public List<Question> getAllQuestInQuizbyQizID(int i) {
        List<Question> listq = new ArrayList<>();
        try {
            Connection con = getConnection();
            String sql = "SELECT Id, QuizId, QContent,"
                    + " OptionA, AnswerA, OptionB, AnswerB, OptionC, AnswerC, OptionD, AnswerD FROM learning_site.questions Where QuizId =? ";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question();
                q.setQestId(rs.getInt(1));
                q.setQuizId(rs.getInt(2));
                q.setQuestContent(rs.getString(3));
                q.setOptionA(rs.getString(4));
                q.setAnswerA(rs.getBoolean(5));
                q.setOptionB(rs.getString(6));
                q.setAnswerB(rs.getBoolean(7));
                q.setOptionC(rs.getString(8));
                q.setAnswerC(rs.getBoolean(9));
                q.setOptionD(rs.getString(10));
                q.setAnswerD(rs.getBoolean(11));
                listq.add(q);
            }
            con.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listq;
    }

    @Override
    public int addQuestionById(int i, Question qstn) {
            int keyGenerated = 0;
    try {
            Connection con = getConnection();
            String sql = "INSERT INTO learning_site.questions (QuizId, QContent, OptionA, AnswerA, OptionB, AnswerB, OptionC, AnswerC, OptionD, AnswerD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, i);
            ps.setString(2, qstn.getQuestContent());
            ps.setString(3, qstn.getOptionA());
            ps.setBoolean(4, qstn.isAnswerA());
            ps.setString(5, qstn.getOptionB());
            ps.setBoolean(6, qstn.isAnswerB());
            ps.setString(7, qstn.getOptionC());
            ps.setBoolean(8, qstn.isAnswerC());
            ps.setString(9, qstn.getOptionD());
            ps.setBoolean(10, qstn.isAnswerD());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    keyGenerated = generatedKeys.getInt(1);
                }
            }

            con.close(); // Don't forget to close the connection after usage.

        } catch (Exception e) {
            e.printStackTrace(); // It's essential to handle exceptions properly, at least print the stack trace.
        }
        return keyGenerated;
    }

}
