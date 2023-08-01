/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author AAdmin
 */
public class CourseEnrollment {

    private int enrollmentId;
    private int userId;
    private int courseId;
    private String enrollmentDate;

    public CourseEnrollment() {
    }

    public CourseEnrollment(int enrollmentId, int userId, int courseId, String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.userId = userId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

        public CourseEnrollment(int userId, int courseId, String enrollmentDate) {
        this.userId = userId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "CourseEnrollment{"
                + "enrollmentId=" + enrollmentId
                + ", userId=" + userId
                + ", courseId=" + courseId
                + ", enrollmentDate='" + enrollmentDate + '\''
                + '}';
    }
}
