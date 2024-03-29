/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hoanglong2310
 */
public class ValidateOtpController extends HttpServlet {

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
            out.println("<title>Servlet ValidateOtpController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidateOtpController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String getValue = request.getParameter("otp");
        if (getValue == null || getValue.equals("")) {
            request.setAttribute("message", "OTP cannot be left blank!");
            request.getRequestDispatcher("EnterOtp.jsp").forward(request, response);
        } else {
            if (getValue.matches("[0-9]*") == true) {
                int pasreValueInt = Integer.parseInt(getValue);
                HttpSession session = request.getSession();
                int otp = (int) session.getAttribute("otp");
                if (pasreValueInt == otp) {
                    request.setAttribute("email", request.getParameter("email"));
                    request.setAttribute("status", "success");
                    request.getRequestDispatcher("NewPassword.jsp").forward(request, response);

                } else {
                    request.setAttribute("message", "Wrong otp");
                    request.getRequestDispatcher("EnterOtp.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "OTP code in numeric form!");
                request.getRequestDispatcher("EnterOtp.jsp").forward(request, response);
            }

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
