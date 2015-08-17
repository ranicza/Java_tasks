<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<style>
	   <%@include file='../css/bootstrap.css' %>
	   <%@include file='../css/styles.css' %>
	</style>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>User Page</title>
</head>

	<a href="index.jsp"><img src="img/arrow.png"></a>
	<h1 id='mobile'>Mobile Tariffs</h1> 
		
	<table class="table table-striped" >
		<tr class="info" id = "tariff-header" align="center">
	        <td>Tariff name</td>
			<td>Operator</td>
			<td>Payroll</td>
			<td>Calling inside network</td>
			<td>Calling outside network</td>
			<td>Calling stationary network</td>
			<td>SMS price</td>
			<td>No. of favourite numbers</td>
			<td>Tarrifing</td>
			<td>Price for connection</td>
   	 </tr>
 
    		<c:forEach  var="tariff" items="${ simpleinfo }" varStatus="status">
				<tr align="center">
					<td><c:out value="${ tariff.name}" /></td>
					<td><c:out value="${ tariff.operatorName }" /></td>
					<td><c:out value="${ tariff.payroll }" /></td>					
					<td><c:out value="${ tariff.priceInsideNetwork }" /></td>
					<td><c:out value="${ tariff.priceOutsideNetwork }" /></td>
					<td><c:out value="${ tariff.priceStationaryNetwork }" /></td>
					<td><c:out value="${ tariff.smsPrice }" /></td>
					<td><c:out value="${ tariff.favouriteNumber }" /></td>
					<td><c:out value="${ tariff.tariffing }" /></td>
					<td><c:out value="${ tariff.priceForConnection }" /></td>
				</tr>
			</c:forEach>
  
	</table>

</body>
</html>