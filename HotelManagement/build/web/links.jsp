<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style>
             body {font-weight:700; font-size:12pt; font-family:verdana; color:yellow}
             a { color:white}
        </style>
    </head>
    <body bgcolor="maroon">
     Adminstrator : ${sessionScope.admin.adminname}
    <%-- accessing a session attribute in JSP--%>
     <p/>
        <a href="lodge.jsp" target="details">Lodge</a>
        <p></p>
        <a href="restaurant.jsp" target="details">Restaurant</a>
        <p></p>
        <a href="changepwd.html" target="details">Change Password </a>
        <p></p>
        <a href="logout.jsp" target="_top">Logout</a>
    </body>
</html>
