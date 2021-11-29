package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;;

public class DriveSubsystem extends Subsystem {

    public boolean assisted = false;
    public boolean reversed = false;
    public double driveMultiplier = 1;

    public void assistedDriveMode() {this.assisted = true;}
    public void manualDriveMode() {this.assisted = false;}

    @Override
    protected void initDefaultCommand() {
		//IGNORE THIS METHOD
    }
}
