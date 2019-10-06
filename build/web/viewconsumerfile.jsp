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
                        <li class="active"><a href="ownerloginform.jsp">Consumer Home</a></li>
                        <li><a href="filedetails.jsp">View Files</a></li>
                        <li><a href="filedetail_downloadlin.jsp">Download File</a></li>
                        <li><a href="viewconsumerfile.jsp">Share File</a></li>
                        <li><a href="index.html">Logout</a></li>

                    </ul>
                </div>  
            </div>
        </div>
    </div>
     <div class="col-md-12"><br/><br/>
                           <p align="center">Consumer Home</p><br/>
                     <table align="center" cellpadding="1" border="1">
             <tr><td>Name</td><td>File</td></tr>            
              <%
              String chk="Accept";
               Connection con=databaseConnectivity.getconnection();
               Statement  st=con.createStatement();
                 String query="select * from filerequestdetail where status='"+chk+"'";
                 String nm="",filenm="";
                 ResultSet rs=st.executeQuery(query);
                         while(rs.next())
                 {
                     nm=rs.getString("requester_name");
                     filenm=rs.getString("owner_file");
                    
               %>
               <tr><td><%=nm%></td><td><%=filenm%></td><td></tr>
                          <%} %>
                     </table>
   <form action="ConsumerDataShared">    
         
        <select name="share_to">
	<option value="">Select Consumer to share</option>
             <%
             String role="Consumer";
                  Statement st1= databaseConnectivity.getconnection().createStatement();
                  String sql="select * from registration where role='"+role+"'";
                  ResultSet rs1=st1.executeQuery(sql);
                  String cunm;
                  while(rs1.next())
                   {
                      cunm=rs1.getString("name");

             %>
        
                  <option value="<%=cunm%>"><%=cunm%></option>
                     <%}%>               
        </select>&nbsp;&nbsp;
        
        <select name="filename">
	<option value="">Select FileName</option>
             <%
             String check2="Accept";
                  Statement st2= databaseConnectivity.getconnection().createStatement();
                  String sql2="select * from filerequestdetail where status='"+check2+"' and requester_name='"+name+"' ";
                  ResultSet rs2=st2.executeQuery(sql2);
                  String fnm;
                  while(rs2.next())
                   {
                      fnm=rs2.getString("owner_file");

             %>
        
                  <option value="<%=fnm%>"><%=fnm%></option>
                     <%}%>               
        </select>
                     <input type="hidden" name="share_from" value="<%=name%>"/>
                     <input type="submit" value="SHARE"/>
   </form>
                      <br/><br/><br/><br/><br/><br/><br/><br/><br/>

           
                

        </div>        
    </div> <!-- End slider area -->
 
  </body>
</html>