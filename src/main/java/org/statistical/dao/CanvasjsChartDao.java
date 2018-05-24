package org.statistical.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface CanvasjsChartDao
{
	List<List<Map<Object, Object>>> getCanvasjsChartData();
}