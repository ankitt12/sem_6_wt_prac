package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"table_style.css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tbody>\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <tr>\n");
      out.write("                    <td>ID</td>\n");
      out.write("                    <td>NAME</td>\n");
      out.write("                    <td>EMAIL</td>\n");
      out.write("                    <td colspan=\"2\">UPDATE</td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                ");

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sem6_wt_prac","root","ankit123");
                        PreparedStatement pstmt = con.prepareStatement("select * from student_info");
                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>");
      out.print(rs.getInt(1));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs.getString(2));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(rs.getString(3));
      out.write("</td>\n");
      out.write("                                <td><a href=\"edit.jsp?edit=");
      out.print(rs.getInt(1));
      out.write("\">Edit</a></td>\n");
      out.write("                                <td><a href=\"delete.jsp?delete=");
      out.print(rs.getInt(1));
      out.write("\">Delete</a></td>\n");
      out.write("                                \n");
      out.write("                            </tr>\n");
      out.write("                           ");

                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("            <h4><a href=\"add.jsp\">Add Record</a></h6> \n");
      out.write("            <h4><a href=\"search.jsp\">Search Record</h4>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
