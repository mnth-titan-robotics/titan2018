package org.usfirst.frc.team2789.robot;

public class RobotMap {
	// ===== Motor Channels ===============================================
    // DriveSystem
	public static final int TALON_DRIVE_FL          = 0;
	public static final int TALON_DRIVE_FR          = 1;
	public static final int TALON_DRIVE_BL          = 2;
	public static final int TALON_DRIVE_BR          = 3;
	// Intake
	public static final int TALON_LIFT              = 4;
    public static final int TALON_INTAKE_LEFT       = 5;
    public static final int TALON_INTAKE_RIGHT      = 6;
    // Climber
    public static final int TALON_CLIMBER           = 7;
	
    
    // ===== Pneumatic Channels ===========================================
    // Climber
    public static final int DS_CLIMBER_MAIN_FWD     = 0;
    public static final int DS_CLIMBER_MAIN_REV     = 1;
    public static final int DS_CLIMBER_EXT_FWD      = 2;
    public static final int DS_CLIMBER_EXT_REV      = 3;
    
    
    // ===== Pilot Controller =============================================
	// Joystick Channel
	public static final int JOYSTICK_PILOT          = 0;
	// Drive Axes
	public static final int AXIS_PILOT_DRIVE        = 1;
    public static final int AXIS_PILOT_TURN         = 4;
    // Climber Buttons
    public static final int BTN_PILOT_CLIMB_ON      = 1;
    public static final int BTN_PILOT_EXT_FWD       = 2;
    public static final int BTN_PILOT_EXT_REV       = 3;
    public static final int BTN_PILOT_MAIN          = 4;
    
    
    // ===== Copilot Controller ===========================================
    // Joystick Channel
	public static final int JOYSTICK_COPILOT        = 1;
	// Intake Buttons
	public static final int BTN_COPILOT_INTAKE_IN   = 5;
	public static final int BTN_COPILOT_LIFT_UP     = 6;
	public static final int BTN_COPILOT_INTAKE_OFF  = 7;
	// Intake Axes
    public static final int AXIS_COPILOT_INTAKE_OUT = 2;
    public static final int AXIS_COPILOT_LIFT_DOWN  = 3;
    
	
    // ===== Settings =====================================================
	// Motor Inversion
	public static final boolean INVERT_LEFT         = false;
	public static final boolean INVERT_RIGHT        = true;
	// Climber Motor Output
	public static final double CLIMBER_POWER        = 1.0;
	// Intake Motor Outputs
	public static final double LIFT_POWER           = 1.0;
	public static final double INTAKE_POWER         = 1.0;
}
