<%-- 
    Document   : restaurant
    Created on : Sep 25, 2010, 11:45:26 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant page</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
    <form action="generaterestaurantbill.jsp">
            <%@page import="java.sql.*,hotel.*"%>
        <h2>Please enter the hotel-id and item details</h2>
    <p/><p/>
    
    <table>
 <%
        ResultSet rs=null;
        Connection con=DBConnection.myGetConnection();
        Statement st=con.createStatement();
   %>
       <tr>
             <td>Choose Hotel:</td>

              <td><select name="hid">
        <%
            rs=st.executeQuery("select * from hotel");
            while(rs.next()){
        %>
                 <option value=<%=rs.getInt(1)%>><%=rs.getString(2)%></option>
       <% } %>
             </select></td>
         </tr>

       <%
        rs= st.executeQuery("select * from restaurant");
       %>

        <tr>
            <td>Enter item-id:</td>
            <td><select name="itemid">
                <%
                while(rs.next())
                {
               %>
               <option value=<%=rs.getString(1)%>><%=rs.getString(2)%></option>

               <%}%>

            </select></td>
        </tr>
    </table>

<p/>

    <input type="submit" value="Submit">

    </form>
  </body>
    
</html>
