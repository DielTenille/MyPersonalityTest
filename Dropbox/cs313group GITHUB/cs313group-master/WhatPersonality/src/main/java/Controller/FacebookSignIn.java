/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author t2alaska
 */
@WebServlet(name = "FacebookSignIn", urlPatterns = {"/FacebookSignIn"})
public class FacebookSignIn extends HttpServlet {

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
        
        String accessToken = "EAACEdEose0cBAMOylS88RwSyqRd0NGz3Ji7nDECOcNEwN608SivMXEZBZC3ZAroxOWWDB4SVPQTEgtng6EwLhkWSaJp65dZAfKWqLRjifUG1fhSo9E3SECCZAk9DrW79XDx3ZByTg3Rf79leAm5M2nZAT585iQIp3kDFy126QntgvP5ZAJ6tn9lk1EioFuZANuAkZD";
        
        Facebook facebook = new FacebookFactory().getInstance();

        request.getSession().setAttribute("facebook", facebook);

        StringBuffer requestUrl = request.getRequestURL();
        int lastSlashIndex = requestUrl.lastIndexOf("/");

        String callBackUrl = requestUrl.substring(0, lastSlashIndex) + "/FBCallBack";

        String facebookUrl = facebook.getOAuthAuthorizationURL(callBackUrl);

        response.sendRedirect(facebookUrl);
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
        //processRequest(request, response);
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
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
