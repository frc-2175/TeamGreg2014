// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2175.Robot2014.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2175.Robot2014.Robot;

/**
 * This command drives the robot with provided inputs.
 * This is intended for use in autonomous robot functions.
 */
public class  ArcadeDriveWithInputs extends Command {
    
    double forwardSpeed;
    double turningSpeed;
    double timeoutTime;
    boolean shouldAutoSteer;
    boolean shouldResetGyro;
    
    /**
     * Drives the robot infinitely with specified inputs.
     * MAKE SURE TO SET AN EXTERNAL TIMEOUT.
     * @param forward The forward driving speed (left joystick)
     * @param turning The turning speed (right joystick)
     */
    public ArcadeDriveWithInputs(double forward, double turning) {
        this (forward, turning, 0);
    }
    
    /**
     * Drives the robot for time with provided inputs.
     * @param forward The forward driving speed (left joystick)
     * @param turning The turning speed (right joystick)
     * @param time The duration of time for driving. If 0 then the robot will drive infinitely.
     */
    public ArcadeDriveWithInputs(double forward, double turning, double time) {
        this(forward, turning, time, false, false);
    }
    
    /**
     * Drives the robot for time with provided inputs, optionally driving straight using a gyro.
     * @param forward The forward driving speed (left joystick)
     * @param turning The turning speed (right joystick)
     * @param time The duration of time for driving. If 0 then the robot will drive infinitely.
     * @param autoSteer Whether to attempt to drive straight (using a gyro). If a turning value is provided then this will be treated as false.
     * @param resetGyro Whether to reset the gyro before running this command.
     */
    public ArcadeDriveWithInputs(double forward, double turning, double time, boolean autoSteer, boolean resetGyro) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        forwardSpeed = forward;
	turningSpeed = turning;
	timeoutTime = time;
        shouldAutoSteer = autoSteer && (turningSpeed == 0); // If we are trying to turn, we disable autosteer to avoid confusion
        shouldResetGyro = resetGyro;
	if (timeoutTime > 0) {
            setTimeout(timeoutTime);
	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (shouldAutoSteer && shouldResetGyro) Robot.drivetrain.ResetGyro();
        System.out.println("Driving with inputs...\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.ArcadeDriveWithParameters(forwardSpeed,turningSpeed,shouldAutoSteer);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timeoutTime > 0) {
		return isTimedOut();
	} else {
		return false;
	}
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.ArcadeDriveWithParameters(0,0);
	System.out.println("Done driving with inputs.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}