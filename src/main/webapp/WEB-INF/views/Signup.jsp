<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	Signup
	<br>



	<spring:form action="savedata" method="post" commandName="userBean">
		Email : <spring:input type="text" path="email" />
		<spring:errors path="email" cssClass="error"></spring:errors>
		<br>
		Password : <spring:password path="password" cssClass="error" />
		<spring:errors path="password"></spring:errors>
		<br>
		<input type="submit" value="save" />
	</spring:form>
</body>
</html>

