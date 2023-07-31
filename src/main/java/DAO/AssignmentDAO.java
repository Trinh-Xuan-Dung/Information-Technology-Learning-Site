/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;
import Entity.Assignment;
import java.util.List;
/**
 *
 * @author AAdmin
 */
public interface AssignmentDAO {
    public int addNewAssignment(Assignment assigment);
    public List<Assignment> getAllAssignmentsbyWeek(int weekId);
    public int updateAssignment(Assignment assigment);
    public Assignment getAssignment(int weekId,int assigmentId);
}
