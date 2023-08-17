/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import DAO.UserDAOImplement;
import Entity.Users;
import Utils.SessionUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hoanglong2310
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            String u = null;
            String p = null;
            String r = null;
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().trim().equals("username")) {
                    u = cookies[i].getValue();
                }
                if (cookies[i].getName().trim().equals("password")) {
                    p = cookies[i].getValue();
                }
                if (cookies[i].getName().trim().equals("remember")) {
                    r = cookies[i].getValue();
                }
            }
            request.setAttribute("username", u);
            request.setAttribute("password", p);
            request.setAttribute("remember", r);

            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        UserDAO userDao = new UserDAOImplement();
//        if(username.matches("^(?=.{8,255}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$") == false){
//            request.setAttribute("MESSAGE", "Username 8-255 characters and no special characters!");
//            request.getRequestDispatcher("Login.jsp").forward(request, response);
//        }
        if (username == null || username.equals("")) {
            request.setAttribute("MESSAGE", "Please enter a username!");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (password == null || password.equals("")) {
            request.setAttribute("MESSAGE", "Please enter a password!");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            if (userDao.checkUserExist(username) == true) {
                Users user = userDao.SignIn(username, password);
                if (user != null) {
                    SessionUtils.getInstance().putValue(request, "user", user);
                    Cookie cUsername = new Cookie("username", username);
                    Cookie cPassword = new Cookie("password", password);
                    Cookie cRemember = new Cookie("remember", remember);
                    if (remember != null) {
                        cUsername.setMaxAge(60 * 60);
                        cPassword.setMaxAge(60 * 60);
                        cRemember.setMaxAge(60 * 60);
                    } else {
                        cUsername.setMaxAge(0);
                        cPassword.setMaxAge(0);
                        cRemember.setMaxAge(0);
                    }
                    response.addCookie(cUsername);
                    response.addCookie(cPassword);
                    response.addCookie(cRemember);
                    response.sendRedirect(request.getContextPath() + "/HomeController");
                    //check roles
                } else {
                    request.setAttribute("MESSAGE", "Username or password is incorrect!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("MESSAGE", "Username is not registered!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
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
