package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	// Storage variables for piston commands
	private DoubleSolenoid.Value m_mainCylCmd;
	private DoubleSolenoid.Value m_extCylCmd;
	
	//storage variable for climber motor
	public static double m_climbOn;
	private static double m_climbMtr;
	
	
	//motor talon
	private static final double TALON = m_climbMtr;

	//setter method
	void setClimbOn(boolean climbOn) {
	}
	
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
		
		if (this.m_climbMtr (RobotMap.CLIMB_VAL)); {
			= true;
		}
		else(this.m_climbMtr(RobotMap.CLIMB_VAL)); {
			= 0.0;
		
	}
	
	private boolean m_climbMtr(double climbVal) {
		// TODO Auto-generated method stub
		return false;
	}

	public void fireMainCyl(boolean fire) {
		this.m_mainCylCmd = fire ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
		
		// This does the same thing as all of this code:
		//
		// if(fire) {
		//	 this.m_mainCylCmd= DoubleSolenoid.Value.kForward;
		// }
		// else {
		//	 this.m_mainCylCmd= DoubleSolenoid.Value.kReverse;
		// }
	}
	
	public void fireExtCyl(boolean fire) {
		this.m_extCylCmd = fire ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
		
		// This does the same thing as all of this code:
		//
		// if(fire) {
		//	 this.m_extCylCmd= DoubleSolenoid.Value.kForward;
		// }
		// else {
		//	this.m_extCylCmd= DoubleSolenoid.Value.kReverse;
		// }
	}

	@Override
	protected void initDefaultCommand() {} // not used
}
