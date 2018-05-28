package org.locationanalyzer.clustering;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.locationanalyzer.calc.GPSCoordinateDistance;

public class GeoDistanceMeasure implements DistanceMeasure
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public double compute(double[] a, double[] b) throws DimensionMismatchException
	{
		GPSCoordinateDistance gpsCoordinateDistance=new GPSCoordinateDistance();
		
		return gpsCoordinateDistance.gpsDistance(a[1], a[0], b[1], b[0], "K");
	}
}
