<%@page import="database.databaseConnectivity"%>
<%@page import="java.sql.*"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="database.DBQuery"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Data Lineage in Malicious Environments</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <%
       String name=session.getAttribute("name").toString();
       String email=session.getAttribute("email").toString();
       session.setAttribute("name", name);
       session.setAttribute("email", email);

  %>
  <body>
   

    
    <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="index.jsp">Data Lineage in Malicious Environments</a></h1>
                    </div>
                </div>
                
               
            </div>
        </div>
    </div> <!-- End site branding area -->
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="ownerloginform.jsp">-----</a></li>

                    </ul>
                </div>  
            </div>
        </div>
    </div>
     <div class="col-md-12"><br/><br/>
                           <p align="center">Consumer Home</p><br/>
                     <table align="center" cellpadding="1" border="1">
             <tr><td>Person Name</td><td>File</td><td>Download Link</td></tr>            
              <%
               Connection con=databaseConnectivity.getconnection();
               Statement  st=con.createStatement();
                 String query="select * from consumer_shared_detail where share_to='"+name+"'";
                 String filenm="",sharefrom="";
                 ResultSet rs=st.executeQuery(query);
                 String status="Invalid User";
                while(rs.next())
                 {   
                     status="Valid User";
                     filenm=rs.getString("filename");
                     sharefrom=rs.getString("share_from");

                    
                 %>
                 <tr><td><%=sharefrom%></td><td><%=filenm%></td>
                     <td>
                         <form action="download_consumerfile">
                             <input type="hidden" name="consumername" value="<%=name%>" />
                             <input type="hidden" name="fnm" value="<%=filenm%>" /> 
                         <input type="submit" value="Download"/>
                         </form>
                     </td></tr>
                          <%} %>
                     </table>
  
                      <br/><br/><br/><br/><br/><br/><br/><br/><br/>

           
                

        </div>        
    </div> <!-- End slider area -->
 
  </body>
</html>