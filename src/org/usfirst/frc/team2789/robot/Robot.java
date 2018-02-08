package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.Climber;
import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2789.robot.subsystems.OperatorInterface;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * Assignment 02/03: FINISH UP THE CLIMBER; TEST AND DEBUG
 * I suspect the motor for the climber will be added soon, so let's
 * implement it. This time, I will leave a list of things you need
 * to do but not tell you where to do it. See if you can figure it
 * out.
 * 
 * In Robot.java:
 * DONE - create a storage variable for Climber motor named m_climbOn
 * 			> You'll want to use a boolean as the storage variable.
 * 			  Think about why and write your answer at the bottom of
 * 			  this file.
 * DONE	- reset m_climbOn
 * 		- get the appropriate value for m_climbOn from m_opFace
 * 		- set the Climber motor command
 * In RobotMap.java:
 * DONE - create a constant for the Climber motor channel named MTR_CLIMB
 * DONE	- create a constant for the button on the pilot joystick for
 * 		  running the Climber motor. Use button 0 and name it BTN_CLIMB_ON
 * DONE	- create a constant double for the value we will be telling the Climber
 * 		  motor to run. For now, set it to 1.0 and name it CLIMB_VAL
 * In Climber.java:
 * DONE - create a storage variable for the Climber motor named m_climbOn
 * DONE	- create a new Talon object named m_climbMtr
 * DONE - reset m_climbOn
 * DONE - create a setter method for setting the climb command.
 * 		  name it setClimbOn(boolean climbOn)
 * DONE - in update(), set m_climbMtr to RobotMap.CLIMB_VAL if m_climbOn is true.
 * 		  otherwise, set m_climbMtr to 0.0
 * DONE In OperatorInterface.java:
 * DONE	- create a storage variable for the Climber motor named m_climbOn
 * DONE - reset m_climbOn
 * DONE	- in update(), read button BTN_CLIMB_ON and set m_climbOn accordingly
 * DONE	- create a getter method for getting the climb command named
 * 		  getClimbOn()
 * When you finish these steps, git commit and push.
 * 
 * Note that I may have missed an item or two along the way, so just because you
 * did everything right according to the list of tasks above, the motor may not 
 * necessarily run. This is just a part of being a software developer. Sometimes
 * you think you do everything right only to find out nothing works because you
 * forgot the smallest step. When you finish this, put code on the robot, have
 * Geovanny help you hook up a motor to the RobotMap.MTR_CLIMB channel, and try
 * the climbing subsystem.
 * In software, we have what are called "unit tests". In this case, our unit tests
 * are as follows:
 * 		The Climber main cylinder should...
 * 			- stay retracted when no command is issued
 * 			- extend only when button 3 on the pilot joystick is pressed and held
 * 			- retract if button 3 on the pilot joystick is ever released
 * 		The Climber extension cylinder should...
 * 			- start off retracted
 * 			- extend when only button 1 on the pilot joystick is pressed
 * 			- stay extended if no other button is pressed
 * 			- retract if button 2 on the pilot joystick is pressed, regardless of 
 * 			  whether or not button 1 is pressed 
 * 			- stay retracted if no other button is pressed
 * 		The Climber motor should..
 * 			- turn on and stay on when button 0 on the pilot joystick is pressed
 * 			  and held
 * 			- turn off and stay off when button 0 on the pilot joystick is released
 * If any one of these tests fail, you can consider your code "broken" or "buggy".
 * Make your best attempt at debugging it. See if you can figure out what went wrong.
 * Don't be upset if you can't figure it out. Sometimes if you stare at code for too
 * long, it stops making sense. If you get stuck, get the code back into a working 
 * state (i.e. - the base moves so we can do driver practice), commit and push it. 
 * Go take a walk, grab a snack, help the other subsystems, and come back to look 
 * at the code with fresh eyes. I'll be back on Monday to help and feel free to text 
 * me if you have any questions. I'll be busy most of the day so I may not respond 
 * immediately.
 * 
 * Good luck! See you Monday!
 */ 

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
	private double m_intakeCmd;
	
	// Declare robot subsystems
	private DriveSystem m_driveSys;
	private OperatorInterface m_opFace;
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
		this.m_climbOn = this.m_opFace.getClimbOn();
		this.m_intakeCmd = this.m_opFace.getintakeCmd();
		
		if(this.m_fireMainCyl) {
			System.out.println("Fire main Cyl");
		}
		
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
		
		// Update all actuator subsystems
		this.m_driveSys.update();
		this.m_climber.update();
		
		System.out.println(m_climber);
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
		
		System.out.println(m_driveCommand);
		System.out.println(m_turnCommand);
		System.out.println(m_leftCmd);
		System.out.println(m_rightCmd);
		System.out.println(m_fireExtCyl);
		System.out.println(m_climbOn);
		
		// Reset subsystems
		this.m_driveSys.reset();
		this.m_opFace.reset();
		this.m_climber.reset();
	
		System.out.println(m_driveSys);
		System.out.println(m_opFace);
		
		// Stop the compressor
		this.m_compressor.stop();
		
		System.out.println(m_compressor);
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