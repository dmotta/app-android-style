package com.gdglima.projects.gdgandroidtour.utils;

public class MathUtils {
	
	public static double randomByMinMax(double min, double max)
	{
		//		//return Math.random() * (max - min) + min;
		double n=min + Math.random()*(max-min);
		
		return n;
	}

}
