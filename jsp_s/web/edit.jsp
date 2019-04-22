<%-- 
    Document   : edit
    Created on : Apr 21, 2019, 9:53:15 PM
    Author     : ankit
--%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit JSP Page</title>
        
    </head>
    <body>
        <%
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
        %>
        <br><br>
        <h4>Make required changes in the below text box</h4>
        <h5>Student ID to be edited is<%=id%></h5>
        <form name="user_form" method="POST" onsubmit="return validate();">

            NAME:<input type="text" name = "user_name" value="<%=name%>">
            EMAIL:<input type="text" name = "user_email" value="<%=email%>">
            <input type="submit"name="user_edit" value="UPDATE">
        </form>
        <%
                if (request.getParameter("user_edit") != null) {
                    //update tthe datea in tabel
                    ps = con.prepareStatement("update student_info set name = ?, email = ? where id=?");
                    ps.setString(1, request.getParameter("user_name"));
                    ps.setString(2, request.getParameter("user_email"));
                    ps.setInt(3, id);
                    ps.executeUpdate();
                    out.print("<h4>The data has been modified successffuly for user id</h4>"+Integer.toString(id)
                            +"<a href = \"index.jsp\">Home Page</a>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        %>
        <script src="validate.js"></script>
    </body>
</html>
