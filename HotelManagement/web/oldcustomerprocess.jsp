<%--
    Document   : newcustomerprocess
    Created on : Sep 28, 2010, 3:13:57 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,hotel.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processing Existing Customer...</title>
        <link href="styles.css" rel="stylesheet" />
    </head>

<body>
<form action="customerupdated.jsp">
       
        <%
        Connection con=DBConnection.myGetConnection();
        Statement st=con.createStatement();
        ResultSet rs=null;
        PreparedStatement ps=null;

       int cid=0;
       int hid=0;
       int pid=0;
       
       String hid1=request.getParameter("hid");
       String cid1=request.getParameter("cid");
       String pid1=request.getParameter("pid");
       try{
       if(hid1!=null && pid1!=null && cid1!=null)
       {
         hid=Integer.parseInt(hid1);
         cid=Integer.parseInt(cid1);
         pid=Integer.parseInt(pid1);
       }}
       catch(Exception ex)
       {
           out.println(ex.getMessage());
           return;
       }

       session.setAttribute("pid",pid);
       session.setAttribute("hid",hid);

       rs=st.executeQuery("select * from customer_lodge where cid="+cid);
       if(rs.next())
         {
           
        %>
<h3> Old Customer Information</h3>
<table>
    <tr>
        <td>Customer id:</td>
        <td> <input type="text" name="cid" value="<%=cid%>" readonly></td>
    </tr>

    <tr>
        <td>Customer Name:</td>
        <td><input type="text" value="<%=rs.getString(2)%>" readonly></td>
    </tr>
    <tr>
        <td>Customer Address:</td>
        <td><input type="text" value="<%=rs.getString(3)%>" readonly></td>
    </tr>
    <tr>
        <td>No: of visits: </td>
        <td><input type="text" value="<%=rs.getInt(4)%>" readonly></td>
    </tr>

    <tr>
              <td>Choose Room no:</td>
              <td><select name="room">
         <%
         rs=st.executeQuery("select * from lodge where room_status='y' and hid="+hid);
            while(rs.next()){
        %>

         <option value=<%=rs.getString(1)%>><%=rs.getString(1)%></option>
                  <% } %>
              </select></td>
     </tr>

     <tr>
         <td>&nbsp;</td>
         <td><input type="submit" value="OK"</td>
     </tr>

</table>
<%
    st.executeUpdate("update customer_lodge set no_of_times=no_of_times+1 where cid="+cid);
       }
       
 else
     {
    out.println("<h3>You are not an old customer.......");
    out.println("You might be a new customer.......");
    out.println("Please enter from newcustomer tag</h3>");
     }   
 %>


</form>
    </body>
</html>