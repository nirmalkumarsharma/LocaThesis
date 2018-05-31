<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>

<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
		<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
	</head>
	<body>
		<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
		<tilesx:useAttribute name="current"/>
		<div class="container">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="<spring:url value="/" />">LocaThesis</a>
			    </div>
			
			    <div class="collapse navbar-collapse">
			      <ul class="nav navbar-nav">
			         <li class="${current=='index'?'active':''}"><a href='<spring:url value="/" />'>Home</a></li>
			         <li class="${current=='help'?'active':''}"><a href='<spring:url value="/help" />'>Help</a></li>
			         <li class="${current=='tpc'?'active':''}"><a href='<spring:url value="/tpc" />'>Terms, Conditions and Privacy </a></li>
			         <li class="${current=='aboutus'?'active':''}"><a href='<spring:url value="/aboutus" />'>About us</a></li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
			<div align="center">
			<tiles:insertAttribute name="body" />
			<br><br>
			<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</body>
</html>