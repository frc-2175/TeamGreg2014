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
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This routine drives forward, waits for the goal to be hot, and takes a short
 * shot.
 */
public class Auton5HotGoal extends CommandGroup {
    
    public  Auton5HotGoal() {
        
        addSequential(new ArcadeDriveWithInputs(-1,0,1.25,true,true));
        
        addSequential(new ArcadeDriveWithInputs(-0.5,0,0.5,true,false));
        
        addSequential(new MoveArmOut());
        
        addSequential(new Delay(1.25));
        
        addSequential(new WaitForHotGoal(),3);
        
        addSequential(new Shoot());

    }
}
