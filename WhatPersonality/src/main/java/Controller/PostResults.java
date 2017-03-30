/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.PostUpdate;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author milo
 */
@WebServlet(name = "PostResults", urlPatterns = {"/PostResults"})
public class PostResults extends HttpServlet {

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
        String postImg;
        String sharedImg = (String)request.getSession().getAttribute("topType");
        switch (sharedImg) {
            case "Dominant":
                postImg = "/Resources/D-Personality-Style.PNG";
                break;
            case "Influencer":
                postImg = "/Resources/I-Personality-Style.PNG";
                break;
            case "Sensitive":
                postImg = "/Resources/S-Personality-Style.PNG";
                break;
            case "Compliant":
                postImg = "/Resources/C-Personality-Style.PNG";
                break;
            default:
                postImg = "/Resources/313ScreenShot.PNG";
                break;
        }
        
        PostUpdate post = new PostUpdate(new URL("https://glacial-fortress-25541.herokuapp.com/"))
//                .picture(new URL("http://localhost:8080/" + request.getContextPath()+ postImg)) //For localhost testing
                .picture(new URL(request.getContextPath()+ postImg))
                .name("What is your 'DISC' personality type?")
                .caption("Personality Type Assessment")
                .description("A quick 'DISC' personality assessment.");
        
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        try {
            facebook.postFeed(post);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect("thankYou.jsp");
    
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
