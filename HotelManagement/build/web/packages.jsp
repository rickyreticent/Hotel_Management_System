<%--
    Document   : packages
    Created on : Sep 25, 2010, 5:23:39 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Packages</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body bgcolor="green">

       <h2>List of Packages</h2>

            <%@page import="java.sql.*,hotel.*"%>

       <%
            Connection con=DBConnection.myGetConnection();
            Statement st=con.createStatement();
            ResultSet rs=null;
             rs =st.executeQuery("select * from packages");
      %>
 <table bgcolor="orange" cellspacing="5" >

           <tr bgcolor="silver">
               <th>Package-id</th>
               <th>Package-name</th>
               <th>No: of days</th>
               <th>Cost</th>
           </tr>

     <%    
            while(rs.next())
             {
                
        %>
             <tr>
                 <td><%=rs.getInt(1)%></td>
                 <td><%=rs.getString(2)%></td>
                 <td><%=rs.getInt(3)%></td>
                 <td><%=rs.getDouble(4)%></td>
             </tr>

       <%  }  %>
      </table>
    </body>
</html>
