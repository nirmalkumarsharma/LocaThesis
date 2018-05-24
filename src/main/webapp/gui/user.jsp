<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglib.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer1", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Total"
	},
	axisY: {
		title: "Revenue (in billion dollars USD)",
		prefix: "$",
		suffix: "bn"
	},
	data: [{
		type: "bar",
		yValueFormatString: "$#,##0.0bn",
		indexLabel: "{y}",
		dataPoints: dps[0]
	}]
});
 
var yValue;
var label;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		label = "${dataPoint.label}";
		dps[parseInt("${loop.index}")].push({
			label : label,
			y : yValue
		});		
	</c:forEach>	
</c:forEach> 
 
chart.render();




var dps1 = [[]];

var chart1 = new CanvasJS.Chart("chartContainer2", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Morning"
	},
	axisY: {
		title: "Revenue (in billion dollars USD)",
		prefix: "$",
		suffix: "bn"
	},
	data: [{
		type: "bar",
		yValueFormatString: "$#,##0.0bn",
		indexLabel: "{y}",
		dataPoints: dps1[0]
	}]
});
var yValue1;
var label1;
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue1 = parseFloat("${dataPoint.y}");
		label1 = "${dataPoint.label}";
		dps1[parseInt("${loop.index}")].push({
			label : label1,
			y : yValue1
		});		
	</c:forEach>	
</c:forEach> 
 
chart1.render();












}
</script>
<h1>${user.username}</h1>
<br>
<br>
<table class="table table-hover" border="2">
<tr>
<td colspan="2">
<div>
	<div id="chartContainer1" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
</tr>
<tr>
<td colspan="2">
<div>
	<div id="chartContainer2" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
</tr>
<tr>
<td colspan="2">
<div>
	<div id="chartContainer1" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
</tr>
</table>
	