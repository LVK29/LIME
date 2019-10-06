/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.oreilly.servlet.MultipartRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kaushal420
 */
public class AudioFileUpload extends HttpServlet {

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
         ServletContext context=getServletContext();
        String dir=context.getRealPath("\\");
        System.out.println("default Directory"+dir);      
        int pos=dir.indexOf("\\build");
        String new_directory=dir.substring(0,pos);
        System.out.println("directory:==="+new_directory);
             HttpSession session=request.getSession();

        byte b[];
        String directory_mp3="D:\\uploadmp3\\";
        RequestDispatcher rd=null;
        String title_name="";
        try {
             MultipartRequest m1=new MultipartRequest(request,directory_mp3);
               Enumeration photo_enum=m1.getFileNames();
               
                title_name=m1.getParameter("title_name");
                System.out.println("Title="+title_name);
          
               String ph_filename="";
                     String ph_file_name="";
                     while(photo_enum.hasMoreElements())
                    {
                        ph_filename= photo_enum.nextElement().toString();
                        if(ph_filename.equals("audio_fname"))
                        {
                             ph_file_name=m1.getFilesystemName(ph_filename);
                             System.out.println("Mp3 File Name:"+ph_file_name);
                        }
                    }
                  
                  
                 
                       rd=request.getRequestDispatcher("audiofileupload.jsp");
                       rd.forward(request, response); 
//   
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {            
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
try{
        processRequest(request, response);
        }catch(Exception e)
        {
            e.printStackTrace();
        }    }

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
        try{
        processRequest(request, response);
        }catch(Exception e)
        {
            e.printStackTrace();
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
