package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.PortMap;

public class DriveSubsystem extends Subsystem {

  public CANSparkMax rFront, rMiddle, rBack, lFront, lMiddle, lBack;

  public DriveSubsystem() {
    this.rFront = new CANSparkMax(PortMap.RIGHT_FRONT_SPARK, MotorType.kBrushless);
    this.rMiddle = new CANSparkMax(PortMap.RIGHT_MIDDLE_SPARK, MotorType.kBrushless);
    this.rBack = new CANSparkMax(PortMap.RIGHT_BACK_SPARK, MotorType.kBrushless);

    this.lFront = new CANSparkMax(PortMap.LEFT_FRONT_SPARK, MotorType.kBrushless);
    this.lMiddle = new CANSparkMax(PortMap.LEFT_MIDDLE_SPARK, MotorType.kBrushless);
    this.lBack = new CANSparkMax(PortMap.LEFT_BACK_SPARK, MotorType.kBrushless);

    rMiddle.follow(rFront);
    rBack.follow(rFront);

    lMiddle.follow(lFront);
    lBack.follow(lFront);
  }

  @Override
  protected void initDefaultCommand() {
    // IGNORE THIS METHOD
  }

  public void moveRobot(double left, double right) {
    lFront.set(left);
    rFront.set(right);
  }

}
