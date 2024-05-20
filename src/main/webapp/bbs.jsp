<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Scanner" %>
<%! Scanner scan = new Scanner(System.in); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
<form action="/jmaster/BbsServlet2" method="post">
名前：<br>
<input type="text" name="NAME"><br>
<%
String name = scan.next();
name = request.getParameter("NAME");
%>
メッセージ：<br>
<textarea name="MESSAGE"></textarea>
<input type="submit" value="書き込み">
<%
String message = scan.next();
message = request.getParameter("MESSAGE");
%>
<hr>
</form>
</body>
</html>