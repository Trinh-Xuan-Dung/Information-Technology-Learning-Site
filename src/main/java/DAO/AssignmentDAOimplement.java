/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Context.DBContext;
import Entity.Assignment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AAdmin
 */
public class AssignmentDAOimplement implements AssignmentDAO {

    DBContext context = new DBContext();

    @Override
    public int addNewAssignment(Assignment assignment) {
        int generatedId = 0;
        try {
            Connection con = context.getConnection();
            String sql = "INSERT INTO assignment (WeekId, AssignmentTitle, Description) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, assignment.getWeekId());
            ps.setString(2, assignment.getAssignmentTitle());
            ps.setString(3, assignment.getDescription());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1);
                }
            }

        } catch (Exception e) {
            // Xử lý ngoại lệ
        }
        return generatedId;
    }

    public static void main(String[] args) {
        AssignmentDAO dao = new AssignmentDAOimplement();
        List<Assignment> list = new ArrayList<>();
        list = dao.getAllAssignmentsbyWeek(5);
//        System.out.println("reuslt: " + dao.addNewAssignment(a));
        
        for (Assignment b : list) {
            System.out.println("Assignment: "+ b);
        }
    }

    @Override
    public List<Assignment> getAllAssignmentsbyWeek(int weekId) {
        List<Assignment> assignmentList = new ArrayList<>();

        try {
            Connection conn = context.getConnection();
            String sql = "SELECT AssignmentId, WeekId, AssignmentTitle, Description FROM assignment WHERE WeekId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, weekId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int assignmentId = rs.getInt("AssignmentId");
                int fetchedWeekId = rs.getInt("WeekId");
                String assignmentTitle = rs.getString("AssignmentTitle");
                String description = rs.getString("Description");

                Assignment assignment = new Assignment(assignmentId, fetchedWeekId, assignmentTitle, description);
                assignmentList.add(assignment);
            }

            rs.close();
            pstmt.close();
        } catch (Exception e) {
            // Exception handling code (if any) would go here
        }

        return assignmentList;
    }
}
