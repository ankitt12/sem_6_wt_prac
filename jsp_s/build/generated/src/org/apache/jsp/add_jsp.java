package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function validate(){\n");
      out.write("                var id = document.add_entry_form.user_id;\n");
      out.write("                var name = document.add_entry_form.user_name;\n");
      out.write("                var email = document.add_entry_form.user_email;\n");
      out.write("                if(id.value === \"\"){\n");
      out.write("                    alert(\"please enter student id\");\n");
      out.write("                    document.getElementById(\"uid\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(name.value === \"\"){\n");
      out.write("                    alert(\"please enter student name\");\n");
      out.write("                    document.getElementById(\"unid\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(email.value === \"\"){\n");
      out.write("                    alert(\"please enter student email id\");\n");
      out.write("                    document.getElementById(\"uemid\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }                \n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form method=\"post\" name=\"add_entry_form\" onsubmit=\"return validate();\">\n");
      out.write("            ID:<input type=\"text\" name=\"user_id\" id=\"uid\"><br>\n");
      out.write("            NAME:<input type=\"text\" name=\"user_name\" id=\"unid\"><br>\n");
      out.write("            EMAIL:<input type=\"text\" name=\"user_email\" id=\"uemid\"><br>\n");
      out.write("            <input type=\"submit\" value=\"ADD\" name=\"user_add\" >\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        ");

            try {
                if (request.getParameter("user_add") != null) {
                    //implies proper entry has been added
                    // store the same entry in database
                    //first check wheter the same data exist if not then add the same data
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem6_wt_prac", "root", "ankit123");
                    PreparedStatement pstmt = con.prepareStatement("insert into student_info(id,name,email) values(?,?,?)");
                    int id = Integer.parseInt(request.getParameter("user_id"));
                    String name = request.getParameter("user_name");
                    String email = request.getParameter("user_email");

                    pstmt.setInt(1, id);
                    pstmt.setString(2, name);
                    pstmt.setString(3, email);
                    int res = pstmt.executeUpdate();
                    out.print("<h1>Student details successfully added</h1><br>"
                            + "<p>Do you want to add more entries</p>"
                            + "<a href=\"add.jsp\">Yes</a> | <a href = \"index.jsp\">No</a>"
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        
      out.write("\n");
      out.write("        <script src=\"validate.js\"></script>\n");
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
