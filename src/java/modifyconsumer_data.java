/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Email.MD5Hash;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author kaushal420
 */
public class modifyconsumer_data extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        HttpSession session=request.getSession();
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try {
           String fnm=request.getParameter("filename");
           String fcntnt=request.getParameter("filecontent");
           String consunm=request.getParameter("consumername");
                        
            System.out.println("1. >>>>"+fnm);
            System.out.println("2. >>>>"+fcntnt);
            System.out.println("3. >>>>"+consunm);
            String key_value=MD5Hash.md5(fcntnt);
            DBQuery dbq=new DBQuery();
               int m=dbq.key_modifiedcontent(fnm,key_value,consunm);
               session.setAttribute("content", fcntnt);
               session.setAttribute("consumername", consunm);
               session.setAttribute("fname", fnm);
               request.getRequestDispatcher("modifyconsumerdata.jsp").forward(request, response);
            

        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modifyconsumer_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(modifyconsumer_data.class.getName()).log(Level.SEVERE, null, ex);
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
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(modifyconsumer_data.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(modifyconsumer_data.class.getName()).log(Level.SEVERE, null, ex);
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
