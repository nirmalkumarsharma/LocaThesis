<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglib.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<script type="text/javascript">
window.onload = function() {
 
var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Total Time"
	},
	axisY: {
		title: "Time (in hours)",
		prefix: "",
		suffix: "hrs"
	},
	data: [{
		type: "bar",
		yValueFormatString: "#,##0.0hrs",
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




var dpsMorning = [[]];

var chartMorning = new CanvasJS.Chart("chartContainerMorning", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Morning"
	},
	axisY: {
		title: "Time (in hours)",
		prefix: "",
		suffix: "hrs"
	},
	data: [{
		type: "bar",
		yValueFormatString: "#,##0.0hrs",
		indexLabel: "{y}",
		dataPoints: dpsMorning[0]
	}]
});
var yValueMorning;
var labelMorning;
<c:forEach items="${dataPointsListMorning}" var="dataPointsMorning" varStatus="loopMorning">	
	<c:forEach items="${dataPointsMorning}" var="dataPointMorning">
		yValueMorning = parseFloat("${dataPointMorning.y}");
		labelMorning = "${dataPointMorning.label}";
		dpsMorning[parseInt("${loopMorning.index}")].push({
			label : labelMorning,
			y : yValueMorning
		});		
	</c:forEach>	
</c:forEach> 
 
chartMorning.render();




var dpsEvening = [[]];

var chartEvening = new CanvasJS.Chart("chartContainerEvening", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Evening"
	},
	axisY: {
		title: "Time (in hours)",
		prefix: "",
		suffix: "hrs"
	},
	data: [{
		type: "bar",
		yValueFormatString: "#,##0.0hrs",
		indexLabel: "{y}",
		dataPoints: dpsEvening[0]
	}]
});
var yValueEvening;
var labelEvening;

<c:forEach items="${dataPointsListEvening}" var="dataPointsEvening" varStatus="loopEvening">	
	<c:forEach items="${dataPointsEvening}" var="dataPointEvening">
		yValueEvening = parseFloat("${dataPointEvening.y}");
		labelEvening = "${dataPointEvening.label}";
		dpsEvening[parseInt("${loopEvening.index}")].push({
			label : labelEvening,
			y : yValueEvening
		});		
	</c:forEach>	
</c:forEach> 
 
chartEvening.render();


var dpsNight = [[]];

var chartNight = new CanvasJS.Chart("chartContainerNight", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Night"
	},
	axisY: {
		title: "Time (in hours)",
		prefix: "",
		suffix: "hrs"
	},
	data: [{
		type: "bar",
		yValueFormatString: "#,##0.0hrs",
		indexLabel: "{y}",
		dataPoints: dpsNight[0]
	}]
});
var yValueNight;
var labelNight;

<c:forEach items="${dataPointsListNight}" var="dataPointsNight" varStatus="loopNight">	
	<c:forEach items="${dataPointsNight}" var="dataPointNight">
		yValueNight = parseFloat("${dataPointNight.y}");
		labelNight = "${dataPointNight.label}";
		dpsNight[parseInt("${loopNight.index}")].push({
			label : labelNight,
			y : yValueNight
		});		
	</c:forEach>	
</c:forEach> 
 
chartNight.render();




var dpsWeekDay = [[]];

var chartWeekDay = new CanvasJS.Chart("chartContainerWeekDay", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Weekdays"
	},
	axisY: {
		title: "Time (in hours)",
		prefix: "",
		suffix: "hrs"
	},
	data: [{
		type: "bar",
		yValueFormatString: "#,##0.0hrs",
		indexLabel: "{y}",
		dataPoints: dpsWeekDay[0]
	}]
});
var yValueWeekDay;
var labelWeekDay;

<c:forEach items="${dataPointsListWeekDay}" var="dataPointsWeekDay" varStatus="loopWeekDay">	
	<c:forEach items="${dataPointsWeekDay}" var="dataPointWeekDay">
		yValueWeekDay = parseFloat("${dataPointWeekDay.y}");
		labelWeekDay = "${dataPointWeekDay.label}";
		dpsWeekDay[parseInt("${loopWeekDay.index}")].push({
			label : labelWeekDay,
			y : yValueWeekDay
		});		
	</c:forEach>	
</c:forEach> 
 
chartWeekDay.render();


var dpsWeekend = [[]];

var chartWeekend = new CanvasJS.Chart("chartContainerWeekend", {
	theme: "light1", // "light1", "light2", "dark1" "dark2"
	animationEnabled: true,
	title: {
		text: "Weekends"
	},
	axisY: {
		title: "Time (in hours)",
		prefix: "",
		suffix: "hrs"
	},
	data: [{
		type: "bar",
		yValueFormatString: "#,##0.0hrs",
		indexLabel: "{y}",
		dataPoints: dpsWeekend[0]
	}]
});
var yValueWeekend;
var labelWeekend;

<c:forEach items="${dataPointsListWeekend}" var="dataPointsWeekend" varStatus="loopWeekend">	
	<c:forEach items="${dataPointsWeekend}" var="dataPointWeekend">
		yValueWeekend = parseFloat("${dataPointWeekend.y}");
		labelWeekend = "${dataPointWeekend.label}";
		dpsWeekend[parseInt("${loopWeekend.index}")].push({
			label : labelWeekend,
			y : yValueWeekend
		});		
	</c:forEach>	
</c:forEach> 
 
chartWeekend.render();







}
</script>
<h1>${user.username}</h1>
<br>
<br>
<table class="table table-hover" border="0">
<tr>
<td colspan="1">
<div>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
<td colspan="1">
<div>
	<div id="chartContainerMorning" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
</tr>

<tr>
<td colspan="1">
<div>
	<div id="chartContainerEvening" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
<td colspan="1">
<div>
	<div id="chartContainerNight" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
</tr>


<tr>
<td colspan="1">
<div>
	<div id="chartContainerWeekDay" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
<td colspan="1">
<div>
	<div id="chartContainerWeekend" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>
</td>
</tr>

</table>
	