<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%@ page import="kr.sujin.app.dto.User" %>
<html lang="en">
       <body>
    <%
    	User loginUser = (User)session.getAttribute("LOGGED_USER");
    %>
    
        <h1>Admin Home - <%=loginUser.getName() %></h1>
        
        <form action="/logout" method="post">
        	<button type="submit">Log out</button>
        </form>
    </body>
</html>