<%-- 
    Document   : index
    Created on : Apr 21, 2019, 7:56:32 PM
    Author     : ankit
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="table_style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <table border="1">
            <tbody>
                <br>
                <br>
                <tr>
                    <td>ID</td>
                    <td>NAME</td>
                    <td>EMAIL</td>
                    <td colspan="2">UPDATE</td>
                    
                </tr>
                <%
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sem6_wt_prac","root","ankit123");
                        PreparedStatement pstmt = con.prepareStatement("select * from student_info");
                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            %>
                            <tr>
                                <td><%=rs.getInt(1)%></td>
                                <td><%=rs.getString(2)%></td>
                                <td><%=rs.getString(3)%></td>
                                <td><a href="edit.jsp?edit=<%=rs.getInt(1)%>">Edit</a></td>
                                <td><a href="delete.jsp?delete=<%=rs.getInt(1)%>">Delete</a></td>
                                
                            </tr>
                           <%
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                %>
            </tbody>
        </table>
            <h4><a href="add.jsp">Add Record</a></h6> 
            <h4><a href="search.jsp">Search Record</h4>
    </body>
</html>
