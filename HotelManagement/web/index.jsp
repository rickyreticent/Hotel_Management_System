<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="hotel.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>

    <h1>SSS group of Hotels</h1>
    <table width="100%" height="600px">
        <tr valign="top">
            <td style="background-color:yellowgreen" width="25%">
                <h4>Administrator Login </h4>
                <form action="index.jsp" method="post">
                    Adminstrator ID:
                    <br/>
                    <input type=text name="adminid" style="width:150px">
                    <br/>
                    Password:
                    <br/>
                    <input type=password name="pwd" style="width:150px">
                    <p/>
                    <input type=submit value="Login">

                    <%
                      String adminid = request.getParameter("adminid");

                      if ( adminid != null)
                      {
                            String pwd = request.getParameter("pwd");
                            Adminstrator a = AdminLogin.login(adminid,pwd);

                            if ( a == null)
                                out.println("Invalid Login");  // if failed remains in the same page
                            else
                            {
                                session.setAttribute("admin",a);
                                response.sendRedirect("home.html");  // if successful
                            }
                     } // end of if

                    %>
                </form>
                <p></p>
                <a href="forgot.html">Forgot Password </a>
                <br/>
                <a href="register.html">New user? Register!</a>
            </td>

            <td>
             <p></p>


            </td>
        </tr>
    </table>


    </body>
</html>
