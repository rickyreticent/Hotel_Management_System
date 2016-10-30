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
        <title>Processing NewCustomer...</title>
        <link href="styles.css" rel="stylesheet" />
    </head>

    <body>
<form action="customerupdated.jsp">
       <h3> New Customer Information</h3>
        <%
        Connection con=DBConnection.myGetConnection();
        Statement st=con.createStatement();
        ResultSet rs=null;
        PreparedStatement ps=null;

       int cid=0;
       int hid=0;
       int pid=0;
       String cname=request.getParameter("cname");
       String caddress=request.getParameter("caddress");
       String hid1=request.getParameter("hid");
       String pid1=request.getParameter("pid");

       if(hid1!=null && pid1!=null)
       {
         hid=Integer.parseInt(hid1);
         pid=Integer.parseInt(pid1);
       }

       session.setAttribute("pid",pid);
       session.setAttribute("hid",hid);
       session.setAttribute("cname",cname);

       ps=con.prepareStatement("insert into customer_lodge values(lodge_cid.nextval,?,?,1)");
       ps.setString(1,cname);
       ps.setString(2,caddress);
       int rows=ps.executeUpdate();

       if(rows>0)
           out.print("Insertion successful");

       rs=st.executeQuery("select * from customer_lodge where cid=(select max(cid) from customer_lodge)");
       rs.next();
           cid =rs.getInt(1);
          
        %>

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

</form>
    </body>
</html>