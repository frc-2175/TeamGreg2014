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
 * This command releases the latch to shoot a ball. It will check if the arm is
 * out, the winch is down, and the winch is up before releasing, unless the
 * global override is active.
 */
public class  ReleaseLatch extends Command {

    public ReleaseLatch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.launcher);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setTimeout(0.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Releasing the latch...\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if ((Robot.arm.IsArmOut() && Robot.launcher.IsShooterArmDown() && Robot.launcher.IsWinchUp() && true /* isBall */) || Robot.oi.shouldOverrideLatch()) {
		Robot.launcher.SetLatch(true);
                Robot.shootLights.set(true);
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.launcher.SetLatch(false);
        Robot.shootLights.set(false);
	System.out.println("Done releasing the latch.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
