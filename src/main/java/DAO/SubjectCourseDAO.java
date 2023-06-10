/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Course;
import Entity.SubjectCourse;
import java.util.List;

/**
 *
 * @author HP
 */
public interface SubjectCourseDAO {
    public boolean  AddToSubjectCourse(SubjectCourse sjc);
    public List<SubjectCourse> getAllSubjectCorseByCourseId(int courseId);
     public Course getSubjectJoinReleaseCorseByCourseId(int courseId);
}
