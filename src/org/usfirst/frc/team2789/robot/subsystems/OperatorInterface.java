package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OperatorInterface extends Subsystem {
	
	// Storage variables
	private double m_driveCmd;
	private double m_turnCmd;
	/**
	 * TODO 12: CREATE CLIMBER STORAGE VARIABLES
	 * Your solution:
	 * // Climber variables
	 * boolean m_fireMainCyl;
	 * boolean m_fireExtCyl;
	 */
	// Correct solution:
	private boolean m_fireMainCyl;
	private boolean m_fireExtCyl;
	
	// Joystick objects
	private Joystick m_pilotStick;
	private Joystick m_copilotStick;
	
	public OperatorInterface() {
		// Create new joysticks
		this.m_pilotStick = new Joystick (RobotMap.JOYSTICK_PILOT);
		this.m_copilotStick = new Joystick (RobotMap.JOYSTICK_COPILOT);
		
		// Reset storage variables
		this.reset();
	}
	
	public void reset() {
		this.m_driveCmd = 0.0;
		this.m_turnCmd = 0.0;
		this.m_fireExtCyl= false;
		this.m_fireMainCyl= false;
	}
	
	public void update() {
		// Retrieve axis values from joysticks
		this.m_driveCmd = this.m_pilotStick.getRawAxis(RobotMap.DRIVE_AXIS);
		this.m_turnCmd = this.m_pilotStick.getRawAxis(RobotMap.TURN_AXIS);
		
		/**
		 * TODO 14: RETRIEVE CLIMBER VALUES FROM JOYSTICKS
		 * Read the buttons using this.m_pilotStick.getRawButton(RobotMap....).
		 * This function returns a boolean (true/false) for the button you request.
		 * Use this information and the following logic to update the climber commands
		 * 
		 * 		this.m_fireMainCyl = this.m_pilotStick.getRawButton(RobotMap.BTN_MAIN_CYL);
		 * 
		 * 		// Why? we only want to fire the main cylinder when we press and hold
		 * 		// the corresponding button - i.e. the corresponding button is true for
		 * 		// a while
		 * 
		 * 		if the BTN_EXT_CYL_REV button is pressed:
		 * 			set this.m_fireExtCyl to false
		 * 		else if the BTN_EXT_CYL_FWD button is pressed:
		 * 			set this.m_fireExtCyl to true
		 * 
		 * 		// Why? Think about the four situations we can have:
		 * 		//	1. Neither button is pressed: nothing happens; the cylinder stays in its
		 * 		//		current position
		 * 		//	2. BTN_EXT_CYL_REV is pressed: the cylinder is retracted
		 * 		// 	3. BTN_EXT_CYL_FWD is pressed: the cylinder is extended
		 *  	// 	4. Both buttons are pressed: the cylinder is retracted; we want this to 
		 *  	//		be its default state
		 */
	}
	
	public double getDriveCmd() {
		return this.m_driveCmd;
	}
	
	public double getTurnCmd() {
		return this.m_turnCmd;
	}
	
	public boolean getFireMainCyl() {
		return this.m_fireMainCyl;
	}
	
	public boolean getFireExtCyl() {
		return this.m_fireExtCyl;
	}

	@Override
	protected void initDefaultCommand() {} // Not used
}
