package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2789.robot.subsystems.OperatorInterface;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
	private double m_driveCommand;
	private double m_turnCommand;
	private double m_leftCmd;
	private double m_rightCmd;
	
	// Declare robot subsystems
	private DriveSystem m_driveSys;
	private OperatorInterface m_opFace;
	
	@Override
	public void robotInit() {
		// Construct robot subsystems
		this.m_driveSys = new DriveSystem();
		this.m_opFace = new OperatorInterface();
	}

	@Override
	public void disabledInit() {
		// Reset all subsystem states
		this.reset();
	}

	@Override
	public void disabledPeriodic() {
		// Command the drive system to do nothing
		this.m_driveSys.setCommands(0.0, 0.0);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
	}

	@Override
	public void autonomousInit() {
		// Reset all subsystem states
		this.reset();
	}

	@Override
	public void autonomousPeriodic() {
		// Command the drive system to do nothing
		this.m_driveSys.setCommands(0.0,  0.0);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
	}

	@Override
	public void teleopInit() {
		// Reset all subsystem states
		this.reset();
	}

	@Override
	public void teleopPeriodic() {
		// Update all sensor subsystems
		this.m_opFace.update();
		
		// Get information from sensor subsystems
		this.m_driveCommand = this.m_opFace.getDriveCmd();
		this.m_turnCommand = this.m_opFace.getTurnCmd();
		
		// Calculations
		this.m_leftCmd = this.m_driveCommand + this.m_turnCommand;
		this.m_rightCmd = this.m_driveCommand - this.m_turnCommand;
		
		this.m_leftCmd = RobotHelper.limit(this.m_leftCmd, -1.0, 1.0);
		this.m_rightCmd = RobotHelper.limit(this.m_rightCmd, -1.0, 1.0);
		
		// Set information for actuator subsystems
		this.m_driveSys.setCommands(this.m_leftCmd, this.m_rightCmd);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
	}
	
	public void reset() {
		this.m_driveCommand = 0.0;
		this.m_turnCommand = 0.0;
		this.m_leftCmd = 0.0;
		this.m_rightCmd = 0.0;
		
		this.m_driveSys.reset();
		this.m_opFace.reset();
	}
	
	@Override
	public void testPeriodic() {}
}

