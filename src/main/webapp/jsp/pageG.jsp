<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード処理</title>
</head>
<body>
<%
String[] canon = {"椿", "木村", "小川"};
request.setAttribute("CANON", canon);

List<Integer> list = new ArrayList<>();
list.add(10);
list.add(20);
list.add(30);
request.setAttribute("LIST", list);

Map<String, Integer> map = new HashMap<>();
map.put("AAA", 100);
map.put("BBB", 200);
map.put("CCC", 300);
request.setAttribute("MAP", map);
%>

<c:forEach var="c" items="${CANON}" varStatus="num">
	${num.count}：${c}<br>
</c:forEach>
<hr>
<c:forEach var="l" items="${LIST}">
	${l}<br>
</c:forEach>
<hr>
<c:forEach var="data" items="${MAP}">
	${data.key}：${data.value} <br>
</c:forEach>

</body>
</html>