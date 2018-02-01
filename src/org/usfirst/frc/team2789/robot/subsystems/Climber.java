package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private DoubleSolenoid.Value m_mainCylValue;
	private DoubleSolenoid.Value m_extCylValue;
	
	private DoubleSolenoid m_mainCyl;
	private DoubleSolenoid m_extCyl;
	
	public Climber() {
		this.m_mainCyl= new DoubleSolenoid(RobotMap.DS_MAIN_CYL_FWD,RobotMap.DS_MAIN_CYL_REV);
		this.m_extCyl= new DoubleSolenoid(RobotMap.DS_EXT_CYL_FWD,RobotMap.DS_EXT_CYL_REV);
		
		this.reset();
	}
	
	public void update() {
		this.m_mainCyl.set(this.m_mainCylValue);
		this.m_extCyl.set(this.m_extCylValue);
	}
	
	public void reset() {
		this.m_mainCylValue=DoubleSolenoid.Value.kReverse;
		this.m_extCylValue=DoubleSolenoid.Value.kReverse;	
	}
	
	public void fireMainCyl(boolean fire) {
		if(fire) {
			this.m_mainCylValue= DoubleSolenoid.Value.kForward;
		}
		else {
			this.m_mainCylValue= DoubleSolenoid.Value.kReverse;
		}		
	}
	
	public void fireExtCyl(boolean fire) {
		if(fire) {
			this.m_extCylValue= DoubleSolenoid.Value.kForward;
		}
		else {
			this.m_extCylValue= DoubleSolenoid.Value.kReverse;
		}
	}

	@Override
	protected void initDefaultCommand() {} // not used
}
