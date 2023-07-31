/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AssignmentDAO;
import DAO.AssignmentDAOimplement;
import Entity.Assignment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hoan
 */
@WebServlet(name = "UpdateAssignment", urlPatterns = {"/UpdateAssignment"})
public class UpdateAssignment extends HttpServlet {

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
            out.println("<title>Servlet UpdateAssignment</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAssignment at " + request.getContextPath() + "</h1>");
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
        String weekId = request.getParameter("weekId");
        String assId = request.getParameter("assignmentId");
        AssignmentDAO dao = new AssignmentDAOimplement();
        Assignment ass = dao.getAssignment(Integer.parseInt(weekId), Integer.parseInt(assId));
        request.setAttribute("ass", ass);
        request.getRequestDispatcher("UpdateAssignment.jsp").forward(request, response);
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
        String weekId = request.getParameter("weekId");
        String assId = request.getParameter("assignmentId");
        String assignmentTitle = request.getParameter("assignmentTitle");
        String description = request.getParameter("description");
        AssignmentDAO dao = new AssignmentDAOimplement();
        Assignment ass = new Assignment(Integer.parseInt(weekId), assignmentTitle, description, Integer.parseInt(assId));
        dao.updateAssignment(ass);
        request.setAttribute("ass", ass);
        request.getRequestDispatcher("UpdateAssignment.jsp").forward(request, response);
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
