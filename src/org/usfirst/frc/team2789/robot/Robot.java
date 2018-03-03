package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.Climber;
import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2789.robot.subsystems.OperatorInterface;
import org.usfirst.frc.team2789.robot.subsystems.Intake;

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
	private boolean m_climbOn;
	private boolean m_liftDown;
	private boolean m_liftUp;
	private boolean m_liftMax;
	private double m_intakeCmd;
	private long m_autonStartTime;
	private boolean m_waitComplete;
	
	// Declare robot subsystems
	private DriveSystem m_driveSys;
	private OperatorInterface m_opFace;
	private Climber m_climber;
	private Compressor m_compressor;
	private Intake m_intake;
	
	@Override
	public void robotInit() {
		// Construct robot subsystems
		this.m_driveSys = new DriveSystem();
		this.m_opFace = new OperatorInterface();
		this.m_climber = new Climber();
		this.m_compressor = new Compressor();
		this.m_intake = new Intake();
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
		this.m_waitComplete = false;
		
		this.m_autonStartTime = System.currentTimeMillis();
	}

	@Override
	public void autonomousPeriodic() {
		if((System.currentTimeMillis() >= this.m_autonStartTime + RobotMap.AUTON_WAIT_MILLIS) && !this.m_waitComplete) {
			this.m_waitComplete = true;
			this.m_autonStartTime = System.currentTimeMillis();
		}
		
		if ((System.currentTimeMillis() < this.m_autonStartTime + RobotMap.AUTON_IN_MILLIS) && this.m_waitComplete) {
			this.m_driveSys.setCommands(RobotMap.AUTON_POWER, RobotMap.AUTON_POWER);
		}
		else {
			this.m_driveSys.setCommands(0.0, 0.0);
		}
		
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
		this.m_climbOn = this.m_opFace.getClimbOn();
		this.m_liftDown = this.m_opFace.getLiftDown();
		this.m_liftUp = this.m_opFace.getLiftUp();
		this.m_liftMax = this.m_opFace.getLiftMax();
		this.m_intakeCmd = this.m_opFace.getIntakeCmd();
		
		// Calculations
		this.m_leftCmd = -this.m_driveCommand + this.m_turnCommand;
		this.m_rightCmd = -this.m_driveCommand - this.m_turnCommand;
		
		this.m_leftCmd = RobotHelper.limit(this.m_leftCmd, -1.0, 1.0);
		this.m_rightCmd = RobotHelper.limit(this.m_rightCmd, -1.0, 1.0);
		
		// Set information for actuator subsystems
		this.m_driveSys.setCommands(this.m_leftCmd, this.m_rightCmd);
		this.m_climber.fireMainCyl(this.m_fireMainCyl);
		this.m_climber.fireExtCyl(this.m_fireExtCyl);
		this.m_climber.setClimbOn(this.m_climbOn);
		this.m_intake.setLiftUp(this.m_liftUp);
		this.m_intake.setLiftDown(this.m_liftDown);
		this.m_intake.setLiftMax(this.m_liftMax);
		this.m_intake.setIntakeCmd(this.m_intakeCmd);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
		this.m_climber.update();
		this.m_intake.update();
	}

	public void reset() {
		// Reset storage variables
		this.m_driveCommand = 0.0;
		this.m_turnCommand = 0.0;
		this.m_leftCmd = 0.0;
		this.m_rightCmd = 0.0;
		this.m_fireMainCyl = false;
		this.m_fireExtCyl = false;
		this.m_climbOn = false;
		this.m_liftMax = false;
		this.m_intakeCmd = 0.0;
		this.m_autonStartTime= 0;
		
		// Reset subsystems
		this.m_driveSys.reset();
		this.m_opFace.reset();
		this.m_climber.reset();
		this.m_intake.reset();
		
		// Stop the compressor
		this.m_compressor.stop();
	}

	@Override
	public void testPeriodic() {}
}

/**
 * Why should the Climber motor storage variable be a boolean?
 * 
 * Your answer:
 * It should be a boolean because the rest of the climber mech uses boolean and we are not keeping complete control of it we are turning it off and on.
 * 
 * Close. Correct answer is that we want to use a boolean because we are only turning it off and on. What the rest of the climber uses should have
 * no impact on what we choose to use for the motor.
 * 
 */