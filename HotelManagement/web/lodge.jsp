<%--
    Document   : lodge
    Created on : Sep 27, 2010, 6:44:19 PM
    Author     : Administrator
--%>
<%@page import="java.sql.*,hotel.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>

        <h2>Rooms avalability</h2>
        <table border="3" cellpadding="5" cellspacing="5">
        <tr>
         <th>Room-No:</th>
         <th>Book Date</th>
         <th>Leave Date</th>
         <th>Room Status</th>
         <th>Hotel-id</th>
         </tr>
         <%
            Connection con=DBConnection.myGetConnection();

            Statement st=con.createStatement();
            ResultSet rs=null;

            rs=st.executeQuery("select * from lodge order by hid");

            while(rs.next()){

         %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(2)%></td>
                <%
                String available=rs.getString(5);
                if(available.equals("n"))
                  {
                %>
                <td><a href=checkout.jsp?room=<%=rs.getString(1)%>&hid=<%=rs.getString(2)%>>Check-Out</a></td>
                <% }
                %>
            </tr>
            <% } %>

        </table>
<p/><p/><p/><p/><p/><p/><p/><p/><p/>
        <table cellspacing="9">
            <tr>
                <td><h4>Check-in:</h4></td>
                <td><a href="newcustomer.jsp">New customer</a></td>
                <td><a href="oldcustomer.jsp">Old customer</a></td>
            </tr>
        </table>

        <p/><p/><p/>
        <table cellspacing="9">
            <tr>
                <td><a href="packages.jsp">List of Packages</a></td>
                <td><a href="accommodation.jsp">Accommodation details</a></td>
            </tr>
        </table>


    </body>
</html>