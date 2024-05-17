<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>

<%!
Random rand = new Random();
int ftn = rand.nextInt(6);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ</title>
</head>
<body>
<h1>STEP1</h1>
スクリプトレットを使用しておみくじ<br>
今日の運勢は、、、「<%switch (ftn){ 
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
	out.print("吉");
} %>」です。
</body>
</html>