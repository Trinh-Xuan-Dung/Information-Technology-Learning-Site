/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Course;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CourseDAO {
    public List<Course> getAllCourse();
    public int addNewCourse(Course course);
    public Course getCourseById(int courseId);
    public boolean UpdateCourseById(Course course);
    public List<Course> getAllCourseJoin();
    public List<Course> getAllCourseJoin1();
     public Course getCourseJoin(int courseId);
    
}
