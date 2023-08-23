/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AssignmentDAO;
import DAO.AssignmentDAOimplement;

import Entity.Assignment;
import Entity.Users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebServlet(name = "AssignmentController", urlPatterns = {"/getAssignment", "/formAssignment", "/postAssignment", "/listAssignment"})
public class AssignmentController extends HttpServlet {

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
            out.println("<title>Servlet AssignmentController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AssignmentController at " + request.getContextPath() + "</h1>");
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
        String action = request.getServletPath();

        switch (action) {
            case "/listAssignment":
                listAssignment(request, response);
                break;

            case "/formAssignment":
                formAssignment(request, response);
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
        HttpSession ss = request.getSession();
        Users user = (Users) ss.getAttribute("User");
        String action = request.getServletPath();

        switch (action) {
            case "/postAssignment":
                postAssignment(request, response);
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

    private void formAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringwId = request.getParameter("wid");
        int id = Validation.Validator.parseValidId(stringwId);
        if (id != 0) {
            request.setAttribute("weekid", id);
            request.getRequestDispatcher("formAssignment.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/HomeController");
        }
    }

    private void postAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String weekId = request.getParameter("weekId");
        String assignmentTitle = request.getParameter("assignmentTitle");
        String description = request.getParameter("description");
        int id = Validation.Validator.parseValidId(weekId);
        AssignmentDAO dao = new AssignmentDAOimplement();
        // Tạo đối tượng Assignment với dữ liệu từ form
        if (id != 0) {
            Assignment assignment = new Assignment(id, assignmentTitle, description);

            int generatedId = dao.addNewAssignment(assignment);
            if (generatedId > 0) {
                // Chuyển hướng hoặc trả về kết quả thành công tùy theo yêu cầu của ứng dụng
                String successMessage = "Assignment has been added successfully.";
                request.setAttribute("successMessage", successMessage);
                request.getRequestDispatcher("formAssignment.jsp").forward(request, response);
            } else {
                String errorMessage = "An error occurred while saving the Assignment.";
                request.setAttribute("errorMessage", errorMessage);

                request.getRequestDispatcher("formAssignment.jsp").forward(request, response);
            }
        } else {
            String errorMessage = "An error occurred week. " + id;
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("formAssignment.jsp").forward(request, response);
        }

    }

    private void listAssignment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raw_weekId = request.getParameter("wid");
        String jsonString;
        ObjectMapper objectMapper = new ObjectMapper();
        
        int weekId = Validation.Validator.parseValidId(raw_weekId);
        AssignmentDAO dao = new AssignmentDAOimplement();
        if (weekId != 0) {
             List<Assignment> assignmentList = new ArrayList<>();
            assignmentList = dao.getAllAssignmentsbyWeek(weekId);
            
            try {
                jsonString = objectMapper.writeValueAsString(assignmentList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                jsonString = "[]"; // Or a default value in case of error.
            }

           
            request.setAttribute("assignments", jsonString);

            request.getRequestDispatcher("ListAssigment.jsp").forward(request, response);
        } else {
            String errorMessage = "An error occurred Assignment.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("ListAssigment.jsp").forward(request, response);
        }
    }

}
