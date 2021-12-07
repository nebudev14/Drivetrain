package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends Subsystem {

    public CANSparkMax rFront, rMiddle, rBack, lFront, lMiddle, lBack;

    public DriveSubsystem(){
      this.rFront = new CANSparkMax(0, MotorType.kBrushless);
      this.rMiddle = new CANSparkMax(1, MotorType.kBrushless);
      this.rBack = new CANSparkMax(2, MotorType.kBrushless);

      this.lFront = new CANSparkMax(3, MotorType.kBrushless);
      this.lMiddle = new CANSparkMax(4, MotorType.kBrushless);
      this.lBack = new CANSparkMax(5, MotorType.kBrushless);

      rMiddle.follow(rFront);
      rBack.follow(rFront);

      lMiddle.follow(lFront);
      lBack.follow(lFront);
    }
    @Override
    protected void initDefaultCommand() {
		//IGNORE THIS METHOD
    }

    public void moveRobot(Joystick leftJoystick, Joystick rightJoystick) {
      lFront.set(leftJoystick.getY());
      rFront.set(rightJoystick.getY());
    }
  
  }
