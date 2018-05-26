package org.statistical.dao;

import java.util.List;
import java.util.Map;

import org.locationanalyzer.user.User;
import org.springframework.stereotype.Component;
import org.statistical.chart.CanvasjsChartData;

@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao
{
	CanvasjsChartData canvasjsChartData=new CanvasjsChartData();
	
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData(User user)
	{
		return canvasjsChartData.getCanvasjsDataList(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataMorning(User user)
	{
		return canvasjsChartData.getCanvasjsDataListMorning(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataEvening(User user)
	{
		return canvasjsChartData.getCanvasjsDataListEvening(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataNight(User user)
	{
		return canvasjsChartData.getCanvasjsDataListNight(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataWeekDay(User user)
	{
		return canvasjsChartData.getCanvasjsDataListWeekDay(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataWeekend(User user)
	{
		return canvasjsChartData.getCanvasjsDataListWeekend(user);
	}
}