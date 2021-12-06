package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

import frc.robot.Robot;

public class DriveCommand extends InstantCommand{
    public void execute(){
        Robot.driveSubsystem.moveRobot(Robot.oi.leftJoystick, Robot.oi.rightJoystick);
    }
    
}
