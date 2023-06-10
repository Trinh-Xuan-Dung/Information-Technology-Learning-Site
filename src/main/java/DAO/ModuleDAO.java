/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entity.Module;
import java.util.List;
/**
 *
 * @author HP
 */
public interface ModuleDAO {
    public int addNewModule(int courseid,Module module);
    public List<Module> getAllModuleOfCourseByCoureid(int courseId);
     public Module getModuleOfCourseByCoureid(int moduleId);
    
    
}
