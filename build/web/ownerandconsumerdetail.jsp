<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
                        <li class="active"><a href="index.html">Home</a></li>
                        <li><a href="ownerloginform.jsp">OWNER</a></li>
                        <li><a href="consumerhomepage.jsp">CONSUMER</a></li>
                        <li><a href="auditorhomepage.jsp">AUDITOR</a></li>
                        <li><a href="adminlogin.jsp">ADMIN</a></li>
                        <li><a href="registrationpage.jsp">REGISTRATION</a></li>
                        <li><a href="index.html">Logout</a></li>

                    </ul>
                </div>  
            </div>
        </div>
    </div>
     <div class="col-md-12"><br/><br/>
         <b><p align="center">Owner and Consumer Detail</p></b><br/><br/>
         <table align="center" border="1" cellpadding="15"><tr><td>User Name</td><td>Email</td><td>D.O.B</td><td>Role</td><td>Fingerprint.jpg</td><td>Activate</td></tr>
       
             
             
             <%
             DBQuery dbq=new DBQuery();
            Connection con= database.databaseConnectivity.getconnection();
             Statement st=con.createStatement();
             String SQL="select * from registration";
             ResultSet rs=st.executeQuery(SQL);
             String sno="",name="",email="",dob="",role="",filename="";
             while(rs.next())
             {
                 sno=rs.getString("sno");
                 name=rs.getString("name");
                 email=rs.getString("email");
                 dob=rs.getString("dob");
                 role=rs.getString("role");
                 filename=rs.getString("filename");
            %>   
            <tr><td><%=name%></td><td><%=email%></td><td><%=dob%></td><td><%=role%></td><td><img src= "<%=filename%>" alt="fprint view" style="width:60px;height:60px"></td>
          
           <td> <form action="secretkey_generation">
                 <input type="hidden" name="name" value="<%=name%>" />
                 <input type="hidden" name="email" value="<%=email%>" />
                 <input type="hidden" name="fname" value="<%=filename%>" />   
                 <input type="hidden" name="role" value="<%=role%>" />      


                 <input type="submit" value="Activate"/></td></tr>
            </form>
              <% }%>
        </div>        
    </div> <!-- End slider area -->
 
  </body>
</html>