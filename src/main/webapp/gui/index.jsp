<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="taglib.jsp" %>
<%@ include file="headcdns.jsp"%>

<body>
	<form action="/LocaThesis/locationhistoryJson" method="post" enctype="multipart/form-data">
		<div class="upload">
	 		<div class="upload-files">
	  			<header>
	   				<p>
	    				<i class="fa fa-cloud-upload" aria-hidden="true"></i>
	    				<span class="type">Google Location History</span>
	    				<br/>
	    				<span class="action">JSON File Upload</span>
	   				</p>
	  			</header>
		  		<div class="body" id="drop">
		   			<i class="fa fa-file-text-o pointer-none" aria-hidden="true"></i>
		   			<p class="pointer-none"><b>Drag and drop</b> files here <br /> or <a href="" id="triggerFile">browse</a> to begin the upload</p>
					<input type="file" multiple="multiple" name="files" />
		  		</div>
		  		<footer>
		   			<div class="divider">
		    			<span><AR>FILES</AR></span>
		   			</div>
		   			<div class="list-files">
		    			<!--   template   -->
		   			</div>
		   			<button class="importar" type="submit">Analyze Files</button>
		  		</footer>
	 		</div>
		</div>
	</form>
	<script  src="${pageContext.request.contextPath}/gui/js/index.js"></script>
</body>