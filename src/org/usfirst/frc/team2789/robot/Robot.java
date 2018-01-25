package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 *	Assignment 01/23:
 *		For today's assignment, we're going to set up the DriveSystem object class.
 *	I've already walked through this with Thep, so we're going to try to recreate what
 *  we did there. The files you will need to work with are as follows:
 *  
 *  	DriveSystem.java 		- object class for drive system
 *  	Robot.java		 		- main code being run on robot; think of these as your
 *  							  main methods 
 *  	RobotMap.java	 		- library of constants to be referenced in other files
 *  
 *  The missing pieces that you need to implement are marked with comments containing
 *  the word TODO. I've numbered them in the order in which you should do them. There 
 *  are 16 in total.
 *  	When you're done, remember to push your code up to GitHub so that everyone has
 *  access to the source code for further work. As a reminder, the git commands are:
 *  
 *  	git pull				- download most recent copy of code from GitHub
 *  	git add .				- add any new files you've created to be tracked
 *  	git commit -am "msg"	- save a version of the files on your computer locally;
 *  							  make your message descriptive!!!
 *  	git push origin master	- upload your changes to GitHub; if you don't do this,
 *  							  the code you worked on won't be available to anyone
 *  							  else!
 *  
 *  Good luck! Looking forward to see how you guys do! Head over to DriveSystem.java to
 *  get started and keep a list of questions you have as you go so I can answer them on
 *  Wednesday!
 */

public class Robot extends TimedRobot {
	private DriveSystem m_driveSys;
	
	@Override
	public void robotInit() {
	
		this.m_driveSys = new DriveSystem();
	}

	@Override
	public void disabledInit() {

		this.m_driveSys.reset();
	}

	@Override
	public void disabledPeriodic() {
	
		this.m_driveSys.setCommands(0.0, 0.0);
		
		this.m_driveSys.update();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		// TODO 15: COMMAND THE MOTORS TO DO NOTHING
		// We don't have an auton right now, so let's make sure the robot doesn't move. Command
		// the drive system to do nothing.
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		// TODO 16: COMMAND THE MOTORS TO RUN
		// For now, let's just command the motors to run full forward (1.0) on the left and full
		// backwards (-1.0) on the right. If you get a chance to test this code with actual motors,
		// make sure they can't move!!!
		// This is the last step for today's assignment. If you finish early, get the roboRIO flashed
		// for Java and go help the other subsystems. Make sure this gets pushed up to GitHub so I can
		// review it. Good job!
	}

	@Override
	public void testPeriodic() {}
}
