<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>はじめてのJSP</title>
</head>
<body>
<%--スクリプトレット（Javaのプログラムを書く領域）--%>

<%
//名前を表示
//for (int n = 1; n <= 5; n ++){
//	out.printnln("田中久瑠美" + "<br>");
//}

String name = "田中久瑠美";
%>

<%!
public int tasu(int x, int y){
	return x + y;
}
%>

私の名前は<%= name %>です。<br>
加算結果：<%= tasu(10, 20) %><br> 

</body>
</html>