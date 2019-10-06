<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="database.databaseConnectivity"%>
<%@page import="java.sql.Connection"%>
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
  <body>
   

    <%
       String name=session.getAttribute("name").toString();
       String email=session.getAttribute("email").toString();
       session.setAttribute("name", name);
       session.setAttribute("email", email);

  %>

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
                        <li class="active"><a href="ownerloginform.jsp">Home</a></li>
                         <li class="active"><a href="index.html">Logout</a></li>

                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
     <div class="col-md-12"><br/><br/>
         <p align="center"><b> File Details</b></p><br/>
         <table align="center" cellpadding="1" border="1">
             <tr><td>Name</td><td>Email</td><td>File</td><td>Watermark</td></tr>
              <%
               Connection con=databaseConnectivity.getconnection();
               Statement  st=con.createStatement();
                 String query="select * from fdetail where name='"+name+"' and email='"+email+"'";
                 String ownername="",owneremail="",ownerfile="",waterimg="";
                 ResultSet rs=st.executeQuery(query);
                         while(rs.next())
                 {
                     ownername=rs.getString("name");
                     owneremail=rs.getString("email");
                     ownerfile=rs.getString("filename");
                     waterimg=rs.getString("waterimg");
               %>
                <tr><td><%=ownername%></td><td><%=owneremail%></td><td><%=ownerfile%></td><td><img src= "<%=waterimg%>" alt="fprint view" style="width:150px;height:150px"></td> </tr>

                 <%}%>
       
  
             
             
             
         </table>
                   

           
                

        </div>        
    </div> <!-- End slider area -->
 
  </body>
</html>