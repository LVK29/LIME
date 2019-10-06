/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Email.SendEmail;
import database.DBQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kaushal420
 */
public class secretkey_generation extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException, ClassNotFoundException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String fname=request.getParameter("fname");
            String role=request.getParameter("role");
            System.out.println(name+"---"+email+"---"+fname);
            String secretkey=token_generation.skey();
            System.out.println("secret key"+secretkey);

            SendEmail smail=new SendEmail();
            smail.emailUtility(email, secretkey);
            DBQuery dbq=new DBQuery();
            dbq.storepersondetail(name,email,fname,secretkey,role);
        Thread.sleep(10000);
        request.getRequestDispatcher("ownerandconsumerdetail.jsp").forward(request, response);
     
        } finally {            
            out.close();
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                    try {
                        processRequest(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(secretkey_generation.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(secretkey_generation.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (InterruptedException ex) {
            Logger.getLogger(secretkey_generation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
                    try {
                        processRequest(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(secretkey_generation.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(secretkey_generation.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (InterruptedException ex) {
            Logger.getLogger(secretkey_generation.class.getName()).log(Level.SEVERE, null, ex);
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
