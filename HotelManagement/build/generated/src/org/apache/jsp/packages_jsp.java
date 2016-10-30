package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import hotel.*;

public final class packages_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Packages</title>\n");
      out.write("        <link href=\"styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"green\">\n");
      out.write("\n");
      out.write("       <h2>List of Packages</h2>\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("       ");

            Connection con=DBConnection.myGetConnection();
            Statement st=con.createStatement();
            ResultSet rs=null;
             rs =st.executeQuery("select * from packages");
      
      out.write("\n");
      out.write(" <table bgcolor=\"orange\" cellspacing=\"5\" >\n");
      out.write("\n");
      out.write("           <tr bgcolor=\"silver\">\n");
      out.write("               <th>Package-id</th>\n");
      out.write("               <th>Package-name</th>\n");
      out.write("               <th>No: of days</th>\n");
      out.write("               <th>Cost</th>\n");
      out.write("           </tr>\n");
      out.write("\n");
      out.write("     ");
    
            while(rs.next())
             {
                
        
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                 <td>");
      out.print(rs.getInt(1));
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(rs.getInt(3));
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(rs.getDouble(4));
      out.write("</td>\n");
      out.write("             </tr>\n");
      out.write("\n");
      out.write("       ");
  }  
      out.write("\n");
      out.write("      </table>\n");
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
