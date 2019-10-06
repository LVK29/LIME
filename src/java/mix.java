/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Split_Files;
import Logic.path_info;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sumit
 */
public class mix extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       File f1=new File(path_info.path+"chunks/");
        File f1a[]=f1.listFiles();
        System.out.println("f1 size "+f1a.length);
        
        
        File f2=new File(path_info.path+"chunks/");
        File f2a[]=f2.listFiles();
        System.out.println("f2 size "+f2a.length);
        ArrayList al=new ArrayList();
        
        for(int i=0;i<f1a.length;i++)
        {
            System.out.println(">"+f1a[i].getName());
     //   al.add(f1a[i].getAbsoluteFile());
        al.add(path_info.path+"chunks/"+f1a[i].getName());
        }
        for(int i=0;i<f2a.length;i++)
        {
            System.out.println(">"+f2a[i].getName());
      //  al.add(f2a[i].getAbsoluteFile());
        al.add(path_info.path+"chunks/"+f2a[i].getName());
        }
        
        for(int i=0;i<al.size();i++)
        {
            System.out.println(">>"+al.get(i));
        }
        System.out.println("__________________________________");
        
         Collections.shuffle(al);
         
           for(int i=0;i<al.size();i++)
        {
            System.out.println(">>"+al.get(i));
        }
         
         
         Split_Files sf=new Split_Files();
         sf.mergeParts(al, path_info.path+"final.mp3");
         
        
        
        
        
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
        processRequest(request, response);
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
