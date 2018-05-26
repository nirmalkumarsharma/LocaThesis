package org.statistical.chart;

import java.util.List;
import java.util.Map;

import org.locationanalyzer.user.User;
 
public interface CanvasjsChartService
{
	List<List<Map<Object, Object>>> getCanvasjsChartData(User user);
	List<List<Map<Object, Object>>> getCanvasjsChartDataMorning(User user);
	List<List<Map<Object, Object>>> getCanvasjsChartDataEvening(User user);
	List<List<Map<Object, Object>>> getCanvasjsChartDataNight(User user);
	List<List<Map<Object, Object>>> getCanvasjsChartDataWeekDay(User user);
	List<List<Map<Object, Object>>> getCanvasjsChartDataWeekend(User user);
}
 