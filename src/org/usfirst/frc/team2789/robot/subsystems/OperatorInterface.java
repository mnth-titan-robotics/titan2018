package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OperatorInterface extends Subsystem {
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
	
	public void reset() {
		this.m_driveCmd = 0.0;
		this.m_turnCmd = 0.0;
	}
	
	public void update() {
		// Retrieve axis values from joysticks
		this.m_driveCmd = this.m_pilotStick.getRawAxis(RobotMap.DRIVE_AXIS);
		this.m_turnCmd = this.m_pilotStick.getRawAxis(RobotMap.TURN_AXIS);
	}
	
	public double getDriveCmd() {
		return this.m_driveCmd;
	}
	
	public double getTurnCmd() {
		return this.m_turnCmd;
	}

	@Override
	protected void initDefaultCommand() {} // Not used
}
