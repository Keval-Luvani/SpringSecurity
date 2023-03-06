<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert Data</title>
	</head>
	<body>	
		<form:form action="submit" method="post" modelAttribute="user">
			<form:input path="id" type="hidden" />
			<form:label path="name">name</form:label>
			<form:input path="name" required="required"/><br>
			
			<form:label path="email" >email</form:label>
			<form:input path="email" type="email" required="required"/><br>
			
			<form:label path="password">password</form:label>
			<form:input path="password" type="password" required="required"/><br>
			
			<form:label path="role" required="required">Role</form:label>
			<form:radiobutton  path="role" value="student" label="student"/>
			<form:radiobutton  path="role" value="teacher" label="teacher"/><br>
			
			<form:button>Submit</form:button>
		</form:form>
	</body>
</html>