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
        Assignment a = new Assignment(5, "java", "object");
        System.out.println("reuslt: " + dao.addNewAssignment(a));        
    }
}
