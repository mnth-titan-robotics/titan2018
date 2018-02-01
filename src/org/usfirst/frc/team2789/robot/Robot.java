package org.usfirst.frc.team2789.robot;

/**
 * TODO 01: IMPORT THE CLIMBER
 * I went ahead and did this for you. Delete this comment when you're done
 */
import org.usfirst.frc.team2789.robot.subsystems.Climber;
import org.usfirst.frc.team2789.robot.subsystems.DriveSystem;
import org.usfirst.frc.team2789.robot.subsystems.OperatorInterface;

/**
 * TODO 02: IMPORT THE COMPRESSOR
 * We also need to create and start a compressor object, so let's import it.
 * I've gone ahead and done it for you. Delete this comment when you're done
 */
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * Assignment 02/01: Finish implementing the Climber subsystem
 * 
 * Yesterday (01/31), Sylvia and I created the Climber subsystem. Recall 
 * that for actuator subsystems, we need the following things:
 * 
 * 		- Variables for the commands that we want to issue eventually
 * 		- Actuator objects to command
 * 		- Constructor to create the objects needed
 * 		- Some means of resetting the command variables (reset())
 * 		- Some means of updating the command variables
 * 		- Some means of updating the actuators to do the commands (update())
 * 
 * Today, we're going to hook the Climber we made up to the rest of our code.
 * As usual, follow the TODOs. There are xx of them. Good luck! Don't forget
 * to push the code back up to github when you're done. A reminder on the
 * commands:
 * 
 *  	git add .
 *  	git commit -am "your message here"
 *  	git push origin master
 */

public class Robot extends TimedRobot {
	// Storage variables
	private double m_driveCommand;
	private double m_turnCommand;
	private double m_leftCmd;
	private double m_rightCmd;
	
	/**
	 * TODO 03: DECLARE NEW OBJECTS
	 * We need a Compressor object and a Climber object. Declare them
	 * here. Name them m_compressor and m_climber, respectively.
	 */
	// Declare robot subsystems
	private DriveSystem m_driveSys;
	private OperatorInterface m_opFace;
	private Object m_fireMainCyl;
	private Object m_fireExtCyl;
	private Object m_compressor;
	private Object m_climber;
	
	@Override
	public void robotInit() {
		/**
		 * TODO 04: CONSTRUCT NEW OBJECTS
		 * Construct m_compressor and m_climber here. Neither constructor
		 * takes arguments - i.e. there should be nothing in the parentheses
		 */
		// Construct robot subsystems
		this.m_driveSys = new DriveSystem();
		this.m_opFace = new OperatorInterface();
		this.m_climber = new Climber();
		this.m_compressor = new Compressor();
		
	}

	@Override
	public void disabledInit() {
		// Reset all subsystem states
		this.reset();
		
		/**
		 * TODO 08: DO NOTHING
		 * We don't want the compressor to do anything when disabled, so leave
		 * this alone.
		 */
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
		
		/**
		 * TODO 09: START THE COMPRESSOR
		 * We want the compressor running in auton. Start it here.
		 * 		this.m_compressor.start();
		 */
		this.m_compressor.start();
	}

	@Override
	public void autonomousPeriodic() {
		// Command the drive system to do nothing
		this.m_driveSys.setCommands(0.0,  0.0);
		
		// Update all actuator subsystems
		this.m_driveSys.update();
	}

	@Override
	public void teleopInit() {
		// Reset all subsystem states
		this.reset();
		
		/**
		 * TODO 10: START THE COMPRESSOR
		 * We want the compressor running in teleop. Start it here.
		 * 		this.m_compressor.start();
		 */
		this.m_compressor.start();
	}

	@Override
	public void teleopPeriodic() {
		// Update all sensor subsystems
		this.m_opFace.update();
		
		/**
		 * TODO 11: GET CLIMBER COMMANDS FROM OPERATOR INTERFACE
		 * Let's head over to OperatorInterface.java to set it up
		 * for commands. We'll come back here later.
		 */
		/**
		 * TODO 16: USE CLIMBER COMMAND METHODS
		 * Now that we've implemented what we need in OperatorInterface.java,
		 * let's use it. Declare two storage variables up above named
		 * 		m_fireMainCyl and m_fireExtCyl
		 * Don't forget to reset them in the reset() method.
		 * Then, let's get the values here using this.m_opFace.getFireMainCyl()
		 * and this.m_opface.getFireExtCyl()
		 */
		this.m_fireMainCyl();
		this.m_fireExtCyl();
		this.m_opFace.getFireMainCyl();
		this.m_opface.getFireExtCyl();
		
		// Get information from sensor subsystems
		this.m_driveCommand = this.m_opFace.getDriveCmd();
		this.m_turnCommand = this.m_opFace.getTurnCmd();
		
		// Calculations
		this.m_leftCmd = -this.m_driveCommand + this.m_turnCommand;
		this.m_rightCmd = -this.m_driveCommand - this.m_turnCommand;
		
		this.m_leftCmd = RobotHelper.limit(this.m_leftCmd, -1.0, 1.0);
		this.m_rightCmd = RobotHelper.limit(this.m_rightCmd, -1.0, 1.0);
		
		/**
		 * TODO 17: COMMAND THE CLIMBER
		 * Here, we'll use the this.m_climber.fireMainCyl() and
		 * this.m_climber.fireExtCyl() methods to tell the climber
		 * what we want it to do when we update it.
		 */
		 this.m_climber.fireMainCyl();
		 this.m_climber.fireExtCyl();
		
		// Set information for actuator subsystems
		this.m_driveSys.setCommands(this.m_leftCmd, this.m_rightCmd);
		
		/**
		 * TODO 18: UPDATE THE CLIMBER
		 * Here, we'll update the climber.
		 * That should be everything needed to get the climber up and running!
		 * Try it out! Don't forget to push everything to github!
		 */
		// Update all actuator subsystems
		this.m_driveSys.update();
		((Climber) this.m_climber).update();
	}
	
	private void m_fireExtCyl() {
		// TODO Auto-generated method stub
		
	}

	public void reset() {
		// Reset storage variables
		this.m_driveCommand = 0.0;
		this.m_turnCommand = 0.0;
		this.m_leftCmd = 0.0;
		this.m_rightCmd = 0.0;
		this.m_fireMainCyl= 0.0;
		this.m_fireExtCyl= 0.0;
		/**
		 * TODO 06: RESET THE CLIMBER
		 * We want to reset the climber every time we reset the subsystems.
		 */
		// Reset subsystems
		this.m_driveSys.reset();
		this.m_opFace.reset();
		this.m_fireMainCyl.reset();
		this.m_fireExtCyl.reset();
		/**
		 * TODO 07: STOP THE COMPRESSOR
		 * We want to default the compressor to be stopped. We'll manually start it
		 * when we actually need it. The command is going to be
		 * 		this.m_compressor.stop();
		 */
	}
	
	private Climber m_fireMainCyl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void testPeriodic() {}
}

