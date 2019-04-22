<%-- 
    Document   : delete
    Created on : Apr 22, 2019, 9:51:28 AM
    Author     : ankit
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Driver"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete JSP Page</title>
    </head>
    <body>
        <%
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

        %>
        <h3>The following user will be delete</h3>
        <h3>Id:<%=id%></h3>>
        <h3>Name:<%=rs.getString(2)%></h3>
        <h3>Email:<%=rs.getString(3)%></h3>
        <h4>Do you want to continue??</h4>
        <form method="POST" name="delete_form">

            <input type="submit" name="yes_button" value="YES" >
            <input type="submit" name="no_button" value="NO">

        </form>

        <%
            if (request.getParameter("yes_button") != null) {
                ps = con.prepareStatement("delete from student_info where id = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                out.print("<h4>The user with id</h4>" + Integer.toString(id) + "has been successfully"
                        + "deleted");
                String redirecturl = "http://localhost:8084/jsp_s/index.jsp";
                response.sendRedirect(redirecturl);
            } 
//            else {
//                    String redirecturl = "http://localhost:8084/jsp_s/index.jsp";
//                    response.sendRedirect(redirecturl);
//                }

            }catch (Exception e) {
                e.printStackTrace();
            }


        %>
    </body>
</html>
