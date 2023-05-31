/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class Subject {
    private int subjectId;
    private String subjectName;
    private String SubjectDescription;

    public Subject() {
    }

    public Subject(int subjectId, String subjectName, String SubjectDescription) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.SubjectDescription = SubjectDescription;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescription() {
        return SubjectDescription;
    }

    public void setSubjectDescription(String SubjectDescription) {
        this.SubjectDescription = SubjectDescription;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectId=" + subjectId + ", subjectName=" + subjectName + ", SubjectDescription=" + SubjectDescription + '}';
    }
    
    
}
