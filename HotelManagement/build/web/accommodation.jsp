<%--
    Document   : customerupdated
    Created on : Oct 1, 2010, 8:17:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="hotel.*,java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Registered</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
<center><h1>SSS group of Hotels</h1></center>
<center><h2>(Accommodation)</h2></center>

<table cellpadding="5" cellspacing="5" >
    <th>Customer id</th>
    <th>Allotted Room</th>
    <th>Accommodation cost</th>
    <th>BookDate</th>
    <th>LeaveDate</th>
    <th>Hotel id</th>
    <th>Package id</th>

   <%
   Connection con=DBConnection.myGetConnection();
   Statement st=con.createStatement();
   PreparedStatement ps=null;
   ResultSet rs=null;
   
    rs=st.executeQuery("select * from accommodation order by hid");
    while(rs.next())
        {
    %>
        <tr>
            <td><%=rs.getInt(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getInt(4)%></td>
            <td><%=rs.getString(5)%></td>
            <td><%=rs.getString(6)%></td>
            <td><%=rs.getInt(7)%></td>
            <td><%=rs.getInt(3)%></td>
        </tr>
<% } %>
</table>
    </body>
</html>

