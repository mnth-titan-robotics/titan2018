package org.usfirst.frc.team2789.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * I don't think the idea of object-oriented programming has fully stuck yet,
 * so let's do some scaffolding. I've provided a template for this class.
 * See if you can fill in the blanks.
 */

public class OperatorInterface extends Subsystem {
	// Storage variables
	private double m_driveCmd;
	private double m_turnCmd;
	
	// Joystick objects
	private Joystick m_pilotStick;
	private Joystick m_copilotStick;
	
	public OperatorInterface() {
		// TODO: Construct Joystick objects
		// Don't forget to specify the channels for the Joysticks in
		// RobotMap.java. Hint: reference DriveSystem.java's constructor
		// if you don't remember what to do here.
	}
	
	public void reset() {
		// TODO: Reset your storage variables
		// Hint: reference DriveSystem.java's reset() method if you don't
		// remember what to do here
	}
	
	public void update() {
		// TODO: Update storage variables by reading from the joysticks
		// Set the value of m_driveCmd to the value of axis 1 on
		// m_pilotStick. Set the value of m_turnCmd to the value of
		// axis 5 on m_pilotStick. Use the getRawAxis() function of
		// the joystick. Since the axes we'll be using are constants,
		// make sure to define them in RobotMap.java
	}
	
	public double getDriveCmd() {
		// TODO: return the value of m_driveCmd
		// Hint: reference the getBalance() function of your BankAccount
		// exercise
		return 0.0;
	}
	
	public double getTurnCmd() {
		// TODO: return the value of m_turnCmd
		// Hint: reference the getBalance() function of your BankAccount
		// exercise
		return 0.0;
	}

	@Override
	protected void initDefaultCommand() {} // Not used
}