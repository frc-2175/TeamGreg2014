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
 * This class uses the robot's encoders to drive for a precise distance. We
 * would use it more if we really trusted the encoders.
 */
public class  DriveForDistance extends Command {
    
    float inputFeet;
    boolean inputBackwards;
    
    /**
     * Constructs this command to drive forward for a given distance.
     * @param feet The distance to drive in feet.
     */
    public DriveForDistance(float feet) {
        this(feet, false);
    }
    
    /**
     * Constructs this command with the option to drive backwards.
     * @param feet The distance to drive in feet.
     * @param backwards Whether to drive backwards or not.
     */
    public DriveForDistance(float feet, boolean backwards) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Driving for distance...\n");
	
	float setpoint = inputFeet;
	if (inputBackwards) setpoint *= -1;
	Robot.drivetrain.ResetEncoders();
	Robot.drivetrain.encoderPID.reset();
	Robot.drivetrain.encoderPID.setSetpoint(setpoint);
	Robot.drivetrain.encoderPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double PIDval = Robot.drivetrain.encoderPID.get();
	Robot.drivetrain.ArcadeDriveWithParameters(PIDval,0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drivetrain.encoderPID.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.encoderPID.disable();
	System.out.println("Done driving for distance.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
