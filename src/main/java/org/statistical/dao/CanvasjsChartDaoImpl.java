package org.statistical.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.statistical.chart.CanvasjsChartData;

@Component
public class CanvasjsChartDaoImpl implements CanvasjsChartDao
{
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData()
	{
		return CanvasjsChartData.getCanvasjsDataList();
	}
}