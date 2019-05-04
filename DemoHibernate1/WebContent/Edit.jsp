<%@page import="model.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ValueObject.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Row</title>
</head>
<body>

<% int k = Integer.parseInt(request.getParameter("id"));
	Student s = new Student();
	s.setSid(k);
	List list = new ArrayList();
	DAO dao = new DAO();
	list = dao.displaySingleRowInStudentTable(s);
	session.setAttribute("list", list);
%>
<form action="./UpdateController" method="POST">
<c:forEach items="${sessionScope.list}" var="i">
<input type="hidden" name="sid" value="${i.sid}">
	Roll No : <input type="number" name="nmrollno" value="${i.rollno}"><br>
	Name : <input type="text" name="nmname" value="${i.name}"><br>
	Marks : <input type="number" name="nmmarks" value="${i.marks}"><br>
	<input type="submit" value="Update"> 
	
</c:forEach>
	<% session.removeAttribute("list"); %>
</form>

</body>
</html>