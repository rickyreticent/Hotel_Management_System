<%-- 
    Document   : checkout
    Created on : Oct 1, 2010, 10:13:53 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,hotel.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out</title>
    </head>
    <body>

       <%
       Connection con=DBConnection.myGetConnection();

       Statement st=con.createStatement();
       ResultSet rs=null;
       PreparedStatement ps=null;


       String  room = request.getParameter("room");
       String hid1 = request.getParameter("hid");
       
       int hid=Integer.parseInt(hid1);

       ps=con.prepareStatement("update lodge set room_status='y' where room='"+room+"' and hid="+hid);
       ps.executeQuery();

       ps=con.prepareStatement("update lodge set bookdate=null where room='"+room+"' and hid="+hid);
       ps.executeQuery();

       ps=con.prepareStatement("update lodge set leavedate=null where room='"+room+"' and hid="+hid);
       ps.executeQuery();
       %>
<center>
   <h2> Room <%=room%> checked out successfully........</h2>
</center>
    </body>
</html>
