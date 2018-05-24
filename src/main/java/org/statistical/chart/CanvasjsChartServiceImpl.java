package org.statistical.chart;

import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.statistical.dao.CanvasjsChartDao;
 
@Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService
{
	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData()
	{
		return canvasjsChartDao.getCanvasjsChartData();
	}
}                        