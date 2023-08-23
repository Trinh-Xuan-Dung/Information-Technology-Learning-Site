/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AddressDAO;
import DAO.AddressDAOimplement;
import DAO.UserDAO;
import DAO.UserDAOImplement;
import DAO.UserRoleDAO;
import DAO.UserRoleDAOImplement;
import Entity.Address;
import Entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "RegisterCotroller", urlPatterns = {"/Register"})
public class RegisterCotroller extends HttpServlet {

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
            out.println("<title>Servlet RegisterCotroller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterCotroller at " + request.getContextPath() + "</h1>");
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
        Users user = (Users) request.getSession().getAttribute("user");
        if(user==null){
            request.removeAttribute("Message");
        response.sendRedirect(request.getContextPath() + "/Register.jsp");
        }else{
             response.sendRedirect(request.getContextPath() + "/HomeController");
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
        String userName = request.getParameter("Username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        Users user = new Users(0, userName, pass, email, 0);
        AddressDAO adao = new AddressDAOimplement();
        UserDAO dao = new UserDAOImplement();
        if (dao.getUserExsit(userName) == null) {
            int addressId = adao.AddNewAddress(new Address());

            int userId = 0;
            if (addressId != 0) {
                user.setAddressId(addressId);
                userId = dao.AddNewUser(user);
            } else {
                userId = dao.AddNewUser(user);
            }
            if (userId != 0) {
                UserRoleDAO role=new UserRoleDAOImplement();
                role.addUserRoleWhenRegis(userId, 1);
                HttpSession sess = request.getSession();
                sess.setAttribute("user", user);
                int min = 60;
                sess.setMaxInactiveInterval(10 * min);
                response.sendRedirect(request.getContextPath() + "/HomeController");
            } else {
                response.sendRedirect(request.getContextPath() + "/Register.jsp");
            }
        } else {
            System.out.println("heelo");
            request.setAttribute("Message", "your username you input is exsit!");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);

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