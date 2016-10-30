package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import hotel.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        <link href=\"styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <h1>SSS group of Hotels</h1>\n");
      out.write("    <table width=\"100%\" height=\"600px\">\n");
      out.write("        <tr valign=\"top\">\n");
      out.write("            <td style=\"background-color:yellowgreen\" width=\"25%\">\n");
      out.write("                <h4>Administrator Login </h4>\n");
      out.write("                <form action=\"index.jsp\" method=\"post\">\n");
      out.write("                    Adminstrator ID:\n");
      out.write("                    <br/>\n");
      out.write("                    <input type=text name=\"adminid\" style=\"width:150px\">\n");
      out.write("                    <br/>\n");
      out.write("                    Password:\n");
      out.write("                    <br/>\n");
      out.write("                    <input type=password name=\"pwd\" style=\"width:150px\">\n");
      out.write("                    <p/>\n");
      out.write("                    <input type=submit value=\"Login\">\n");
      out.write("\n");
      out.write("                    ");

                      String adminid = request.getParameter("adminid");

                      if ( adminid != null)
                      {
                            String pwd = request.getParameter("pwd");
                            Adminstrator a = AdminLogin.login(adminid,pwd);

                            if ( a == null)
                                out.println("Invalid Login");  // if failed remains in the same page
                            else
                            {
                                session.setAttribute("admin",a);
                                response.sendRedirect("home.html");  // if successful
                            }
                     } // end of if

                    
      out.write("\n");
      out.write("                </form>\n");
      out.write("                <p></p>\n");
      out.write("                <a href=\"forgot.html\">Forgot Password </a>\n");
      out.write("                <br/>\n");
      out.write("                <a href=\"register.html\">New user? Register!</a>\n");
      out.write("            </td>\n");
      out.write("\n");
      out.write("            <td>\n");
      out.write("             <p></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("\n");
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
