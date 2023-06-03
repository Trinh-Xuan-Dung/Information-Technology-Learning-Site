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
    private String ModuleName;
    private String ModuleDescription;

    public Module() {
    }

    public Module(int moduleId, int courseId, String ModuleName, String ModuleDescription) {
        this.moduleId = moduleId;
        this.courseId = courseId;
        this.ModuleName = ModuleName;
        this.ModuleDescription = ModuleDescription;
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
        return ModuleName;
    }

    public void setModuleName(String ModuleName) {
        this.ModuleName = ModuleName;
    }

    public String getModuleDescription() {
        return ModuleDescription;
    }

    public void setModuleDescription(String ModuleDescription) {
        this.ModuleDescription = ModuleDescription;
    }

    @Override
    public String toString() {
        return "Module{" + "moduleId=" + moduleId + ", courseId=" + courseId + ", ModuleName=" + ModuleName + ", ModuleDescription=" + ModuleDescription + '}';
    }
    
    
    
    
}
