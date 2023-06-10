/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author HP
 */
public class Course {
    private int courseId;
    private String courseName;
    private String courseTitle;
    private String imageUrlString;
    private String courseDescription;  
    private LocalDate dateCreate;
    private List<SubjectCourse> subjects;

    public Course() {
    }

    public Course(int courseId, String courseName, String imageUrlString, String courseDescription, LocalDate dateCreate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.imageUrlString = imageUrlString;
        this.courseDescription = courseDescription;
        this.dateCreate = dateCreate;
    }

    public Course(int courseId, String courseName, String imageUrlString, String courseDescription, LocalDate dateCreate, List<SubjectCourse> subjects) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.imageUrlString = imageUrlString;
        this.courseDescription = courseDescription;
        this.dateCreate = dateCreate;
        this.subjects = subjects;
    }

    public Course(int courseId, String courseName, String courseTitle, String imageUrlString, String courseDescription, LocalDate dateCreate, List<SubjectCourse> subjects) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTitle = courseTitle;
        this.imageUrlString = imageUrlString;
        this.courseDescription = courseDescription;
        this.dateCreate = dateCreate;
        this.subjects = subjects;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImageUrlString() {
        return imageUrlString;
    }

    public void setImageUrlString(String imageUrlString) {
        this.imageUrlString = imageUrlString;
    }



    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }


    public List<SubjectCourse> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectCourse> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseName=" + courseName + ", courseTitle=" + courseTitle + ", imageUrlString=" + imageUrlString + ", courseDescription=" + courseDescription + ", dateCreate=" + dateCreate + ", subjects=" + subjects + '}';
    }


    
   
    
    
}
