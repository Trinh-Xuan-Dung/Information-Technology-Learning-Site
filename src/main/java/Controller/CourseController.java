/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.CourseDAOimplement;
import Entity.Course;
import Entity.Users;
import Entity.CourseEnrollment;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author AAdmin
 */
@WebServlet(name = "CourseController", urlPatterns = {"/listCourse", "/enrollCourse"})
public class CourseController extends HttpServlet {

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
            out.println("<title>Servlet CourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseController at " + request.getContextPath() + "</h1>");
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
            case "/listCourse":
                ListCourse(request, response);
                break;
                
            case "/enrollCourse":
                enrollCourse(request, response);
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

    private void ListCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String rawIndex = request.getParameter("index");
        int index = 0;
        if (rawIndex == null) {
            index = 1;
        } else {
            index = Integer.parseInt(rawIndex);
        }
        CourseDAO dao = new CourseDAOimplement();
//        int defaultPage = 1; 
        List<Course> list = new ArrayList<>();
        list = dao.getPagingCourse(index);
        int count = dao.getTotalCourse();
        int TotalNumPage = count / 6;
        if (count % 6 != 0) {
            TotalNumPage++;
        }

        request.setAttribute("listCToView", list);
        request.setAttribute("ViewTotalPage", TotalNumPage);
        request.setAttribute("index", index);
        request.getRequestDispatcher("listCourse.jsp").forward(request, response);
    }

    private void enrollCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raw_userid = request.getParameter("userid");
        String raw_courseid = request.getParameter("courseid");

        int userid = Validation.Validator.parseValidId(raw_userid);
        int courseid = Validation.Validator.parseValidId(raw_courseid);
        CourseDAO dao = new CourseDAOimplement();

        if (userid != 0 && courseid != 0) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            int StatusEnroll = dao.enrollCourse(userid, courseid, formattedDateTime);
            if (StatusEnroll > 0 ){
                response.sendRedirect(request.getContextPath() + "/CourseDetail?id=" + raw_userid);
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/CourseDetail?id=" + raw_userid);
        }
    }

}
