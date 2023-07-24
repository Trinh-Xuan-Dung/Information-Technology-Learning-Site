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
import Logic.GetListToImportQuest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "QuizDetailController", urlPatterns = {"/QuizDetail", "/addQuestion"})
@MultipartConfig
public class QuizDetailController extends HttpServlet {

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
            out.println("<title>Servlet QuizDetailController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizDetailController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        session.removeAttribute("quizlist");
        String qidString = request.getParameter("qid");
        int id = Validation.Validator.parseValidId(qidString);
        if (id != 0) {
            QuizDAO dao = new QuizDAOimplement();
            QuestionDAO qdao = new QuestionDAOImplement();
            List<Question> listq = qdao.getAllQuestInQuizbyQizID(id);
            Quiz quiz = dao.getQuizById(id);

            if (listq.size() == 0) {

                request.removeAttribute("qs");
            } else {
                request.setAttribute("qs", listq);
            }

            request.setAttribute("quizView", quiz);
            request.getRequestDispatcher("/QuizDetail.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        session.removeAttribute("quizlist");
        
        int quizId = Validation.Validator.parseValidId(request.getParameter("quizId"));
        System.out.println(quizId);
        Part part = null;
        part=request.getPart("file");
        //  System.out.println(part);
        GetListToImportQuest ip = new GetListToImportQuest();
        List<Question> questions = ip.processFile(part, quizId);
//            for (Question question : questions) {
//                System.out.println(question);
//                System.out.println(quizId);
//
//            }
        if (questions != null) {

            session.setAttribute("quizlist", questions);
        }
        QuizDAO dao = new QuizDAOimplement();
        Quiz quiz = dao.getQuizById(quizId);
        request.setAttribute("quizView", quiz);
        request.setAttribute("qs", questions);
        request.getRequestDispatcher("/QuizDetail.jsp").forward(request, response);

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
 private void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringwId = request.getParameter("wid");
        
    }
}
