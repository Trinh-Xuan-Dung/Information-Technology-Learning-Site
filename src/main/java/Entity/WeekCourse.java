/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class WeekCourse {
    private int weekId;
    private  int moduleId;
    private int weekNumber;
    private String weekTilte;
    private String weekDes;

    public WeekCourse() {
    }

    public WeekCourse(int weekId, int moduleId, int weekNumber, String weekTilte, String weekDes) {
        this.weekId = weekId;
        this.moduleId = moduleId;
        this.weekNumber = weekNumber;
        this.weekTilte = weekTilte;
        this.weekDes = weekDes;
    }

    public int getWeekId() {
        return weekId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getWeekTilte() {
        return weekTilte;
    }

    public void setWeekTilte(String weekTilte) {
        this.weekTilte = weekTilte;
    }

    public String getWeekDes() {
        return weekDes;
    }

    public void setWeekDes(String weekDes) {
        this.weekDes = weekDes;
    }

    @Override
    public String toString() {
        return "WeekCourse{" + "weekId=" + weekId + ", moduleId=" + moduleId + ", weekNumber=" + weekNumber + ", weekTilte=" + weekTilte + ", weekDes=" + weekDes + '}';
    }
    
}
