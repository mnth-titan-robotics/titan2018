package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
	// Declare robot subsystems
	private DriveSystem m_driveSys;
	
	@Override
	public void robotInit() {
		// Construct robot subsystems
		this.m_driveSys = new DriveSystem();
	}

	@Override
	public void disabledInit() {
		// Reset all subsystem states
		this.m_driveSys.reset();
	}

	@Override
	public void disabledPeriodic() {
		// Command the drive system to do nothing
		this.m_driveSys.setCommands(0.0, 0.0);
		
		// Update all subsystems
		this.m_driveSys.update();
	}

	@Override
	public void autonomousInit() {
		// Reset all subsystem states
		this.m_driveSys.reset();
	}

	@Override
	public void autonomousPeriodic() {
		// Command the drive system to do nothing
		this.m_driveSys.setCommands(0.0,  0.0);
		
		// Update all subsystems
		this.m_driveSys.update();
	}

	@Override
	public void teleopInit() {
		// Reset all subsystem states
		this.m_driveSys.reset();
	}

	@Override
	public void teleopPeriodic() {
		// Command the motors to move for now
		this.m_driveSys.setCommands(1.0, -1.0);
		
		// Update all subsystems
		this.m_driveSys.update();
	}
	
	@Override
	public void testPeriodic() {}
}
