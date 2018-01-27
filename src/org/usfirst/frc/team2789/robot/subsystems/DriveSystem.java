package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	// Storage variables for motor commands
	private double m_leftCmd;		// Command for left drive motors [-1.0, 1.0]
	private double m_rightCmd;		// Command for right drive motors [-1.0, 1.0]
	
	// Talons to control motors
	private Talon m_talonFL;		// Front left Talon
	private Talon m_talonFR;		// Front right Talon
	private Talon m_talonBL;		// Back left Talon
	private Talon m_talonBR;		// Back right Talon
	
	public DriveSystem() {
		// Construct drive Talons with corresponding channels
		this.m_talonBL = new Talon (RobotMap.TALON_BL);
		this.m_talonBR = new Talon (RobotMap.TALON_BR);
		this.m_talonFL = new Talon (RobotMap.TALON_FL);
		this.m_talonFR = new Talon (RobotMap.TALON_FR);
		
		// Reset all values
		this.reset();
	}
	
	public void reset() {
		// Reset motor commands to 0.0
		this.m_leftCmd = 0.0;
		this.m_rightCmd = 0.0;
	}
	
	public void update() {
		// Update actuators with commanded values
		this.m_talonFL.set(this.m_leftCmd);
		this.m_talonBL.set(this.m_leftCmd);
		this.m_talonBR.set(this.m_rightCmd);
		this.m_talonFR.set(this.m_rightCmd);
	}
	
	public void setCommands(double leftCmd, double rightCmd) {
		// Set command values
		this.m_leftCmd = leftCmd;
		this.m_rightCmd = rightCmd;	
	}
	
	@Override
	protected void initDefaultCommand() {} // Not used
}