/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Course {
    private int courseId;
    private String courseName;
    private String courseDescription;
    private String ImageUrl;
    private LocalDate dateCreate;

    public Course() {
    }

    public Course(int courseId, String courseName, String courseDescription, LocalDate dateCreate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.dateCreate = dateCreate;
    }

    public Course(int courseId, String courseName, String courseDescription, String ImageUrl, LocalDate dateCreate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.ImageUrl = ImageUrl;
        this.dateCreate = dateCreate;
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

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", courseName=" + courseName + ", courseDescription=" + courseDescription + ", ImageUrl=" + ImageUrl + ", dateCreate=" + dateCreate + '}';
    }

    

}