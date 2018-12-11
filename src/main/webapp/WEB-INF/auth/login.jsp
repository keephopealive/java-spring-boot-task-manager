<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Login (login.jsp)</h1>
	<a href="registration">Register</a>
	 
	<c:out value="${login}"/>
	<form:form action="/sessions" method="post" modelAttribute="user">
	    <p>
	        <form:label path="email">Email</form:label>
	        <form:input path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password</form:label>
	        <form:input path="password"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>