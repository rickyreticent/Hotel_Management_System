<%-- 
    Document   : newcustomer
    Created on : Sep 25, 2010, 5:21:26 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,hotel.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Customer</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
   <body>
      <center>
      <form action="newcustomerprocess.jsp">
<%
        Connection con=DBConnection.myGetConnection();
        Statement st=con.createStatement();
        ResultSet rs=null;
        st.executeQuery("select * from customer_lodge");
%>
           
      <h2>You are a new customer.......</h2>
      
<table cellpadding="5" cellspacing="5">
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
         
        <tr>
              <td>Enter customer-name:</td>
              <td><input type="text" name="cname"></td>
          </tr>
          <tr>
              <td>Enter customer-address:</td>
              <td><input type="text" name="caddress" maxlength="50"></td>
          </tr>
          <tr>
              <td>Choose package-id:</td>
        
              <td><select name="pid">
        <%
            rs=st.executeQuery("select * from packages");
            while(rs.next()){
        %>
                  <option value=<%=rs.getInt(1)%>><%=rs.getString(2)%></option>
        <% } %>
                  </select></td>
          </tr>


</table>
    
      <p/>

      <input type="submit" value="Submit">
       
      </form>

      </center>
  </body>
</html>
