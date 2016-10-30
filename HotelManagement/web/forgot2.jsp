<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <link rel="stylesheet" href="styles.css" />
    </head>
    <body>
    <h2>Forgot Password</h2>
    <h4>
     <%
     String email = request.getParameter("email");
     String hinta = request.getParameter("hinta");
     String msg= hotel.AdminLogin.processForgotPassword(email,hinta);
     if ( msg == null)
         out.println("Your password is sent to your email address.Thank you for using this facility.");
     else
         out.println("Sorry! Error : " + msg);

     %>

<a href="index.jsp">Go to main page</a>
     </h4>
    </body>
</html>
