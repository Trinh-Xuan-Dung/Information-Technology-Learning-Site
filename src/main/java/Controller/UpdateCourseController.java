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
public class UpdateCourseController extends HttpServlet {

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
            out.println("<title>Servlet UpdateCourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCourseController at " + request.getContextPath() + "</h1>");
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
        CourseDAO daoc = new CourseDAOimplement();

        String stringId = request.getParameter("id");

        List<Subject> listS = new ArrayList<>();

        if (dao.getAllSubject() != null) {
            listS = dao.getAllSubject();
        }
        int id = 0;
        if (Validation.Validator.checkIdIsValid(stringId)) {
            id = Integer.parseInt(stringId);
        }

        Course course = daoc.getCourseJoin(id);
        request.setAttribute("listSubjectToView", listS);
        request.setAttribute("courseId", id);

        request.setAttribute("oldCourse", course);
        request.getRequestDispatcher("UpdateCourse.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        String stringId = req.getParameter("courseidupdate");
        String name = req.getParameter("coursenameupdate");
        String imageUrl = req.getParameter("courseimageupdate");
        String[] selectedSubjects = req.getParameterValues("selectedSubjects");
        List<Subject> subjectWID = new ArrayList<>();

        if (selectedSubjects != null) {
            for (String subjectId : selectedSubjects) {
                if (subjectId != null && !subjectId.isEmpty()) {
                    int sid = Integer.parseInt(subjectId);
                    subjectWID.add(new Subject(sid));
                }
            }
        }

        String description = req.getParameter("courdescriptionupdate");
        int id = 0;
        if (Validation.Validator.checkIdIsValid(stringId)) {
            id = Integer.parseInt(stringId);
        }
        CourseDAO dao = new CourseDAOimplement();
        SubjectCourseDAO daos = new SubjectCourseDAOimplement();
        Course course = new Course(id, name, imageUrl, description, null);
        boolean f = dao.UpdateCourseById(course);
        f = daos.deleteAllSubjectById(id);
        f = daos.addAllNewSubjectById(id, subjectWID);

        if (f) {

            response.sendRedirect(req.getContextPath() + "/HomeController");
        } else {
            response.sendRedirect(req.getContextPath() + "/UpdateCourse");
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
