/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class Quiz {
    private int quizId;
    private String quizName;
    private String quizTopic;
    private int quizTime;
    private int quizWeekId;
    private WeekCourse quizWeek;

    public Quiz() {
    }

    public Quiz(int quizId, String quizName, String quizTopic, int quizTime, int quizWeekId) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizTopic = quizTopic;
        this.quizTime = quizTime;
        this.quizWeekId = quizWeekId;
    }

    public Quiz(int quizId, String quizName, String quizTopic, int quizTime, int quizWeekId, WeekCourse quizWeek) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizTopic = quizTopic;
        this.quizTime = quizTime;
        this.quizWeekId = quizWeekId;
        this.quizWeek = quizWeek;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizTopic() {
        return quizTopic;
    }

    public void setQuizTopic(String quizTopic) {
        this.quizTopic = quizTopic;
    }

    public int getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(int quizTime) {
        this.quizTime = quizTime;
    }

    public int getQuizWeekId() {
        return quizWeekId;
    }

    public void setQuizWeekId(int quizWeekId) {
        this.quizWeekId = quizWeekId;
    }

    public WeekCourse getQuizWeek() {
        return quizWeek;
    }

    public void setQuizWeek(WeekCourse quizWeek) {
        this.quizWeek = quizWeek;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", quizName=" + quizName + ", quizTopic=" + quizTopic + ", quizTime=" + quizTime + ", quizWeekId=" + quizWeekId + ", quizWeek=" + quizWeek + '}';
    }
    
    
    
}
