package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private boolean m_liftDown;
	private boolean m_liftUp;
	private double m_intakeCmd;
	
	
	private Talon m_liftMtr;
	private Talon m_intakeLeft;
	private Talon m_intakeRight;
	
	public Intake() {
		this.m_liftMtr = new Talon(RobotMap.LIFT_MTR);
		this.m_intakeLeft = new Talon(RobotMap.INTAKE_LEFT);
		this.m_intakeRight = new Talon(RobotMap.INTAKE_RIGHT);
		
		this.reset();
	}
	public void reset() {
		
		this.m_liftDown = false;
		this.m_liftUp = false;
		this.m_intakeCmd = 0.0;
	}
	
	public void update() {
		if(m_liftUp && ! m_liftDown) {
			this.m_liftMtr.set(RobotMap.LIFT_POWER);
		}
		else if(m_liftDown && ! m_liftUp) {
			this.m_liftMtr.set(-RobotMap.LIFT_POWER);
		}
		else {
			this.m_liftMtr.set(0.0);
		}
		this.m_intakeLeft.set(m_intakeCmd);
		this.m_intakeRight.set(-m_intakeCmd);
	}
	
	public void setLiftUp(boolean liftUp) {
		this.m_liftUp= liftUp;
	}
	public void setLiftDown(boolean liftDown) {
		this.m_liftDown= liftDown;
	}
	public void setIntakeCmd(double intakeCmd) {
		this.m_intakeCmd= intakeCmd ;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
}
