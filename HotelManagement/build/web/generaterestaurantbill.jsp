<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant</title>
        <link href="styles.css" rel="stylesheet" />
    </head>
    <body>
        <%@page import="java.sql.*,hotel.*" %>

        <%
            Connection con=DBConnection.myGetConnection();

            Statement st=con.createStatement();
            ResultSet rs=null;
            int cost=0;

            String hotelid=request.getParameter("hid");
            int hid=Integer.parseInt(hotelid);

            String itemid=request.getParameter("itemid");

            rs=st.executeQuery("select * from restaurant where i_id='"+itemid+"'");
            if(rs.next())
               cost = rs.getInt(3);

            st.executeQuery("insert into customer_rest values(r_id.nextval,'"+itemid+"',"+cost+","+hid+")");

            st.executeQuery("update hotel set rest_amount=rest_amount+"+cost+" where hid="+hid);
            st.executeQuery("update hotel set total_amount=total_amount+"+cost+" where hid="+hid);

            rs=st.executeQuery("select * from customer_rest where r_id=(select max(r_id) from customer_rest)");
            rs.next();
         %>
<center><h1>SSS group of Hotels</h1></center>
<center><h2>(Restaurant)</h2></center>
<h3>Hello Sir/Madam,
<table>
        <tr>
            <td>Hotel id:</td>
            <td><%=rs.getInt(4)%></td>
        </tr>

        <tr>
            <td>Item id:</td>
            <td><%=rs.getString(2)%></td>
        </tr>
        <tr>
            <td>Item cost:</td>
            <td><%=rs.getInt(3)%></td>
        </tr>

</table>
Thank you for visiting our restaurant....<p/>
We wish u had a good time here.<p/>
    Please visit again.Thank you.......
</h3>
    </body>
</html>
