<%-- 
    Document   : Header
    Created on : May 30, 2018, 12:19:12 PM
    Author     : bsapr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="project.wsd.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="./vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="./vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="./css/landing-page.css" rel="stylesheet">

  </head>
   <%
        User user = (User) session.getAttribute("user");
    %>

  <body>

        <%if (user != null) {%>
                <div class="container">   
<!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" href="main.jsp">Home</a>
        You are logged in as <%= user.getName()%>
        <a class="btn btn-primary" href="logout.jsp">Logout</a>
      </div>
    </nav>
<!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    </div>
    <%} else {%>
    <div class="container">
        <!-- Navigation -->
    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" href="main.jsp">Home</a>
        <a class="btn btn-primary" href="login.jsp">Sign In</a>
        <a class="btn btn-primary" href="register.jsp">Register</a>
      </div>
    </nav>
<!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</div>
    <%}%>
      
          <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    


  </body>
</html>
