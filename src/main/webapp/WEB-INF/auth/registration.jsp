<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>Registration (registration.jsp)</h1>
	<p><form:errors path="user.*"/></p>
	<form:form action="/users" method="post" modelAttribute="user">
	    <p>
	        <form:label path="firstName">First Name</form:label>
	        <%-- <form:errors path="firstName"/> --%>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name</form:label>
	        <%-- <form:errors path="lastName"/> --%>
	        <form:input path="lastName"/>
	    </p>
	    <p>
	        <form:label path="email">Email</form:label>
	        <%-- <form:errors path="email"/> --%>
	        <form:input path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password</form:label>
	        <%-- <form:errors path="password"/> --%>
	        <form:input path="password"/>
	    </p>
	    <p>
	        <form:label path="passwordConfirmation">Password Confirmation</form:label>
	        <%-- <form:errors path="passwordConfirmation"/> --%>
	        <form:input path="passwordConfirmation"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>    
</body>
</html>