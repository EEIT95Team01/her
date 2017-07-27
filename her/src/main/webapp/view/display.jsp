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
		<th>cardNo</th>
		<th>cardName</th>
		<th>cardPrice</th>
		<th>cardCost</th>
		<th>cardGrossProfit</th>
		<th>cardManufactory</th>
		<th>cardMaxWordCount</th>
		<th>cardImage</th>
		<th>cardStock</th>
		<th>cardViewCount</th>
		<th>cardSalesCount</th>
		<th>cardStatus</th>
		
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${beans}">
		
	<tr>
		<td>${bean.cardNo}</td>
		<td>${bean.cardName}</td>
		<td>${bean.cardPrice}</td>
		<td>${bean.cardCost}</td>
		<td>${bean.cardGrossProfit}</td>
		<td>${bean.cardManufacturer}</td>
		<td>${bean.cardMaxWordCount}</td>
		<td>${bean.cardCover}</td>
		<td>${bean.cardStock}</td>
		<td>${bean.cardViewCount}</td>
		<td>${bean.cardSalesCount}</td>
		<td>${bean.cardStatus}</td>
		
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/pages/product.jsp" />">Product Table</a></h3>
</body>
</html>