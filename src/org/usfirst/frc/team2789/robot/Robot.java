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
	// TODO 11: CREATE DRIVESYSTEM OBJECT
	// Now that we've defined our DriveSystem (hooray!), we need to actually get the robot
	// to use it. I'll go ahead and set this up for you, but in the future for future
	// subsystems, you'll be expected to set it up yourself. Note that our new DriveSystem
	// object class needs to be imported (line 3). Delete this comment when you've read it
	private DriveSystem m_driveSys;
	
	@Override
	public void robotInit() {
		// TODO 12: CONSTRUCT THE DRIVESYSTEM
		// The robotInit() method is run when only once when the robot is turned on and never
		// again. This is where we want to instantiate the DriveSystem object. I've gone ahead
		// and done this for you, but you'll be expected to do this for future subsystems.
		// Delete this comment when you've read it.
		this.m_driveSys = new DriveSystem();
	}

	@Override
	public void disabledInit() {
		// TODO 13: RE-INITIALIZE THE DRIVESYSTEM
		// This command is run only once each time we enter the disabled state. When we do, we
		// want to re-initialize the DriveSystem object. I'll fill this one in. You should
		// make sure to re-initialize the DriveSystem for each of the other init methods
		// (autonomousInit(), teleopInit()). Delete this comment when you're done.
		this.m_driveSys.reset();
	}

	@Override
	public void disabledPeriodic() {
		// TODO 14: COMMAND THE MOTORS
		// disabledPeriodic is a list of commands you want your robot to run through while it's
		// in the disabled mode. For now, we just want to command it to do nothing. Don't forget
		// to force it to update as well! I'll fill this one in as an example. Delete this comment
		// when you've read it.
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
