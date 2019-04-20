<%-- 
    Document   : login
    Created on : Apr 20, 2019, 11:17:40 PM
    Author     : ankit
--%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <html:form action="/login">
            <table border="0">
                
                <tbody>
                    <tr >
                        <td colspan="2">
                            <bean:write name="LoginForm" property="error" filter="false"/>
                            &nbsp;
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Enter Name:</td>
                        <td><html:text property="name"/></td>
                    </tr>
                    <tr>
                        <td>Enter Email</td>
                        <td><html:text property="email"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><html:submit value="Login"/></td>
                    </tr>
                </tbody>
            </table>

        </html:form>
    </body>
</html>
