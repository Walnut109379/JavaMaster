<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%-- サーブレットのインポート漏れ --%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.ServletException"%>
<%@page import="java.io.IOException" %>

<%!
@WebServlet("/omikuji3")
public class omikuji3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // メソッド修正
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("NAME");
        request.getSession().setAttribute("NAME", name);
    }%>
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
<h1>STEP3</h1>
リクエストパラメータを使用しておみくじ結果を表示<br>
<%
name = (String)session.getAttribute("NAME");
out.print(name);
%>
の運勢は、、、「
<%
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
    out.print("吉");
}
%>」です。
</body>
</html>
