package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import hotel.*;

public final class oldcustomerprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Processing Existing Customer...</title>\n");
      out.write("        <link href=\"styles.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<form action=\"customerupdated.jsp\">\n");
      out.write("       \n");
      out.write("        ");

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
           
        
      out.write("\n");
      out.write("<h3> Old Customer Information</h3>\n");
      out.write("<table>\n");
      out.write("    <tr>\n");
      out.write("        <td>Customer id:</td>\n");
      out.write("        <td> <input type=\"text\" name=\"cid\" value=\"");
      out.print(cid);
      out.write("\" readonly></td>\n");
      out.write("    </tr>\n");
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>Customer Name:</td>\n");
      out.write("        <td><input type=\"text\" value=\"");
      out.print(rs.getString(2));
      out.write("\" readonly></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("        <td>Customer Address:</td>\n");
      out.write("        <td><input type=\"text\" value=\"");
      out.print(rs.getString(3));
      out.write("\" readonly></td>\n");
      out.write("    </tr>\n");
      out.write("    <tr>\n");
      out.write("        <td>No: of visits: </td>\n");
      out.write("        <td><input type=\"text\" value=\"");
      out.print(rs.getInt(4));
      out.write("\" readonly></td>\n");
      out.write("    </tr>\n");
      out.write("\n");
      out.write("    <tr>\n");
      out.write("              <td>Choose Room no:</td>\n");
      out.write("              <td><select name=\"room\">\n");
      out.write("         ");

         rs=st.executeQuery("select * from lodge where room_status='y' and hid="+hid);
            while(rs.next()){
        
      out.write("\n");
      out.write("\n");
      out.write("         <option value=");
      out.print(rs.getString(1));
      out.write('>');
      out.print(rs.getString(1));
      out.write("</option>\n");
      out.write("                  ");
 } 
      out.write("\n");
      out.write("              </select></td>\n");
      out.write("     </tr>\n");
      out.write("\n");
      out.write("     <tr>\n");
      out.write("         <td>&nbsp;</td>\n");
      out.write("         <td><input type=\"submit\" value=\"OK\"</td>\n");
      out.write("     </tr>\n");
      out.write("\n");
      out.write("</table>\n");

    st.executeUpdate("update customer_lodge set no_of_times=no_of_times+1 where cid="+cid);
       }
       
 else
     {
    out.println("<h3>You are not an old customer.......");
    out.println("You might be a new customer.......");
    out.println("Please enter from newcustomer tag</h3>");
     }   
 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</form>\n");
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
