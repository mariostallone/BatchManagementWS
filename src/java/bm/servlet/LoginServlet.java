/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bm.servlet;

import bm.entities.LoginEntity;
import bm.service.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mario Stallone
 */
public class LoginServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Logger logger = LoggerFactory.getLogger(LoginServlet.class);
        try {
            /*  http://localhost:8080/Batch_Management/login?username=mario&ipaddress=127.0.0.1&hostname=dream&groupid=502
             * 
             */
            if(!request.getParameterMap().isEmpty())
            {
                System.out.println(request.getParameterNames().toString());
                Enumeration<String> parameters= request.getParameterNames();
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setGroupid(Integer.parseInt(request.getParameter("groupid")));
                loginEntity.setHostname(request.getParameter("hostname"));
                loginEntity.setIpaddress(request.getParameter("ipaddress"));
                loginEntity.setUsername(request.getParameter("username"));
                out.println(LoginService.registerLogin(loginEntity));
                while(parameters.hasMoreElements()) 
                {
                out.println(parameters.nextElement());
                }
                out.println(loginEntity.description());
            }
            else
            {
                out.println("No Values Passed");
            }
        }
        catch(Exception e)
        {
            logger.error(e.getMessage());
        }
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
