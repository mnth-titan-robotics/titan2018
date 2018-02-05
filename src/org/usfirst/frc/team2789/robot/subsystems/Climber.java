package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	// Storage variables for piston commands
	private DoubleSolenoid.Value m_mainCylCmd;
	private DoubleSolenoid.Value m_extCylCmd; 
	
	//storage variable for climber motor
	// TODO: m_climbon should not be a double
	// Think about what it should be and fix it
	public static boolean m_climbOn;
	
	// TODO: look at the DriveSystem.java class
	// to see how to set up a Talon
		this.m_climbMtr = new Talon(RobotMap.MTR_CLIMB);
	
	// DoubleSolenoids to control cylinders
	private DoubleSolenoid m_mainCyl;
	private DoubleSolenoid m_extCyl;
	
	public Climber() {
		// Construct DoubleSolenoids with corresponding channels
		this.m_mainCyl = new DoubleSolenoid(
				RobotMap.DS_MAIN_CYL_FWD,
				RobotMap.DS_MAIN_CYL_REV);
		this.m_extCyl = new DoubleSolenoid(
				RobotMap.DS_EXT_CYL_FWD,
				RobotMap.DS_EXT_CYL_REV);
		
		// Reset all values
		this.reset();
	}
	
	public void reset() {
		// Reset piston commands to retract
		this.m_mainCylCmd = DoubleSolenoid.Value.kReverse;
		this.m_extCylCmd = DoubleSolenoid.Value.kReverse;	
	}
	
	public void update() {
		// Update actuators with commanded values
		this.m_mainCyl.set(this.m_mainCylCmd);
		this.m_extCyl.set(this.m_extCylCmd);
		
		// TODO: Look at DriveSystem.java to see how to 
		// command Talons.
		// To help you with the way the code should be structured,
		// try this:
		//
		// IF m_climbOn is true THEN
		//      set m_climbMtr to RobotMap.CLIMB_VAL
		// ELSE
		//		set m_climbMtr to 0.0
		
		
		
		if (this.m_climbOn = true; 
		
		else if (this.m_climbMtr(RobotMap.CLIMB_VAL)); {
			= false
			return
					this.m_climbMtr = 0.0;
		
	}
		
	// setter method
	// TODO: fill this in
	public void setClimbOn(boolean climbOn) {
	}

	public void fireMainCyl(boolean fire) {
		this.m_mainCylCmd = fire ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
		
		
	}
	
	public void fireExtCyl(boolean fire) {
		this.m_extCylCmd = fire ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
		
		
	}

	@Override
	protected void initDefaultCommand() {} // not used
}
