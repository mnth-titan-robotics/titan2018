package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OperatorInterface extends Subsystem {
	
	// DriveSystem Storage variables
	private double m_driveCmd;
	private double m_turnCmd;
	
	// Climber Storage Variables:
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
		
		// Retrieve climber pneumatic commands from joysticks
		this.m_fireMainCyl = this.m_pilotStick.getRawButton(RobotMap.BTN_MAIN_CYL);
		
		if (this.m_pilotStick.getRawButton(RobotMap.BTN_EXT_CYL_REV)) {
			this.m_fireExtCyl= false;
		}
		else if (this.m_pilotStick.getRawButton(RobotMap.BTN_EXT_CYL_FWD)) {
			this.m_fireExtCyl= true;
		}
		
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
