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
    private  Subject subject;
    private  Course course;

    public SubjectCourse() {
    }

    public SubjectCourse(int subjectCourseId, int subjectId, int courseId) {
        this.subjectCourseId = subjectCourseId;
        this.subjectId = subjectId;
        this.courseId = courseId;
    }

    public SubjectCourse(int subjectCourseId, Subject subject, Course course) {
        this.subjectCourseId = subjectCourseId;
        this.subject = subject;
        this.course = course;
    }

    public SubjectCourse(int subjectCourseId, int subjectId, int courseId, Subject subject, Course course) {
        this.subjectCourseId = subjectCourseId;
        this.subjectId = subjectId;
        this.courseId = courseId;
        this.subject = subject;
        this.course = course;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "SubjectCourse{" + "subjectCourseId=" + subjectCourseId + ", subjectId=" + subjectId + ", courseId=" + courseId + ", subject=" + subject + ", course=" + course + '}';
    }

    
    
}
