/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.CourseDAOimplement;
import DAO.LessonDAOimplement;
import DAO.lessonDAO;
import DAO.WeekDAO;
import DAO.WeekDAOimplement;
import Entity.Lesson;
import Entity.Users;
import Entity.WeekCourse;
import Validation.Validator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AAdmin
 */
@WebServlet(name = "LessonController", urlPatterns = {"/listLesson", "/createLesson", "/postLesson"})
/*@WebServlet(name = "LessonController", urlPatterns = {"/createLesson"})*/
public class LessonController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LessonController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LessonController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ss = request.getSession();
        Users user = (Users) ss.getAttribute("User");
        String action = request.getServletPath();

        switch (action) {
            case "/listLesson":
                ListLesson(request, response);
                break;
            case "/createLesson":
                createLesson(request, response);
                break;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/postLesson":
                postLesson(request, response);
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void ListLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringwId = request.getParameter("wid");
        int id = Validation.Validator.parseValidId(stringwId);
        List<Lesson> listLesson = new ArrayList<>();

        if (id != 0) {
            WeekDAO dao = new WeekDAOimplement();
            lessonDAO daoL = new LessonDAOimplement();
            WeekCourse week = dao.getWeekByWId(id);
            listLesson = daoL.getLessonOfCourseByWeek(id);

            request.setAttribute("weekToView", week);
            request.setAttribute("listL", listLesson);
            request.getRequestDispatcher("/lesson/lesson.jsp").forward(request, response);
        }
    }

    private void createLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringwId = request.getParameter("wid");
        int id = Validation.Validator.parseValidId(stringwId);
        if (id != 0) {
            request.setAttribute("weekid", id);
        }
        request.getRequestDispatcher("/lesson/formLesson.jsp").forward(request, response);
    }

    private void postLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String weekId = request.getParameter("weekId");
        String title = request.getParameter("title");
        String videoPath = request.getParameter("videoPath");
        String script = request.getParameter("script");

        lessonDAO daoL = new LessonDAOimplement();

        if (Validator.checkIdIsValid(weekId)) {
            int wid = Integer.parseInt(weekId);
            String idY = Validator.getIdYoutube(videoPath);
            Lesson newLesson = new Lesson(wid, title, idY, script);
            int generatedId = daoL.addNewLesson(newLesson);
            if (generatedId > 0) {
                response.sendRedirect(request.getContextPath() + "/createLesson?wid=" + weekId);
            }
        }
    }

}
