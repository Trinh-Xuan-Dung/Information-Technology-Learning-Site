/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class SubjectCourse {
    private int subjectCourseId;
    private int subjectId;
    private int courseId;

    public SubjectCourse() {
    }

    public SubjectCourse(int subjectCourseId, int subjectId, int courseId) {
        this.subjectCourseId = subjectCourseId;
        this.subjectId = subjectId;
        this.courseId = courseId;
    }

    public int getSubjectCourseId() {
        return subjectCourseId;
    }

    public void setSubjectCourseId(int subjectCourseId) {
        this.subjectCourseId = subjectCourseId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "SubjectCourse{" + "subjectCourseId=" + subjectCourseId + ", subjectId=" + subjectId + ", courseId=" + courseId + '}';
    }
    
}
