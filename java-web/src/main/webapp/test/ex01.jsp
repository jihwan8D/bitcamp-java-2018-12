<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>aaa</h1>
<jsp:useBean id="calc" class="bitcamp.Calculator" scope="page"/>
10 + 20 = ${calc.plus(10, 20)}<br>
</body>
</html>