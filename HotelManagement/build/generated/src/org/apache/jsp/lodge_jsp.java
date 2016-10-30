package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import hotel.*;

public final class lodge_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h2>Rooms avalability</h2>\n");
      out.write("        <table border=\"3\" cellpadding=\"5\" cellspacing=\"5\">\n");
      out.write("        <tr>\n");
      out.write("         <th>Room-No:</th>\n");
      out.write("         <th>Book Date</th>\n");
      out.write("         <th>Leave Date</th>\n");
      out.write("         <th>Room Status</th>\n");
      out.write("         <th>Hotel-id</th>\n");
      out.write("         </tr>\n");
      out.write("         ");

            Connection con=DBConnection.myGetConnection();

            Statement st=con.createStatement();
            ResultSet rs=null;

            rs=st.executeQuery("select * from lodge order by hid");

            while(rs.next()){

         
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(rs.getString(1));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString(4));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString(5));
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("                ");

                String available=rs.getString(5);
                if(available.equals("n"))
                  {
                
      out.write("\n");
      out.write("                <td><a href=checkout.jsp?room=");
      out.print(rs.getString(1));
      out.write("&hid=");
      out.print(rs.getString(2));
      out.write(">Check-Out</a></td>\n");
      out.write("                ");
 }
                
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("<p/><p/><p/><p/><p/><p/><p/><p/><p/>\n");
      out.write("        <table cellspacing=\"9\">\n");
      out.write("            <tr>\n");
      out.write("                <td><h4>Check-in:</h4></td>\n");
      out.write("                <td><a href=\"newcustomer.jsp\">New customer</a></td>\n");
      out.write("                <td><a href=\"oldcustomer.jsp\">Old customer</a></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <p/><p/><p/>\n");
      out.write("        <table cellspacing=\"9\">\n");
      out.write("            <tr>\n");
      out.write("                <td><a href=\"packages.jsp\">List of Packages</a></td>\n");
      out.write("                <td><a href=\"accommodation.jsp\">Accommodation details</a></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
