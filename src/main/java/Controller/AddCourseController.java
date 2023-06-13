/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.CourseDAOimplement;
import DAO.SubjectCourseDAO;
import DAO.SubjectCourseDAOimplement;
import DAO.SubjectDAO;
import DAO.SubjectDAOimplement;
import Entity.Course;
import Entity.Subject;
import Entity.SubjectCourse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class AddCourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     *
     *
     *
     *
     *
     *
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
            out.println("<title>Servlet AddCourse</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourse at " + request.getContextPath() + "</h1>");
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
        SubjectDAO dao = new SubjectDAOimplement();
        List<Subject> listS = new ArrayList<>();
        if (dao.getAllSubject() != null) {
            listS = dao.getAllSubject();
        }
        request.setAttribute("listSubjectToView", listS);
        request.getRequestDispatcher("AddCourse.jsp").forward(request, response);
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
        String courseName = request.getParameter("coursename");
        String[] courseSubject = request.getParameterValues("selectedSubjects");
        String couresDescription = request.getParameter("courdescription");
        String courseImgae = request.getParameter("courseimage");

        Course coureToAdd = new Course(0, courseName, courseImgae, couresDescription, LocalDate.MAX);
        CourseDAO cdao = new CourseDAOimplement();
        SubjectDAO sdao = new SubjectDAOimplement();
        int addCourse = cdao.addNewCourse(coureToAdd);

        if (addCourse != 0 && courseSubject != null) {

            List<SubjectCourse> listsc = new ArrayList<>();
            for (String subjectId : courseSubject) {
                int sjId = Integer.parseInt(subjectId);
                SubjectCourse sc = new SubjectCourse( sjId, addCourse);
                listsc.add(sc);
            }

            if (listsc != null) {
                SubjectCourseDAO scdao = new SubjectCourseDAOimplement();
                boolean finalResult = true;
                for (SubjectCourse subjectCourse : listsc) {
                    boolean result = scdao.AddToSubjectCourse(subjectCourse);
                    if (!result) {
                        finalResult = false;
                        break; // Break the loop if any insertion fails
                    }
                }

                if (finalResult == true) {
                    response.sendRedirect(request.getContextPath() + "/HomeController");
                } else {
                    response.sendRedirect(request.getContextPath() + "/AddCourse");
                }
            }

        } else {
            response.sendRedirect(request.getContextPath() + "/AddCourse.jsp");
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

}
