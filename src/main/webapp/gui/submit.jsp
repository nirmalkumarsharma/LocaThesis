<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>

	
	<table class="table table-hover" border="1">
		<thead>
			<tr>
				<th>Files </th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${files}" var="file">
				
				<tr>
					<td>${file.originalFilename}</td>
				</tr>
				
				
			</c:forEach>
			
		</tbody>
	</table>
	
	
</body>