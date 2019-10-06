/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Split_Files;
import Logic.path_info;
import com.oreilly.servlet.MultipartRequest;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sumit
 */
public class FileUpload2 extends HttpServlet {
int serverResponseCode = 0;
String fPath="";
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
         try {
           
           
            HttpSession session=request.getSession();
           //String dirName ="G:/MDB_File/";
           String dirName ="D:/audio/2/";
            String phPath="",filePath="";
             
                    String paramname=null,fname="",file="",uid="";
                    
                    
                       
                         File file2 = null;
                      
                      
                  //    String user=session.getAttribute("user").toString();     
            //	 uid=session.getAttribute("uid").toString();     
                    // dirName+=user+"/";    
                     File f=new File(dirName);
                     if(!f.exists())
                     {
                     f.mkdirs();
                     }
                     	

                    RequestDispatcher view=null;
                    try {
                             
                            MultipartRequest multi = new MultipartRequest(request, dirName,	10 * 1024 * 1024); // 10MB
                           
                            Enumeration params = multi.getParameterNames();
                            while (params.hasMoreElements()) 
                            {
                                    paramname = (String) params.nextElement();
                                    
                                    
                                    
                                    if(paramname.equalsIgnoreCase("fname"))
                                    {
                                            fname=multi.getParameter(paramname);
                                    }
                              }
                          
                           
                           
                            Enumeration files = multi.getFileNames();	
            while (files.hasMoreElements()) 
            {
                    paramname = (String) files.nextElement();
            
            
                     if(paramname != null && paramname.equals("file"))
                    {
                            
                            filePath = multi.getFilesystemName(paramname);
                            fPath = dirName+filePath;
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>1>>"+filePath);

                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>2>>"+fPath);
                    
                            file2 = new File(fPath);
                        
                         
                    }
                     

                 
                   
            }
                         }catch(Exception e){e.printStackTrace();}
                    
            
          Split_Files sf=new Split_Files();
             sf.readAndFragment(path_info.path+"2/"+filePath, path_info.path+"chunks/", 1048*1048, "data1");
            
       
              
                     //       session.setAttribute("user",user);
                         
                            view=request.getRequestDispatcher("mix.jsp");
                            view.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
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
