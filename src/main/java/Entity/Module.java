/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class Module {
    private int moduleId;
    private int courseId;
    private String moduleName;
    private String moduleDescription;

    public Module() {
    }

    public Module(int moduleId, int courseId, String moduleName, String moduleDescription) {
        this.moduleId = moduleId;
        this.courseId = courseId;
        this.moduleName = moduleName;
        this.moduleDescription = moduleDescription;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    @Override
    public String toString() {
        return "Module{" + "moduleId=" + moduleId + ", courseId=" + courseId + ", moduleName=" + moduleName + ", moduleDescription=" + moduleDescription + '}';
    }

   

    
    
    
    
    
}
