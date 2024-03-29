/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.*;
import java.util.List;

/**
 *
 * @author HP
 */
public interface SubjectCourseDAO {
    //public boolean  AddToSubjectCourse(int subjectId,int courseId);
    public boolean AddToSubjectCourse(SubjectCourse sc);
    public List<SubjectCourse> getAllSubjectCorseByCourseId(int courseId);
    public Course getSubjectJoinReleaseCorseByCourseId(int courseId);
    public List<SubjectCourse> getAllOldSubjectbyCourseId(int i);
    public boolean deleteAllSubjectById(int courseId);
    public boolean addAllNewSubjectById(int courseId, List<Subject> newSubjects);
}
