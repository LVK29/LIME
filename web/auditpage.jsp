<%@page import="java.util.ArrayList"%>
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
                        <li class="active">
                            <a href="index.html">Home</a></li>
                       

                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
     <div class="col-md-12"><br/><br/>
         <p align="center"><b>Auditor </b></p><br/>
         <%
            DBQuery dbq=new DBQuery();
            String data=dbq.getcontentkeydetail();
            String keyDetail[]=data.split("==");
            int n=keyDetail.length;
            for(int i=0;i<n;i++)
            {
                System.out.println((i+1)+">>>>"+keyDetail[i]);
            }
            String dta=dbq.getmodifiedcontentkeydetail();
             String keys[]=dta.split("==");
            int nk=keys.length;
            String fnm="",conm="";
            ArrayList arl=new ArrayList();
            for(int i=0;i<nk;i++)
            {
                System.out.println((i+1)+">>>>"+keys[i]);
                String subarr[]=keys[i].split("-");
                
                if(!subarr[0].equals(keyDetail[i]))
                {
                    fnm=subarr[1];
                    conm=subarr[2];
                    arl.add(fnm+"--"+conm);
                }
            }
            JOptionPane.showMessageDialog(null,"Total Malicious Found:"+arl.size());
                       JOptionPane.showMessageDialog(null,"-----:"+fnm+"--"+conm);

            
         %>  
         <table align="center" cellpadding="3" border="2">
             
             <tr><td> File Name</td><td></td><td>Malicious Consumer Name</td></tr>
         <%
         String nm="";
         String file="";
          for(int k=0;k<arl.size();k++)
            {
              String m=arl.get(k).toString();
              String ar[]=m.split("--");
              file=ar[0];
              nm=ar[1];
          %>
           
             <tr><td><%=file%></td><td></td><td><%=nm%></td></tr>
           <% }%>
                    </table> 

        
     </div> <!-- End slider area -->
 
  </body>
</html>