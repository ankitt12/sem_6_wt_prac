<%-- 
    Document   : success
    Created on : Apr 20, 2019, 11:21:00 PM
    Author     : ankit
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successfull login</title>
    </head>
    <body>
        <h1>Congratulations you are successfully logged in!!</h1>
        <p>Your name is <bean:write name="LoginForm" property="name"/></p>
         <p>Your email is <bean:write name="LoginForm" property="email"/></p>
    </body>
</html>
