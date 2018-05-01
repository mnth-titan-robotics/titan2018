package org.usfirst.frc.team2789.robot;

import org.usfirst.frc.team2789.robot.subsystems.Climber;
import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2789.robot.subsystems.OperatorInterface;
import org.usfirst.frc.team2789.robot.subsystems.Intake;
import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private long m_autonStartTime;
	private boolean m_waitComplete;
	private double m_autoWait = RobotMap.AUTON_WAIT_MILLIS;
	private double m_autoDrive = RobotMap.AUTON_IN_MILLIS;
	private double m_autoPower = RobotMap.AUTON_POWER;
	private Timer m_timer = new Timer();
	private String m_autoCommand;
	private static final String kNoAuto = "No Auto";
	private static final String kDriveAuto = "Drive Auto";
	private static final String kSwitchAuto = "Switch Auto";
	DriverStation m_ds;
	private char m_switch_side = '-';

	SendableChooser<String> m_chooser = new SendableChooser<>();

	// Declare robot subsystems
	private DriveSystem m_driveSys;
	private OperatorInterface m_opFace;
	private Climber m_climber;
	private Compressor m_compressor;
	private Intake m_intake;

	@Override
	public void robotInit() {
		// Construct robot subsystems
		this.m_driveSys = new DriveSystem();
		this.m_opFace = new OperatorInterface();
		this.m_climber = new Climber();
		this.m_compressor = new Compressor();
		this.m_intake = new Intake();

		m_chooser.addObject("No Auto", kNoAuto);
		m_chooser.addDefault("Move Foward", kDriveAuto);
		m_chooser.addObject("Switch Auto", kSwitchAuto);
		SmartDashboard.putData("Auto Choices", m_chooser);
		SmartDashboard.putNumber("Delay start time", RobotMap.AUTON_WAIT_MILLIS);
		SmartDashboard.putNumber("Auto speed", RobotMap.AUTON_POWER);
		SmartDashboard.putNumber("Auto time", RobotMap.AUTON_IN_MILLIS);

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
		this.m_waitComplete = false;

		this.m_autonStartTime = System.currentTimeMillis();
		m_autoCommand = m_chooser.getSelected();

		SmartDashboard.getNumber("Delay start time", m_autoWait);
		SmartDashboard.getNumber("Auto speed", m_autoPower);
		SmartDashboard.getNumber("Auto time", m_autoDrive);
		m_timer.reset();
		m_timer.start();
	}

	@Override
	public void autonomousPeriodic() {

		double timer = m_timer.get();
		switch (m_autoCommand) {
		case kSwitchAuto:
			m_switch_side = 'R';
			if (m_switch_side == 'L') {
				if (timer < m_autoWait) {
					this.m_waitComplete = true;
					this.m_autonStartTime = System.currentTimeMillis();
					

				}

				else if (timer > (m_autoWait + m_autoDrive)) {
					this.m_driveSys.setCommands(0.0, 0.0);
				} else {

					this.m_driveSys.setCommands(m_autoPower, m_autoPower);
				}
			} else if (m_switch_side == 'R') {
				if (timer < m_autoWait) {
					this.m_waitComplete = true;
					this.m_autonStartTime = System.currentTimeMillis();

				}

				else if (timer > (m_autoWait + m_autoDrive + 2.0)) {
					this.m_intake.openIntake(-RobotMap.INTAKE_POWER);
					
				} else if (timer > (m_autoWait + m_autoDrive)){
					this.m_driveSys.setCommands(0.0, 0.0);
				}
				
				else {

					this.m_driveSys.setCommands(m_autoPower, m_autoPower);
				}
			} else {
				String gd = m_ds.getGameSpecificMessage();
				if (gd.length() > 0) {
					m_switch_side = gd.charAt(0);

				}
			}

			break;

		case kDriveAuto:
		default:
			if (timer < m_autoWait) {
				this.m_waitComplete = true;
				this.m_autonStartTime = System.currentTimeMillis();

			}

			else if (timer > (m_autoWait + m_autoDrive)) {
				this.m_driveSys.setCommands(0.0, 0.0);
			} else {

				this.m_driveSys.setCommands(m_autoPower, m_autoPower);
			}

			break;

		case kNoAuto:
			break;
		}
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
		this.m_liftDown = this.m_opFace.getLiftDown();
		this.m_liftUp = this.m_opFace.getLiftUp();
		this.m_intakeCmd = this.m_opFace.getIntakeCmd();

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
		this.m_intake.setLiftUp(this.m_liftUp);
		this.m_intake.setLiftDown(this.m_liftDown);
		this.m_intake.setIntakeCmd(this.m_intakeCmd);

		// Update all actuator subsystems
		this.m_driveSys.update();
		this.m_climber.update();
		this.m_intake.update();
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
		this.m_intakeCmd = 0.0;
		this.m_autonStartTime = 0;
		this.m_liftUp = false;
		this.m_liftDown = false;

		// Reset subsystems
		this.m_driveSys.reset();
		this.m_opFace.reset();
		this.m_climber.reset();
		this.m_intake.reset();

		// Stop the compressor
		this.m_compressor.stop();
	}

	@Override
	public void testPeriodic() {
	}
}
