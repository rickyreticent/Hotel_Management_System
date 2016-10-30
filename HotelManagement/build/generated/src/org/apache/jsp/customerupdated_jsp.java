package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hotel.*;
import java.sql.*;

public final class customerupdated_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Customer Registered</title>\n");
      out.write("        <link href=\"styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("   ");

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
    
      out.write("\n");
      out.write("\n");
      out.write("<center><h1>SSS group of Hotels</h1></center>\n");
      out.write("<center><h2>(Accommodation)</h2></center>\n");
      out.write("<h3>Hello Sir/Madam,\n");
      out.write("<table cellpadding=\"5\" cellspacing=\"5\" >\n");
      out.write("        <tr>\n");
      out.write("            <td>Hotel id:</td>\n");
      out.write("            <td>");
      out.print(rs.getInt(7));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>Customer id:</td>\n");
      out.write("            <td>");
      out.print(rs.getInt(1));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <td>Allotted Room:</td>\n");
      out.write("            <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <td>Accommodation cost:</td>\n");
      out.write("            <td>");
      out.print(rs.getInt(4));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <td>BookDate:</td>\n");
      out.write("            <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <td>LeaveDate:</td>\n");
      out.write("            <td>");
      out.print(rs.getString(6));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <td>Package id:</td>\n");
      out.write("            <td>");
      out.print(rs.getInt(3));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</h3>\n");
      out.write("<h2>\n");
      out.write("<center>Thanks for choosing our accommodation facilities<br>\n");
      out.write("\n");
      out.write("We wish u a happy time here<br>\n");
      out.write("    Thank you....\n");
      out.write("</center>\n");
      out.write("</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("<h2>Customer registered successfully</h2>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
