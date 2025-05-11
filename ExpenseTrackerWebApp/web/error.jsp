<%-- 
    Document   : error
    Created on : 11 May 2025, 4:09:01 PM
    Author     : moses
--%>

<%@page isErrorPage="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Server Error</title>
        <link rel="stylesheet" href="styles.css" >
    </head>
    <body>
        <%
            String errorMessage = exception.getMessage();
        %>
        <h1>Server Error</h1>
        <%=errorMessage%>
        <a href="index.html">Home</a>
    </body>
</html>
