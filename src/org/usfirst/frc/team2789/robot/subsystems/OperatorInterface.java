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
	private boolean m_climbOn;
	
	//Intake Storage Variables:
	private boolean m_liftDown;
	private boolean m_liftUp;
	private double m_intakeCmd;
	
	// Joystick objects
	private Joystick m_pilotStick;
	private Joystick m_copilotStick;
	
	public OperatorInterface() {
		// Create new joysticks
		this.m_pilotStick = new Joystick (RobotMap.JOYSTICK_PILOT);
		this.m_copilotStick =(new Joystick (RobotMap.JOYSTICK_COPILOT));
		
		// Reset storage variables
		this.reset();
	}
	
	public void reset() {
		this.m_driveCmd = 0.0;
		this.m_turnCmd = 0.0;
		this.m_fireExtCyl= false;
		this.m_fireMainCyl= false;
		this.m_intakeCmd = 0.0;
	}
	
	public void update() {
		// Retrieve axis values from joysticks
		this.m_driveCmd = this.m_pilotStick.getRawAxis(RobotMap.DRIVE_AXIS);
		this.m_turnCmd = this.m_pilotStick.getRawAxis(RobotMap.TURN_AXIS);
		this.m_climbOn = this.m_pilotStick.getRawButton(RobotMap.BTN_CLIMB_ON);
		this.m_intakeCmd = this.m_copilotStick.getRawAxis(RobotMap.LIFT_MTR);
		
		// Retrieve climber pneumatic commands from joysticks
		this.m_fireMainCyl = this.m_pilotStick.getRawButton(RobotMap.BTN_MAIN_CYL);
		
		if (this.m_pilotStick.getRawButton(RobotMap.BTN_EXT_CYL_REV)) {
			this.m_fireExtCyl= false;
		}
		else if (this.m_pilotStick.getRawButton(RobotMap.BTN_EXT_CYL_FWD)) {
			this.m_fireExtCyl= true;
		}
		
	}

	
	public boolean getFireMainCyl() {
		return this.m_fireMainCyl;
	}
	
	public boolean getFireExtCyl() {
		return this.m_fireExtCyl;
	}
	
	public boolean getClimbOn() {
		return this.m_climbOn;
	}
	
	public double getintakeCmd() {
		return this.m_intakeCmd;
	}
	
	public double getDriveCmd() {
		return this.m_driveCmd;
	}
	
	public double getTurnCmd() {
		return this.m_turnCmd;
	}
	
	@Override
	protected void initDefaultCommand() {} // Not used
	public boolean isM_liftDown() {
		return m_liftDown;
	}
	public void setM_liftDown(boolean m_liftDown) {
		this.m_liftDown = m_liftDown;
	}
	public boolean isM_liftUp() {
		return m_liftUp;
	}
	public void setM_liftUp(boolean m_liftUp) {
		this.m_liftUp = m_liftUp;
	}

	public Joystick getM_copilotStick() {
		return m_copilotStick;
	}

	public void setM_copilotStick(Joystick m_copilotStick) {
		this.m_copilotStick = m_copilotStick;
	}
}

	