<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <h3>${topics}</h3> --%>

<h1>Topics:</h1>

<%

String topics[] = (String [])request.getAttribute("topics");
for(String t:topics){
%>
<h2><%=t%></h2>
<%} %>
</body>
</html>