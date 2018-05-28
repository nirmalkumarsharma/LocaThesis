<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<center>
	<h1><b>Location details for ${username}</b></h1>
</center>
<table class="table table-hover" border="1">
	<thead>
		<tr>
			<th><b> Location Name</b> </th>
			<th><b> Latitude</b></th>
			<th><b> Longitude</b></th>
			<th><b> Address</b></th>
	</thead>
	<tbody>
		<c:forEach items="${locationAddress}" var="faddress">
			<tr>
				<td><c:out value="${faddress.name}" /></td>
				<td><c:out value="${faddress.latitude}" /></td>
				<td><c:out value="${faddress.longitude}" /></td>
				<td><c:out value="${faddress.address}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>