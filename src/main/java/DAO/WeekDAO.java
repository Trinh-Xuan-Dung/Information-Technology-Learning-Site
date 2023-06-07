/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.WeekCourse;
import java.util.List;

/**
 *
 * @author HP
 */
public interface WeekDAO {
    public int AddNewWeekCOurse(int moduleId,WeekCourse week);
    public List<WeekCourse> getAllWeekByModule(int moduleId);
    
}
