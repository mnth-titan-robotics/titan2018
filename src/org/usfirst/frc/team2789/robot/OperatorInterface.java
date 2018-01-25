package org.usfirst.frc.team2789.robot;

public class OperatorInterface {

	pilotstick = new joystick(1);
	copilotstick = new joystick(2);
	
}
	
double value; {
	value = pilotstick.getX();
	value = pilotstick.getY();
	value = pilotstick.getZ();
	value = pilotstick.getThrottle();
	value = pilotstick.getTwist();
	
	boolean buttonValue;
	buttonValue = pilotstick.getTop();
	buttonValue = pilotstick.getTrigger();
	
}

}
