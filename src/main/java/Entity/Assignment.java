/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author AAdmin
 */
public class Assignment {

    private int assignmentId;
    private int weekId;
    private String assignmentTitle;
    private String description;

    public Assignment() {
    }

    public Assignment(int assignmentId, int weekId, String assignmentTitle, String description) {
        this.assignmentId = assignmentId;
        this.weekId = weekId;
        this.assignmentTitle = assignmentTitle;
        this.description = description;
    }
    
    public Assignment(int weekId, String assignmentTitle, String description, int assignmentId) {
        this.assignmentId = assignmentId;
        this.weekId = weekId;
        this.assignmentTitle = assignmentTitle;
        this.description = description;
    }
    
    public Assignment(String assignmentTitle, String description) {
        this.assignmentTitle = assignmentTitle;
        this.description = description;
    }
    
    public Assignment(int weekId, String assignmentTitle, String description) {
        this.weekId = weekId;
        this.assignmentTitle = assignmentTitle;
        this.description = description;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Assignment{"
                + "assignmentId=" + assignmentId
                + ", weekId=" + weekId
                + ", assignmentTitle='" + assignmentTitle + '\''
                + ", description='" + description + '\''
                + '}';
    }
}
