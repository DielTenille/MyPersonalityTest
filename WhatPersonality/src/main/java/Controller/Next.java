/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
// import javax.persistence.criteria.Selection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andrenell
 */
@WebServlet(name = "Next", urlPatterns = {"/Next"})
public class Next extends HttpServlet {

  // Will use to display how many questions have been answered
  private static int pageNumber;
  private static Selections mySelection;

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
    // Create variable to store redirect url and default url
    String url = "/index.jsp";

    // get current action
    String action = request.getParameter("action");
    if (action == null) {
      action = "begin";
      url = "/index.jsp";
    }

    // Perform action and set URL to appropriate page
    if (action.equals("beginDISC")) {
      url = "/personality-questions.jsp";

      // Set initial page number
      pageNumber = 1;

      String root = getServletContext().getRealPath("/");
      mySelection = new Selections();
      mySelection.loadQuestions();
      request.getSession().setAttribute("pageNumber", pageNumber);

      mySelection.getQuestion().resetScores();
      // Get nth options and randomize
      mySelection.first();
      // mySelection.getQuestion();
      String[] options = mySelection.getQuestion().getWordsRandom();

      // Store options in Session Variable
      request.getSession().setAttribute("options", options);

      getServletContext().getRequestDispatcher(url).forward(request, response);
    } else if (action.equals("next")) {
      url = "/personality-questions.jsp";
      String choices[] = (String[])request.getSession().getAttribute("options");
      mySelection.getQuestion().addScore(choices);
      pageNumber += 1;

      if (mySelection.hasNext()) {
        mySelection.next();
        // Get nth options and randomize
        String[] options = mySelection.getQuestion().getWordsRandom();

        // Store options in Session Variable
        request.getSession().setAttribute("options", options);

        request.getSession().setAttribute("pageNumber", pageNumber);

        getServletContext().getRequestDispatcher(url).forward(request, response);
      } else {
        url = "/Report.jsp";

        String report = mySelection.getQuestion().getScores();
        request.getSession().setAttribute("report", report);
        
        //save text of type with highest score into session as topType
        String topType = mySelection.getQuestion().getType();
        request.getSession().setAttribute("topType", topType);

        getServletContext().getRequestDispatcher(url).forward(request, response);
      }
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
    processRequest(request, response);
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
