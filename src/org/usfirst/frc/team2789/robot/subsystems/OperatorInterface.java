package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OperatorInterface extends Subsystem {
	/**
	 * TODO 12: CREATE CLIMBER STORAGE VARIABLES
	 * We now need climber storage variables that we read from the
	 * controller. Since we'll be using buttons, the variables
	 * will be booleans. Let's name them as follows:
	 * 		m_fireMainCyl, m_fireExtCyl
	 */
	
	//Climber variables
	boolean m_fireMainCyl;
	boolean m_fireExtCyl;
	
	// Storage variables
	private double m_driveCmd;
	private double m_turnCmd;
	
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
	
	/**
	 * TODO 13: RESET CLIMBER STORAGE VARIABLES
	 * Set m_fireMainCyl and m_fireExtCyl to a default value of false
	 */
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
		 * Create button mappings in RobotMap.java:
		 * 		BTN_MAIN_CYL = 3
		 * 		BTN_EXT_CYL_FWD = 1
		 * 		BTN_EXT_CYL_REV = 2
		 * 
		 **/
		
		
		
		 /** The buttons on the gamepad are numbered as such:
		 * 
		 * 		  3
		 * 		2   1
		 * 		  0
		 * 
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
		 **/
	}
	
	public double getDriveCmd() {
		return this.m_driveCmd;
	}
	
	public double getTurnCmd() {
		return this.m_turnCmd;
	}
	
	/**
	 * TODO 15: GETTER METHODS FOR CLIMBER COMMANDS
	 * Fill in the blanks below:
	 */
	public boolean getFireMainCyl() {
		return this.m_fireMainCyl;// your code here
	}
	
	public boolean getFireExtCyl() {
		return this.m_fireExtCyl;// your code here
	}

	@Override
	protected void initDefaultCommand() {} // Not used
}
