package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;;

public class DriveSubsystem extends Subsystem {

    public boolean assisted = false;
    public boolean reversed = false;
    public double driveMultiplier = 1;

    public CANSparkMax r, r1, r2, l, l1, l2;
    public static final int GEAR_RATIO = 100;

    public void assistedDriveMode() {this.assisted = true;}
    public void manualDriveMode() {this.assisted = false;}


    public DriveSubsystem(){
      this.r = new CANSparkMax(0, MotorType.kBrushless);
      this.r1 = new CANSparkMax(1, MotorType.kBrushless);
      this.r2 = new CANSparkMax(2, MotorType.kBrushless);

      this.l = new CANSparkMax(3, MotorType.kBrushless);
      this.l1 = new CANSparkMax(4, MotorType.kBrushless);
      this.l2 = new CANSparkMax(5, MotorType.kBrushless);
    }
    @Override
    protected void initDefaultCommand() {
		//IGNORE THIS METHOD
    }
    // AAAAAAAAAAAAAAAAAAaaaa
    
}
