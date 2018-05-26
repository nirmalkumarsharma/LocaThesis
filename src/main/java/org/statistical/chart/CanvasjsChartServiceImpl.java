package org.statistical.chart;

import java.util.List;
import java.util.Map;

import org.locationanalyzer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.statistical.dao.CanvasjsChartDao;
 
@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService
{
	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData(User user)
	{
		return canvasjsChartDao.getCanvasjsChartData(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataMorning(User user)
	{
		return canvasjsChartDao.getCanvasjsChartDataMorning(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataEvening(User user)
	{
		return canvasjsChartDao.getCanvasjsChartDataEvening(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataNight(User user)
	{
		return canvasjsChartDao.getCanvasjsChartDataNight(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataWeekDay(User user)
	{
		return canvasjsChartDao.getCanvasjsChartDataWeekDay(user);
	}

	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartDataWeekend(User user)
	{
		return canvasjsChartDao.getCanvasjsChartDataWeekend(user);
	}
}                        