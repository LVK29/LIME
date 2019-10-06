/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.DBQuery;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JOptionPane;

/**
 *
 * @author kaushal420
 */
public class filedownload extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
        try {
           String ownername=request.getParameter("ownername");
           String ownerfile=request.getParameter("ownerfile");
           String consumername=request.getParameter("consumername");
          
           DBQuery dbq=new DBQuery();
           String status=dbq.verifyUser(ownername,ownerfile,consumername);
           if(status.equalsIgnoreCase("Accept"))
           {
               String fpath=configure.upload_path+ownerfile;
               File f=new File(fpath); 
               FileInputStream fin=new FileInputStream(f);
               byte b[]=new byte[fin.available()];
               fin.read(b);
               String data=new String(b);  
               fin.close();
               session.setAttribute("content", data);
               session.setAttribute("consumername", consumername);
               session.setAttribute("fname", ownerfile);
               request.getRequestDispatcher("filecontent.jsp").forward(request, response); 

           }else if(status.equalsIgnoreCase("Reject"))
           {
               JOptionPane.showMessageDialog(null,"First Sent Request to Data Owner");
               request.getRequestDispatcher("filedetail_downloadlin.jsp").forward(request, response); 
           }
           
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
            Logger.getLogger(filedownload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(filedownload.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(filedownload.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(filedownload.class.getName()).log(Level.SEVERE, null, ex);
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
