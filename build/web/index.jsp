<%-- 
    Document   : index
    Created on : May 19, 2017, 7:31:33 AM
    Author     : sumit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Browse to Upload</h2>
             <form action="./FileUpload1" enctype="multipart/form-data" method="post">
                 <table>
                     <tr>
                         <td>
                             Browse The File:
                         </td>
                         <td>
                           
                             <input type="file" name="file" id="file" />
                         </td>
                         
                     </tr>
                  
                     
                     
                    
                     
                     
                   
                     
                      <tr>
                         <td>
                            
                            
                         </td>  
                          <td>
                            
                             <input type="submit" value="Uplaod File" id="butn2"/>
                         </td>
                        
                     </tr>
                     <tr>
                         <td>
                             
                         </td>
                         
                     </tr>
                 </table>
             </form>
    </body>
</html>
