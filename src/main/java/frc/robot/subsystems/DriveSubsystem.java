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
    }
    @Override
    protected void initDefaultCommand() {
		//IGNORE THIS METHOD
    }

    public void setAllSpeed(double n){
      setRightSpeed(n);
      setLeftSpeed(n);
    }

    public void setRightSpeed(double n){
      rFront.set(n);
      rMiddle.set(n);
      rBack.set(n);
    }
    public void setLeftSpeed(double n){
      lFront.set(n);
      lMiddle.set(n);
      lBack.set(n);
    }

    
    public void moveRobot(Joystick leftJoystick, Joystick rightJoystick) {
      setLeftSpeed(leftJoystick.getY());
      setRightSpeed(rightJoystick.getY());
    }
    
    public void turn(boolean left)  { // if true, turn left, if false, turn right
      if(left) {
        setLeftSpeed(-0.5);
        setRightSpeed(1);
      }
      else {
        setLeftSpeed(1);
        setRightSpeed(-0.5);
      }
    }
  }

