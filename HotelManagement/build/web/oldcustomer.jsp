<%-- 
    Document   : oldcustomer
    Created on : Sep 25, 2010, 5:22:28 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,hotel.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Existing Customer</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
      <center>
      <form action="oldcustomerprocess.jsp">
      <h3>You are a old customer.......</h3>
      
      <%
        Connection con=DBConnection.myGetConnection();
        Statement st=con.createStatement();
        ResultSet rs=null;
        st.executeQuery("select * from customer_lodge");
%>
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
             <td>Enter Customer-id:</td>
             <td><input type="text" name="cid"></td>
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

<%
String pid=request.getParameter("pid");
String hid=request.getParameter("hid");
int cid=0;
if(pid!=null && hid!=null && cid!=0)
     {
         cid=Integer.parseInt(request.getParameter("cid"));

        rs=st.executeQuery("update customer_lodge set no_of_times=no_of_times+1 where cid="+cid);


       request.setAttribute("id",cid);
       request.setAttribute("hid",hid);
       request.setAttribute("pid",pid);

       response.sendRedirect("newcustomerprocess.jsp");
    }
 %>
      </form>
      </center>
    </body>
</html>