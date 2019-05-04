<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Data Into Table</title>
</head>
<body>
<form action="./InsertionController" method="POST">
	Roll No:<input type="number" name="nmrollno"><br>
	Name :<input type="text" name="nmname"><br>
	Marks : <input type="number" name="nmmarks"><br>
	<input type="submit" value="Insert">
</form>
</body>
</html>