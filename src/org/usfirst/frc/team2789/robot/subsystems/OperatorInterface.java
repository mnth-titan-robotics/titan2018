package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class OperatorInterface extends Subsystem {

    // DriveSystem Storage variables
    private double m_driveCmd;
    private double m_turnCmd;

    // Climber Storage Variables:
    private boolean m_fireMainCyl;
    private boolean m_fireExtCyl;
    private boolean m_climbOn;

    // Intake Storage Variables:
//    private boolean m_liftDown;
//    private boolean m_liftUp;
    private double m_intakeCmd;
    private double m_liftCmd;
//    private boolean m_liftMax;

    // Joystick objects
    private Joystick m_pilotStick;
    private Joystick m_copilotStick;

    public OperatorInterface() {
        // Create new joysticks
        this.m_pilotStick = new Joystick(RobotMap.JOYSTICK_PILOT);
        this.m_copilotStick = new Joystick(RobotMap.JOYSTICK_COPILOT);

        // Reset storage variables
        this.reset();
    }

    public void reset() {
        this.m_driveCmd = 0.0;
        this.m_turnCmd = 0.0;
        this.m_fireExtCyl = false;
        this.m_fireMainCyl = false;
        this.m_intakeCmd = 0.0;
        this.m_liftCmd = 0.0;
//        this.m_liftDown = false;
//        this.m_liftUp = false;
//        this.m_liftMax = false;
    }

    public void update() {
        // Retrieve axis values from joysticks
        this.m_driveCmd = this.m_pilotStick.getRawAxis(RobotMap.AXIS_PILOT_DRIVE);
        this.m_turnCmd = this.m_pilotStick.getRawAxis(RobotMap.AXIS_PILOT_TURN);

        // Intake roller command
        if(this.m_copilotStick.getRawButton(RobotMap.BTN_COPILOT_INTAKE_OFF)) {
            this.m_intakeCmd = 0.0;
        }
        else if(Math.abs(this.m_copilotStick.getRawAxis(RobotMap.AXIS_COPILOT_INTAKE_OUT)) > 0.5) {
            this.m_intakeCmd = (-RobotMap.INTAKE_POWER);
        }
        else if(this.m_copilotStick.getRawButton(RobotMap.BTN_COPILOT_INTAKE_IN)) {
            this.m_intakeCmd = (RobotMap.INTAKE_POWER);
        }

        // Intake
//        this.m_liftUp = this.m_copilotStick.getRawButton(RobotMap.BTN_COPILOT_LIFT_UP);
//        this.m_liftDown = Math.abs(this.m_copilotStick.getRawAxis(RobotMap.AXIS_COPILOT_LIFT_DOWN)) > 0.5;
//        this.m_liftMax = this.m_copilotStick.getRawButton(RobotMap.BTN_COPILOT_LIFT_UP_MAX);
        this.m_liftCmd = this.m_copilotStick.getRawAxis(RobotMap.AXIS_COPILOT_LIFT);

        // Retrieve climber pneumatic commands from joysticks
        this.m_fireMainCyl = this.m_pilotStick.getRawButton(RobotMap.BTN_PILOT_MAIN);

        if(this.m_pilotStick.getRawButton(RobotMap.BTN_PILOT_EXT_FWD)) {
            this.m_fireExtCyl = true;
        }

        if(this.m_pilotStick.getRawButton(RobotMap.BTN_PILOT_EXT_REV)) {
            this.m_fireExtCyl = false;
        }
        
        // Climber motor command
        this.m_climbOn = this.m_pilotStick.getRawButton(RobotMap.BTN_PILOT_CLIMB_ON);

    }

    public boolean getFireMainCyl() {
        return this.m_fireMainCyl;
    }

    public boolean getFireExtCyl() {
        return this.m_fireExtCyl;
    }

    public boolean getClimbOn() {
        return this.m_climbOn;
    }

    public double getIntakeCmd() {
        return this.m_intakeCmd;
    }
    
    public double getLiftCmd() {
    	return this.m_liftCmd;
    }

//    public boolean getLiftUp() {
//        return this.m_liftUp;
//    }
//
//    public boolean getLiftDown() {
//        return this.m_liftDown;
//    }
//    
//    public boolean getLiftMax() {
//    	return this.m_liftMax;
//    }

    public double getDriveCmd() {
        return this.m_driveCmd;
    }

    public double getTurnCmd() {
        return this.m_turnCmd;
    }

    @Override
    protected void initDefaultCommand() {
    } // Not used
}
