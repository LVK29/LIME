/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Email.MD5Hash;
import com.oreilly.servlet.MultipartRequest;
import database.DBQuery;
import java.io.File;
import java.io.FileInputStream;
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
import javax.swing.JOptionPane;

/**
 *
 * @author kaushal420
 */
public class FileUpload extends HttpServlet {

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
            throws ServletException, IOException, InterruptedException, ClassNotFoundException, SQLException {
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
        String directory_photo="D:\\uploaded_file";
        RequestDispatcher rd=null;
        String title_name="";
        try {
             MultipartRequest m1=new MultipartRequest(request,directory_photo,10 * 1024 * 1024);
               Enumeration photo_enum=m1.getFileNames();
               
                title_name=m1.getParameter("title_name");
                System.out.println("Title="+title_name);
          
               String ph_filename="";
                     String ph_file_name="";
                     while(photo_enum.hasMoreElements())
                    {
                        ph_filename= photo_enum.nextElement().toString();
                        if(ph_filename.equals("photo_fname"))
                        {
                             ph_file_name=m1.getFilesystemName(ph_filename);
                             System.out.println("Photo File Name:"+ph_file_name);
                        }
                    }
                  
                     Thread.sleep(5000);
                     
               Enumeration file_enum=m1.getFileNames();          
               String f_filename="";
                     String f_file_name="";
                     while(file_enum.hasMoreElements())
                    {
                        f_filename= file_enum.nextElement().toString();
                        if(f_filename.equals("document_fname"))
                        {
                             f_file_name=m1.getFilesystemName(f_filename);
                             System.out.println("document File Name:"+f_file_name);
                        }
                    }
                    
                     String name=m1.getParameter("name");
                     String email=m1.getParameter("email"); 
                     //=====================================
              
                      String watr_mark_dir=new_directory+"//web//";
                    System.out.println("New Directory for watermark:  "+watr_mark_dir);
                    File f=new File(watr_mark_dir);
                    if(!f.exists())
                    {
                        f.mkdirs();
                    }
        
                     
                     File source=new File("D://uploaded_file//"+ph_file_name);
                     File destination=new File(watr_mark_dir+ph_file_name+"_watrimg.png");
                     File logo=new File("D://images//amc_logo.png");
                     ReadImageToMark.addImageWatermark(logo, source, destination);
//                     DBQuery dbq=new DBQuery();
                      DBQuery dbq=new DBQuery();      
               String fpath1=configure.upload_path+f_file_name;
               File f1=new File(fpath1); 
               FileInputStream fin1=new FileInputStream(f1);
               byte byt[]=new byte[fin1.available()];
               fin1.read(byt);
               String dt=new String(byt);  
               String key_value=MD5Hash.md5(dt);
               int m=dbq.key_content(f_file_name,key_value);
                                             JOptionPane.showMessageDialog(null,"M="+m);
               if(m>0)
               {
                   int k=dbq.uploaddetail(name,email,f_file_name,ph_file_name,ph_file_name+"_watrimg.png");
                     if(k>0)
                     {
                       rd=request.getRequestDispatcher("fileupload.jsp");
                       rd.forward(request, response); 
                     }
               }
                     
            
                     
                    
//                    String fileDirectory=directory_photo+"\\photo";
//                    System.out.println("New Directory:  "+fileDirectory);
//                    File f=new File(fileDirectory);
//                    if(!f.exists())
//                    {
//                        f.mkdirs();
//                    }
//                    String olddirectory=dir+file_name;
//                    FileInputStream fin=new FileInputStream(olddirectory);
//                    b=new byte[fin.available()];
//                    fin.read(b);
//                    String data=new String(b);
//                    
//                    String fPath=fileDirectory+"\\"+file_name;                             //fpath
//                    FileOutputStream fout=new FileOutputStream(fPath);
//                    fout.write(b);
//                    fin.close();
//                    fout.close();
                  //  fout1.close();

//              DBQuery dbq=new DBQuery();
//               int i=dbq.storeData(name,password,email,gender,dob,role,file_name);
//               System.out.println(" >>>>>"+i);
//               if(i>0)
//               {
//                   session.setAttribute("msg","Registration Successfully" );
//                   rd=request.getRequestDispatcher("registrationpage.jsp");
//                   rd.forward(request, response);
//               }
//              


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
                    try {
                        processRequest(request, response);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (InterruptedException ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
                    }
        } catch (InterruptedException ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
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
