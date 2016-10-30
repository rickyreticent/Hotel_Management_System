<%@page import="java.sql.*,hotel.*"%>

<html>
    <head>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
        <%
            String pwd = request.getParameter("pwd");

            Connection con = DBConnection.myGetConnection();
            PreparedStatement ps = con.prepareStatement("update admin set pwd = ? where email =?");

            ps.setString(1,pwd);

            Adminstrator a = (Adminstrator)session.getAttribute("admin"); // this attribute is set in index.jsp
            ps.setString(2, a.getEmail());

            try
            {
                ResultSet rs = ps.executeQuery();

            if ( rs.next()) // success
            {
                out.println("Password changed successfully<br>");
                out.println("Your email id = " + a.getEmail()+"<br>");
                out.println("Your new password = " + pwd);
            }
            else
                out.println("Sorry!, problem in changing password");
            }
            catch(Exception ex)
            {
                out.println(ex.getMessage());
                return;
            }
            finally
            {
                DBConnection.close(ps);
                DBConnection.close(con);
            }
        
        %>
        
    </body>
</html>