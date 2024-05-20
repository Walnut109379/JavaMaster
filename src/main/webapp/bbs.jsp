<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Scanner" %>
<%!
Scanner scan = new Scanner(System.in);
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
%>
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
%>
メッセージ：<br>
<textarea name="MESSAGE"></textarea>
<input type="submit" value="書き込み">
<%
String message = scan.next();
%>
<%
List<String> msg = (ArrayList<String>) session.getAttribute("TL");
if (msg == null) {
	msg = new ArrayList<String>();
	session.setAttribute("TL", msg);
} else {
	String name = request.getParameter("NAME");
	String message = request.getParameter("MESSAGE");
	msg.add(name + "：" + message);
}
PrintWriter out = response.getWriter();
for (String m : msg) {
	out.println(m);
	out.println("<hr>");
}
%>
<hr>
</form>
</body>
</html>