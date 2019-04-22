<%-- 
    Document   : add
    Created on : Apr 21, 2019, 8:39:01 PM
    Author     : ankit
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@page  import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add JSP Page</title>
        <script>
            function validate(){
                var id = document.add_entry_form.user_id;
                var name = document.add_entry_form.user_name;
                var email = document.add_entry_form.user_email;
                if(id.value === ""){
                    alert("please enter student id");
                    document.getElementById("uid").focus();
                    return false;
                }
                if(name.value === ""){
                    alert("please enter student name");
                    document.getElementById("unid").focus();
                    return false;
                }
                if(email.value === ""){
                    alert("please enter student email id");
                    document.getElementById("uemid").focus();
                    return false;
                }                
            }

        </script>
    </head>
    <body>
        <form method="post" name="add_entry_form" onsubmit="return validate();">
            ID:<input type="text" name="user_id" id="uid"><br>
            NAME:<input type="text" name="user_name" id="unid"><br>
            EMAIL:<input type="text" name="user_email" id="uemid"><br>
            <input type="submit" value="ADD" name="user_add" >

        </form>
        <%
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

        %>
        <script src="validate.js"></script>
    </body>
</html>
