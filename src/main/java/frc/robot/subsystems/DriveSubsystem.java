package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.PortMap;

public class DriveSubsystem extends Subsystem {

    public CANSparkMax rFront, rMiddle, rBack, lFront, lMiddle, lBack;

    public DigitalInput topLimitSwitch;

    public DriveSubsystem(){
      this.rFront = new CANSparkMax(PortMap.RIGHT_FRONT_SPARK, MotorType.kBrushless);
      this.rMiddle = new CANSparkMax(PortMap.RIGHT_MIDDLE_SPARK, MotorType.kBrushless);
      this.rBack = new CANSparkMax(PortMap.RIGHT_BACK_SPARK, MotorType.kBrushless);

      this.lFront = new CANSparkMax(PortMap.LEFT_FRONT_SPARK, MotorType.kBrushless);
      this.lMiddle = new CANSparkMax(PortMap.LEFT_MIDDLE_SPARK, MotorType.kBrushless);
      this.lBack = new CANSparkMax(PortMap.LEFT_BACK_SPARK, MotorType.kBrushless);

      this.topLimitSwitch = new DigitalInput(PortMap.TOP_LIMIT_SWITCH);

      rMiddle.follow(rFront);
      rBack.follow(rFront);

      lMiddle.follow(lFront);
      lBack.follow(lFront);
    }
    @Override
    protected void initDefaultCommand() {
		//IGNORE THIS METHOD
    }

    public void setSpeed(double speed) {
      if (speed != 0) {
        if (topLimitSwitch.get()) {
          lFront.set(0);
          rFront.set(0);
        }
        else {
          lFront.set(speed);
          rFront.set(speed);
        }
      }
    }

    public void moveRobot(Joystick leftJoystick, Joystick rightJoystick) {
      setSpeed(leftJoystick.getY());
      setSpeed(rightJoystick.getY());
    }
  
  }
