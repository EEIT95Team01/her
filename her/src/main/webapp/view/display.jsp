<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Display</title>
</head>
<body>

<h3>Select Product Table Result : ${fn:length(beans)} row(s) selected</h3>
<c:if test="${not empty beans}">
<table>
	<thead>
	<tr>
		<th>id</th>
		<th>name</th>
		<th>price</th>
		<th>cover</th>
		<th>viewCount</th>
		<th>salesCount</th>
		<th>status</th>
		<th>manufacturer</th>
		<th>cost</th>
		<th>gpratio</th>
		<th>stock</th>
		<th>maxWordCount</th>
		
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${beans}">
		
	<tr>
		<td>${bean.id}</td>
		<td>${bean.name}</td>
		<td>${bean.price}</td>
		<td>${bean.cover}</td>
		<td>${bean.viewCount}</td>
		<td>${bean.salesCount}</td>
		<td>${bean.status}</td>
		<td>${bean.manufacturer}</td>
		<td>${bean.cost}</td>
		<td>${bean.gpratio}</td>
		<td>${bean.stock}</td>
		<td>${bean.maxWordCount}</td>
		
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/product.jsp" />">Product Table</a></h3>
</body>
</html>