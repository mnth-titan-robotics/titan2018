package org.usfirst.frc.team2789.robot;

public class RobotMap {
	// DriveSystem motor channels
	public static final int TALON_FL = 0;
	public static final int TALON_FR = 1;
	public static final int TALON_BL = 2;
	public static final int TALON_BR = 3;
	
	// OperatorInterface joystick channels
	public static final int JOYSTICK_PILOT = 0;
	public static final int JOYSTICK_COPILOT = 1;
	
	// OperatorInterface joystick axes
	public static final int DRIVE_AXIS = 1;
	public static final int TURN_AXIS = 4;
	
	// Inverts motor direction
	public static final boolean INVERT_LEFT = false;
	public static final boolean INVERT_RIGHT = true;
	
	// Climber DoubleSolenoid channels
	public static final int DS_MAIN_CYL_FWD=0;
	public static final int DS_MAIN_CYL_REV=1;
	public static final int DS_EXT_CYL_FWD=7;
	public static final int DS_EXT_CYL_REV=3;
	
	// OperatorInterface Climber buttons
	public static final int BTN_MAIN_CYL = 4;
	public static final int BTN_EXT_CYL_FWD = 2;
	public static final int BTN_EXT_CYL_REV = 3;
	public static final int BTN_CLIMB_ON = 1;
	
	// Climber motor channel
	public static final int MTR_CLIMB = 7;
	public static final double CLIMB_VAL = 1.0;
	
	// Intake
	public static final int LIFT_MTR = 4;
	public static final int INTAKE_LEFT = 5;
	public static final int INTAKE_RIGHT = 6;
	public static final double LIFT_POWER = 1.0;
	
}
