package org.usfirst.frc.team2789.robot;

public class RobotHelper {
	public static double limit(double value, double min, double max) {
		if (value < min) {
			return min;
		}
		else if (value > max) {
			return max;
		}
		else {
			return value;
		}
	}	
}