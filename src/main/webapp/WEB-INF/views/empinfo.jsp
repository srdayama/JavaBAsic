<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>EmpInfo Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Emp
</h1>



<form:form action="http://localhost:8080/springwebapp/addemp/" modelAttribute="empob" method="post">
<table>
	<c:if test="${!empty empob.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="id"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	
		<tr>
		<td colspan="2">
			<c:if test="${!empty empob.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty empob.name}">
				<input type="submit"	value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>

<hr><hr>
<h3>Emp List</h3>
<c:if test="${!empty listOfEmployy}">
	<table class="tg">
	<tr>
		<th width="80">Emp ID</th>
		<th width="120">Emp Name</th>
	</tr>
	<c:forEach items="${listOfEmployy}" var="eob">
		<tr>
			<td>${eob.id}</td>
			<td>${eob.name}</td>
			<td><a href="<c:url value='/edit/${eob.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${eob.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>
