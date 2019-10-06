/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.oreilly.servlet.MultipartRequest;
import database.DBQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class register extends HttpServlet {

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
        ServletContext context=getServletContext();
        String dir=context.getRealPath("\\");
        System.out.println("default Directory"+dir);      
        int pos=dir.indexOf("\\build");
        String new_directory=dir.substring(0,pos);
        System.out.println("directory:==="+dir);
        System.out.println("directory:==="+new_directory);
             HttpSession session=request.getSession();

        byte b[];
        String directory="D:\\uploaded_file";
        PrintWriter out = response.getWriter();
        RequestDispatcher rd=null;
        String name="",password="",email="",gender="",dob="",role="";
        try {
            
             MultipartRequest m=new MultipartRequest(request,dir,10 * 1024 * 1024);
               Enumeration fenum=m.getFileNames();
                name=m.getParameter("name");
                password=m.getParameter("password");
                email=m.getParameter("email");
                gender=m.getParameter("gender");
               String date=m.getParameter("date");
               String dob_month=m.getParameter("dob_month");
               String dob_year=m.getParameter("dob_year");
                dob=date+"-"+dob_month+"-"+dob_year;
                role=m.getParameter("role");
               System.out.println(name+"=="+role+"=="+password+email+"=="+gender+"=="+date);                     
               String filename="";
                     String fnm="";     
                     String file_name="";
                     while(fenum.hasMoreElements())
                    {
                        filename= fenum.nextElement().toString();
                        if(filename.equals("fname"))
                        {
                             file_name=m.getFilesystemName(filename);
                             System.out.println("File Name:"+file_name);
                        }
                    }
                    
                    String fileDirectory=new_directory+"\\web";
                    System.out.println("New Directory:  "+fileDirectory);
                    File f=new File(fileDirectory);
                    if(!f.exists())
                    {
                        f.mkdirs();
                    }
                    String olddirectory=dir+file_name;
                    FileInputStream fin=new FileInputStream(olddirectory);
                    b=new byte[fin.available()];
                    fin.read(b);
                    String data=new String(b);
                    
                    String fPath=fileDirectory+"\\"+file_name;                             //fpath
                    FileOutputStream fout=new FileOutputStream(fPath);
                    fout.write(b);
                    fin.close();
                    fout.close();
                  //  fout1.close();

              DBQuery dbq=new DBQuery();
               int i=dbq.storeData(name,password,email,gender,dob,role,file_name);
               System.out.println(" >>>>>"+i);
               if(i>0)
               {
                   session.setAttribute("msg","Registration Successfully" );
                   rd=request.getRequestDispatcher("registrationpage.jsp");
                   rd.forward(request, response);
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
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
