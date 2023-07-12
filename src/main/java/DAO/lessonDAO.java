/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Entity.Lesson;
import java.util.List;
/**
 *
 * @author AAdmin
 */
public interface lessonDAO {
     public List<Lesson> getAllLesson();
     public  List<Lesson> getLessonOfCourseByWeek(int id);
     public int addNewLesson(Lesson lesson);
}
