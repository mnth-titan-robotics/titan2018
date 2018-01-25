package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

// TODO 01: READ ME
// The DriveSystem object class is the one we will be using to handle all motors that we
// use to drive the robot base. Note the "extends" keyword. This means the same as "is a",
// i.e. - class DriveSystem "is a" Subsystem. Delete these comments when you're done reading
// them and head over to the RobotMap.java file.
public class DriveSystem extends Subsystem {
	
	// TODO 06: COMMAND STORAGE VARIABLES
	// Huh. That's weird. Why is task 06 above task 4? When coding, you want to organize
	// your code in a logical manner. Just like we group the Talon declarations in the
	// same chunk of code to make it easier to work with, we also tend to put simple data
	// types before objects and complex data types. Recall that Java's simple data types
	// are ints, doubles, bools, and chars. Even though Strings aren't technically "simple"
	// we consider them to be as well.
	// Create two private decimal-point variables named m_leftCmd and m_rightCmd. Why do we
	// need these? If we command motors individually from the joystick, the values we read
	// from the joystick may change in the milliseconds between when we command one motor and
	// the next. To prevent this, we want to read the joysticks only once, store the values
	// in m_leftCmd and m_rightCmd and use those values to update the motors so we command
	// all of the motors using the same values.
	private double m_leftCmd;
	
	private double m_rightCmd;
	// TODO 04: SPEED CONTROLLER OBJECTS
	// In order to control the motors, we need to have speed controller objects to
	// manipulate. As in BankAccount, we don't want any external things to access
	// these speed controllers directly. I've gone ahead and imported the Talon
	// library for you (line 3). An example for how to create a Talon is shown below.
	// Delete it when you finish this task. I want you to create one Talon for each
	// of the drive motors:
	//		m_talonFL, m_talonFR, m_talonBL, m_talonBR
	private Talon m_talonFL;
	private Talon m_talonFR;
	private Talon m_talonBL;
	private Talon m_talonBR;
	
	// TODO 05: CONSTRUCTOR
	// Create a constructor for a DriveSystem object that instantiates each of the
	// Talons. I've gone ahead and provided the method signature for you. Just fill
	// it out. Remember to map each Talon to its respective channel.
	public DriveSystem() {
		m_talonFL = new Talon(RobotMap.TALON_FL);
		m_talonFR = new Talon(RobotMap.TALON_FR);
		m_talonBL = new Talon (RobotMap.TALON_BL);
		m_talonBR = new Talon(RobotMap.TALON_BR);
		// TODO 07: INITIALIZE VARIABLES
		// In your constructor, you always want to provide initial values to all of your
		// member variables. In this case, we want to make sure m_leftCmd and m_rightCmd
		// are set to 0.0
		
		// Example instantiation of Talon mapped to channel RobotMap.CONST_INT
		this.m_talonBL = new Talon (RobotMap.TALON_BL);
		this.m_talonBR = new Talon (RobotMap.TALON_BR);
		this.m_talonFL = new Talon (RobotMap.TALON_FL);
		this.m_talonFR = new Talon (RobotMap.TALON_FR);
		
	}
	
	// TODO 08: RESET COMMAND
	// This is a very important piece of this code. Each time we enter a new state
	// (auton, teleop, disabled), we want to reset some variables to their default
	// values. In this case, we want to set m_leftCmd and m_rightCmd back to 0.0
	public void reset() {
		double m_leftCmd = 0.0;
		double m_rightCmd = 0.0;
		
		
	}
	
	// TODO 10: UPDATE METHOD
	// The robot runs a cyclical process, which means it runs through the same sequence
	// of events over and over as long as it's running. After we tell it what we want
	// the commands we want to use are through setCommands(), we want to make sure to update
	// the speed controllers to use the new values we give it. I've provided an example
	// below. Make sure to set the two left talons (m_talonFL, m_talonBL) to m_leftCmd and
	// the two right talons to m_rightCmd. When you're done with this, head back over to
	// Robot.java
	public void update() {
		this.m_talonFL.set(m_leftCmd);
		this.m_talonBL.set(m_leftCmd);
		this.m_talonBR.set(m_rightCmd);
		this.m_talonFR.set(m_rightCmd);
	}
	
	// TODO 09: SETTER METHOD
	// Now that we have some private storage variables, we need to have a way to
	// read/write these variables. We call these "getter" and "setter" methods. For
	// the motors, since we only care externally about commanding them, but don't care
	// about figuring out what they're doing, we only need setter methods. I've gone
	// ahead and provided the method signature for you. Just fill it out.
	// The input parameters are as follows:
	//		leftCmd		- command for the left motor controllers [-1.0, 1.0]
	//		rightCmd	- command for the right motor controllers [-1.0, 1.0]
	public void setCommands(double leftCmd, double rightCmd) {
		
		
	}
	
	@Override
	protected void initDefaultCommand() {} // Not used
}
