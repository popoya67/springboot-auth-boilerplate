<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My Custom Login Page</title>
</head>
<body style='margin:50px;'>
<% 
	String orgRequestUrl = (String)request.getAttribute("orgRequestUrl");
	String redirectUrl = orgRequestUrl == null ? request.getParameter("orgRequestUrl") : orgRequestUrl;
%>
  <h2>My Custom Login Page</h2>
  <form action="/login?orgRequestUrl=<%=redirectUrl %>" method="post">
    	<c:if test="${errorMsg != null}">
    		<p style='color:red'>
    			<%=request.getAttribute("errorMsg") %>
    		</p>
    	</c:if>
    	<p>
    		<label for="username">Username</label>
    		<input type="text" id="userId" name="userId"/>
    	</p>
    	<p>
    		<label for="password">Password</label>
    		<input type="password" id="password" name="password"/>
    	</p>
    	<button type="submit">Log in</button>
    </form>
</body>
</html>