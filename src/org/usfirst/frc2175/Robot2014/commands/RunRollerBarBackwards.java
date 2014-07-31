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
 * This command runs the roller bar backwards.
 */
public class  RunRollerBarBackwards extends Command {

    public RunRollerBarBackwards() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        setTimeout(5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Running the roller bar backwards...\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.arm.RunRollerBarAtSpeed(-.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.arm.RunRollerBarAtSpeed(0);
	System.out.println("Done running the roller bar backwards.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}