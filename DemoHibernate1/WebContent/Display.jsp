<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Data From Table</title>
</head>
<body>

	<table>
		<tr>
			<th>SR NO</th>
			<th>Roll No</th>
			<th>Name</th>
			<th>Marks</th>
			<th>Mode</th>
		</tr>
		
		<% DAO dao = new DAO();
			List list = new ArrayList(); 
			list = dao.displayStudentData();
			session.setAttribute("list", list);
		%>
		
		<c:forEach items="${sessionScope.list}" var="i">
		
		
		<tr>
			<td>${i.sid}</td>
			<td>${i.rollno}</td>
			<td>${i.name}</td>
			<td>${i.marks}</td>
			<td>
				<a href="Edit.jsp?id=${i.sid} ">Edit</a>
				<a href="DeleteController?id=${i.sid}">Delete</a>
			</td>
		</tr>
		
		</c:forEach>
		<% session.removeAttribute("list"); %>	
	</table>
</body>
</html>