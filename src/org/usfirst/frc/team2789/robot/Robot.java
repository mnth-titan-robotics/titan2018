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
		
	
		// Use climber command methods:
		this.m_fireMainCyl = this.m_opFace.getFireMainCyl();
		this.m_fireExtCyl = this.m_opFace.getFireExtCyl();
		// Also see lines 16 and 17 where I created these variables. I
		// forgot to leave a TODO to remind you guys to do this.
		
		// Get information from sensor subsystems
		this.m_driveCommand = this.m_opFace.getDriveCmd();
		this.m_turnCommand = this.m_opFace.getTurnCmd();
		
		// Calculations
		this.m_leftCmd = -this.m_driveCommand + this.m_turnCommand;
		this.m_rightCmd = -this.m_driveCommand - this.m_turnCommand;
		
		this.m_leftCmd = RobotHelper.limit(this.m_leftCmd, -1.0, 1.0);
		this.m_rightCmd = RobotHelper.limit(this.m_rightCmd, -1.0, 1.0);
		
	
		// Commands the climber:
		this.m_climber.fireMainCyl(this.m_fireMainCyl);
		this.m_climber.fireExtCyl(this.m_fireExtCyl);
		
		// Set information for actuator subsystems
		this.m_driveSys.setCommands(this.m_leftCmd, this.m_rightCmd);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
		
		
		// Updates climber:
		this.m_climber.update();
		// Why was your solution technically not wrong? In your attempt,
		// You declared m_climber as an Object (see line 28), but constructed
		// it as a Climber (see line 39). This is A TOTALLY VALID THING to do
		// in Java and there are some special instances where it is desired.
		// Usually not though because you want to be specific. When you declare
		// m_climber as an Object, Java will try to use m_climber as an Object
		// rather than as a Climber unless told specifically otherwise. This is
		// why your solution of
		//		((Climber) this.m_climber).update();
		// is not technically wrong. The first statement in parentheses tells
		// Java "Hey, use this object as though it were a Climber." and THEN
		// it calls update. For future reference, this feature is called "type
		// casting" and is a very powerful feature in object oriented programming.
	}

	public void reset() {
		// Reset storage variables
		this.m_driveCommand = 0.0;
		this.m_turnCommand = 0.0;
		this.m_leftCmd = 0.0;
		this.m_rightCmd = 0.0;
		
		// Reset subsystems
		this.m_driveSys.reset();
		this.m_opFace.reset();
		
		
		// resets climber:
		this.m_climber.reset();
		
	
		// Stops the compressor:
		this.m_compressor.stop();
	}

	@Override
	public void testPeriodic() {}
}

