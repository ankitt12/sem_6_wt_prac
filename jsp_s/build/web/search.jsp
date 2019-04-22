<%-- 
    Document   : search
    Created on : Apr 22, 2019, 11:46:12 AM
    Author     : ankit
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search JSP Page</title>
    </head>
    <body>
        <form method="post">
            Enter Id:<input type="number" id="enter_id" name="n_id">
            <input type="submit" name = "id_submit" value="Submit"> 
        </form>

        <%
            try {
                if (request.getParameter("id_submit") != null) {
                    int id = Integer.parseInt(request.getParameter("n_id"));
                    out.print(Integer.toString(id));
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem6_wt_prac", "root", "ankit123");
                    PreparedStatement ps = con.prepareStatement("select * from student_info where id = ?");
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        // the result is found display the same
                        out.print("<h4>Used details found successfully for id<.h4>" + Integer.toString(id));
                        out.print("Name:" + rs.getString(2) + "\n" + "Email" + rs.getString(3));
                        
                    } else {
                        out.print("<h4>NO ENTRY FOUND FOR USER WITH ID</h4> " + Integer.toString(id));
                       
                    }
                    out.print("<a href = \"index.jsp\">HOME PAGE</a>");
//                     response.sendRedirect("http://localhost:8084/jsp_s/index.jsp");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        %>
    </body>
</html>
