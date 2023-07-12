/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.QuestionDAO;
import DAO.QuestionDAOImplement;
import DAO.QuizDAO;
import DAO.QuizDAOimplement;
import Entity.Question;
import Entity.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "SaveQuesImportController", urlPatterns = {"/SaveQuesImport"})
public class SaveQuesImportController extends HttpServlet {

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
            out.println("<title>Servlet SaveQuesImportController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveQuesImportController at " + request.getContextPath() + "</h1>");
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
       
        int id = Validation.Validator.parseStringToInt(request.getParameter("quizId"));
          System.out.println("id"+id);
        HttpSession sesson = request.getSession();
        List<Question> listq = (List<Question>) sesson.getAttribute("quizlist");
        System.out.println("lít"+listq);
        if(id!=0){
          
            if(listq!=null){
            QuestionDAO dao= new QuestionDAOImplement();
            int numid=dao.addListQuestTionByQuizID(id, listq);
            if(numid>0){
                sesson.removeAttribute("quizlist");
            }
                    
            System.out.println("numid"+numid);
            QuizDAO qdao = new QuizDAOimplement();
            Quiz quiz = qdao.getQuizById(id);
            request.setAttribute("quizView", quiz);
            request.setAttribute("qs", listq);
            request.getRequestDispatcher("/QuizDetail.jsp").forward(request, response);
            
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
