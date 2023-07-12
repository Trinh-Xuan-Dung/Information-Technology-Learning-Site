/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.util.Objects;
/**
 *
 * @author AAdmin
 */
public class Lesson {
    private int lessonId;
    private int weekId;
    private String title;
    private String videoPath;
    private String script;

    public Lesson() {
    }

    
    
    public Lesson(int lessonId, int weekId, String title, String videoPath, String script) {
        this.lessonId = lessonId;
        this.weekId = weekId;
        this.title = title;
        this.videoPath = videoPath;
        this.script = script;
    }
    
    public Lesson(int weekId, String title, String videoPath, String script) {
        this.weekId = weekId;
        this.title = title;
        this.videoPath = videoPath;
        this.script = script;
    }

    public int getLessonId() {
        return lessonId;
    }

    public int getWeekId() {
        return weekId;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getScript() {
        return script;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public void setScript(String script) {
        this.script = script;
    }

    
    
    // Override equals() and hashCode() methods if needed

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return lessonId == lesson.lessonId &&
                weekId == lesson.weekId &&
                Objects.equals(title, lesson.title) &&
                Objects.equals(videoPath, lesson.videoPath) &&
                Objects.equals(script, lesson.script);
    }


    // Override toString() method if needed

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", weekId=" + weekId +
                ", title='" + title + '\'' +
                ", videoPath='" + videoPath + '\'' +
                ", script='" + script + '\'' +
                '}';
    }
}
