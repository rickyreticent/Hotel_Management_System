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

   <%
   Connection con=DBConnection.myGetConnection();
   Statement st=con.createStatement();
   PreparedStatement ps=null;
   ResultSet rs=null;
   String room=request.getParameter("room");

   int pid=(Integer)session.getAttribute("pid");
   int hid=(Integer)session.getAttribute("hid");
   String cname=(String)session.getAttribute("cname");
   
   int cid=Integer.parseInt(request.getParameter("cid"));
   rs=st.executeQuery("select * from packages where pid="+pid);
      rs.next();
         int days=rs.getInt(3);
         int cost=rs.getInt(4);


    ps=con.prepareStatement("insert into accommodation values(?,?,?,?,sysdate,sysdate+"+days+",?)");
    ps.setInt(1,cid);
    ps.setString(2,room);
    ps.setInt(3,pid);
    ps.setInt(4,cost);
    ps.setInt(5,hid);
    ps.executeUpdate();

    st.executeUpdate("update lodge set room_status='n' where room='"+room+"' and hid="+hid);
    st.executeUpdate("update lodge set bookdate=sysdate where room='"+room+"' and hid="+hid);
    st.executeUpdate("update lodge set leavedate=sysdate+"+days+" where room='"+room+"' and hid="+hid);

    st.executeUpdate("update hotel set lodge_amount=lodge_amount+"+cost+" where hid="+hid);
    st.executeUpdate("update hotel set total_amount=total_amount+"+cost+" where hid="+hid);

    rs=st.executeQuery("select * from accommodation where cid="+cid);
    rs.next();
    %>

<center><h1>SSS group of Hotels</h1></center>
<center><h2>(Accommodation)</h2></center>
<h3>Hello Sir/Madam,
<table cellpadding="5" cellspacing="5" >
        <tr>
            <td>Hotel id:</td>
            <td><%=rs.getInt(7)%></td>
        </tr>

        <tr>
            <td>Customer id:</td>
            <td><%=rs.getInt(1)%></td>
        </tr>
        
        <tr>
            <td>Allotted Room:</td>
            <td><%=rs.getString(2)%></td>
        </tr>
        
        <tr>
            <td>Accommodation cost:</td>
            <td><%=rs.getInt(4)%></td>
        </tr>
        
        <tr>
            <td>BookDate:</td>
            <td><%=rs.getString(5)%></td>
        </tr>
        
        <tr>
            <td>LeaveDate:</td>
            <td><%=rs.getString(6)%></td>
        </tr>
        
        <tr>
            <td>Package id:</td>
            <td><%=rs.getInt(3)%></td>
        </tr>
        
</table>

</h3>
<h2>
<center>Thanks for choosing our accommodation facilities<br>

We wish u a happy time here<br>
    Thank you....
</center>
</h2>


<h2>Customer registered successfully</h2>

    </body>
</html>
