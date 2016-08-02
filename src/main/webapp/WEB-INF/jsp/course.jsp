<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Courses</title>
</head>
<body>
	<h2>Course: <c:out value="${course.title}"/></h2>
	<h3>Instructor</h3>
	<p><c:out value="${instructor.name}"/></p>
	<h3>Students</h3>
	<ul>
	<c:forEach items="${students}" var="student">
		<li><c:out value="${student.name}"/></li>
	</c:forEach>
	</ul>
</body>
</html>
