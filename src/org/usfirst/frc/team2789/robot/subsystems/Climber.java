package org.usfirst.frc.team2789.robot.subsystems;

import org.usfirst.frc.team2789.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

    // Storage variables
    private DoubleSolenoid.Value m_mainCylCmd;
    private DoubleSolenoid.Value m_extCylCmd;
    private boolean m_climbOn;

    // Climber pneumatics
    private DoubleSolenoid m_mainCyl;
    private DoubleSolenoid m_extCyl;
    
    // Climber motor
  

    public Climber() {
        // Construct DoubleSolenoids with corresponding channels
        this.m_mainCyl = new DoubleSolenoid(RobotMap.DS_CLIMBER_MAIN_FWD, RobotMap.DS_CLIMBER_MAIN_REV);
        this.m_extCyl = new DoubleSolenoid(RobotMap.DS_CLIMBER_EXT_FWD, RobotMap.DS_CLIMBER_EXT_REV);



        // Reset all values
        this.reset();
    }

    public void reset() {
        // Reset storage variables
        this.m_mainCylCmd = DoubleSolenoid.Value.kReverse;
        this.m_extCylCmd = DoubleSolenoid.Value.kReverse;
        this.m_climbOn = false;
    }

    public void update() {
        // Update cylinders
        this.m_mainCyl.set(this.m_mainCylCmd);
        this.m_extCyl.set(this.m_extCylCmd);

        // Update Talon
     
        

    }

    public void setClimbOn(boolean climbOn) {
        this.m_climbOn = climbOn;
    }

    public void fireMainCyl(boolean fire) {
        if(fire) {
            this.m_mainCylCmd = DoubleSolenoid.Value.kForward;
        }
        else {
            this.m_mainCylCmd = DoubleSolenoid.Value.kReverse;
        }
    }

    public void fireExtCyl(boolean fire) {
        if(fire) {
            this.m_extCylCmd = DoubleSolenoid.Value.kForward;
        }
        else {
            this.m_extCylCmd = DoubleSolenoid.Value.kReverse;
        }
    }

    @Override
    protected void initDefaultCommand() {
    } // not used

}