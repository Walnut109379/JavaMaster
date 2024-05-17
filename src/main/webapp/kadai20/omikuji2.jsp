<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>

<%!
Random rand = new Random();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>STEP2</h1>
スクリプトレットで繰り返し処理を利用しておみくじ<br>
<%int m = 1;%>
<%do{%>
	<%= m %>月の運勢は、、、「
	
<% int ftn = rand.nextInt(6);
switch (ftn){ 
case 0:
	out.print("大吉");
	break;
case 1:
	out.print("小吉");
	break;
case 2:
	out.print("凶");
	break;
default:
	out.print("吉");} 
%>」です。<br>
<% m++;} while (m <= 12);%>
</body>
</html>