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

                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
     <div class="col-md-12"><br/><br/>
                           <p align="center">Registration Form</p><br/>
                                <form action="register" method="POST" enctype="multipart/form-data">
                            Name: <input type="text" name="name"/>
                            Password: <input type="password" name="password"/>
                            Email: <input type="text" name="email"/><br/><br/>
                               Gender: <select name="gender">
                                   <option value="">Select Gender</option>
                                   <option value="Male">Male</option>
                                   <option value="Female">Female</option>
                               </select>
                                 D.O.B :
                                   <select id="date" name="date">
	<option value="day">Day</option>
	 <%
                                            for(int i1=1;i1<32;i1++)
                                                                                               {
                                                %>
                                            
                                        <option value="<%=i1%>"><%=i1%></option>
                                        <%
                                        
                                                                               }
                                            
                                            %>
</select>
                                 
<select id="form_dob_month" name="dob_month">
	
	<option value="month">Month</option>
                                    <option value="Jan">January</option>
                                    <option value="Feb">February</option>
                                    <option value="Mar">March</option>
                                    <option value="Apr">April</option>
                                    <option value="May">May</option>
                                    <option value="Jun">June</option>
                                    <option value="Jul">July</option>
                                    <option value="Aug">August</option>
                                    <option value="Sep">September</option>
                                    <option value="Oct">October</option>
                                    <option value="Nov">November</option>
</select>
                             
<select id="form_dob_year" name="dob_year">
	<option value="year">Year</option>
	<%
                                            for(int ii=1980;ii<2018;ii++)
                                                                                               {
                                                %>
                                            
                                        <option value="<%=ii%>"><%=ii%></option>
                                        <%
                                        
                                                                               }
                                            
                                            %>
</select><br/><br/>
                           Role:  <select name="role">
                                   <option value="">Select Role</option>
                                   <option value="Owner">Owner</option>
                                   <option value="Consumer">Consumer</option>
                                    <option value="Admin">Admin</option>
                           </select> <br/><br/>
        
         Select File :<input type="file" name="fname"> <br/><br/>
         <input type="submit" value="Register"/> &nbsp;&nbsp;
                            </form>
                   
                      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

           
                

        </div>        
    </div> <!-- End slider area -->
 
  </body>
</html>