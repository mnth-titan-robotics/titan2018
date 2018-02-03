package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.Climber;
import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2789.robot.subsystems.OperatorInterface;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
	// Storage variables
	private double m_driveCommand;
	private double m_turnCommand;
	private double m_leftCmd;
	private double m_rightCmd;
	private boolean m_fireMainCyl;
	private boolean m_fireExtCyl;
	
	// Declare robot subsystems
	private DriveSystem m_driveSys;
	private OperatorInterface m_opFace;
	
	
	
	// Declares new objects:
	private Climber m_climber;
	private Compressor m_compressor;
	
	@Override
	public void robotInit() {
		// Construct robot subsystems
		this.m_driveSys = new DriveSystem();
		this.m_opFace = new OperatorInterface();
		this.m_climber = new Climber();
		this.m_compressor = new Compressor();
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
		
		// Start the compressor
		this.m_compressor.start();
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
		
		// Start the compressor
		this.m_compressor.start();
	}

	@Override
	public void teleopPeriodic() {
		// Update all sensor subsystems
		this.m_opFace.update();
		
		// Get information from sensor subsystems
		this.m_driveCommand = this.m_opFace.getDriveCmd();
		this.m_turnCommand = this.m_opFace.getTurnCmd();
		this.m_fireMainCyl = this.m_opFace.getFireMainCyl();
		this.m_fireExtCyl = this.m_opFace.getFireExtCyl();
		
		// Calculations
		this.m_leftCmd = -this.m_driveCommand + this.m_turnCommand;
		this.m_rightCmd = -this.m_driveCommand - this.m_turnCommand;
		
		this.m_leftCmd = RobotHelper.limit(this.m_leftCmd, -1.0, 1.0);
		this.m_rightCmd = RobotHelper.limit(this.m_rightCmd, -1.0, 1.0);
		
		// Set information for actuator subsystems
		this.m_driveSys.setCommands(this.m_leftCmd, this.m_rightCmd);
		this.m_climber.fireMainCyl(this.m_fireMainCyl);
		this.m_climber.fireExtCyl(this.m_fireExtCyl);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
		this.m_climber.update();
	}

	public void reset() {
		// Reset storage variables
		this.m_driveCommand = 0.0;
		this.m_turnCommand = 0.0;
		this.m_leftCmd = 0.0;
		this.m_rightCmd = 0.0;
		this.m_fireMainCyl = false;
		this.m_fireExtCyl = false;
		
		// Reset subsystems
		this.m_driveSys.reset();
		this.m_opFace.reset();
		this.m_climber.reset();
	
		// Stop the compressor
		this.m_compressor.stop();
	}

	@Override
	public void testPeriodic() {}
}

