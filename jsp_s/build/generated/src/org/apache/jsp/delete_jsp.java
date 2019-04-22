package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class delete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Delete JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try {
                int id = Integer.parseInt(request.getParameter("delete"));
                // delete is mentioned in index.jsp from there i am getting the id 
                // of selected user to be deleted;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem6_wt_prac", "root", "ankit123");
                PreparedStatement ps = con.prepareStatement("select * from student_info where id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                rs.next();

        
      out.write("\n");
      out.write("        <h3>The following user will be delete</h3>\n");
      out.write("        <h3>Id:");
      out.print(id);
      out.write("</h3>>\n");
      out.write("        <h3>Name:");
      out.print(rs.getString(2));
      out.write("</h3>\n");
      out.write("        <h3>Email:");
      out.print(rs.getString(3));
      out.write("</h3>\n");
      out.write("        <h4>Do you want to continue??</h4>\n");
      out.write("        <form method=\"POST\" name=\"delete_form\">\n");
      out.write("            \n");
      out.write("            <input type=\"submit\" name=\"yes_button\" value=\"YES\" >\n");
      out.write("            <input type=\"submit\" name=\"no_button\" value=\"NO\">\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        ");

//                if (request.getParameter("yes_button") != null) {
//                    ps = con.prepareStatement("delete from student_info where id = ?");
//                    ps.setInt(1, id);
//                    ps.executeUpdate();
//                    out.print("<h4>The user with id</h4>" + Integer.toString(id) + "has been successfully"
//                            + "deleted");
//                }
//                String redirecturl = "http://localhost:8084/jsp_s/index.jsp";
//                response.sendRedirect(redirecturl);
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
