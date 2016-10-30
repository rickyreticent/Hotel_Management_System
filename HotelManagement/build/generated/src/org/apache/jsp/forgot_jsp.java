package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class forgot_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Forgot Password</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <h2>Forgot Password</h2>\n");
      out.write("     ");

     String email = request.getParameter("email");
     String hintq = hotel.AdminLogin.getHintQuestion(email);
     if ( hintq == null ) {
          out.println("Email Adresss Not found in database. Please try again!");
          return;
     }
     
      out.write("\n");
      out.write("     <form action=\"forgot2.jsp\">\n");
      out.write("         <table>\n");
      out.write("             <tr>\n");
      out.write("                 <td>Email Address \n");
      out.write("                 <td><input type=\"text\" name=\"email\" readonly  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\n");
      out.write("             </tr>\n");
      out.write("             \n");
      out.write("                         <tr>\n");
      out.write("                 <td>Hint Question\n");
      out.write("                 <td><input type=\"text\" name=\"hintq\" readonly  value=\"");
      out.print(hintq);
      out.write("\" readonly />\n");
      out.write("             </tr>\n");
      out.write("                                      <tr>\n");
      out.write("                 <td>Answer\n");
      out.write("                 <td><input type=\"text\" name=\"hinta\" size=\"20\"/>\n");
      out.write("             </tr>\n");
      out.write("\n");
      out.write("         </table>\n");
      out.write("         <input type=\"submit\" value=\"Submit\" />\n");
      out.write("      </form>\n");
      out.write("    \n");
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
