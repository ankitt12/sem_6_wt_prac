package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Edit JSP Page</title>\n");
      out.write("        <script src=\"validate.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try {
                int id = Integer.parseInt(request.getParameter("edit"));
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem6_wt_prac", "root", "ankit123");
                PreparedStatement ps = con.prepareStatement("select * from student_info where id=?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                // display the data in table
                rs.next();
                String name = rs.getString(2);
                String email = rs.getString(3);
        
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        <h4>Make required changes in the below text box</h4>\n");
      out.write("        <h5>Student ID to be edited is");
      out.print(id);
      out.write("</h5>\n");
      out.write("        <form name=\"user_form\" method=\"POST\" onsubmit=\"return validate()\">\n");
      out.write("\n");
      out.write("            NAME:<input type=\"text\" name = \"user_name\" value=\"");
      out.print(name);
      out.write("\">\n");
      out.write("            EMAIL:<input type=\"text\" name = \"user_email\" value=\"");
      out.print(email);
      out.write("\">\n");
      out.write("            <input type=\"submit\"name=\"user_edit\" value=\"UPDATE\">\n");
      out.write("        </form>\n");
      out.write("        ");

                if (request.getParameter("user_edit") != null) {
                    //update tthe datea in tabel
                    ps = con.prepareStatement("update student_info set name = ?, email = ? where id=?");
                    ps.setString(1, request.getParameter("user_name"));
                    ps.setString(2, request.getParameter("user_email"));
                    ps.setInt(3, id);
                    ps.executeUpdate();
                    out.print("<h4>The data has been modified successfuuly for used id</h4>id");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        
      out.write("\n");
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
