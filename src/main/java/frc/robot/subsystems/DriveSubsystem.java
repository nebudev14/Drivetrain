package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.AnalogGyro;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends Subsystem {

    public CANSparkMax rFront, rMiddle, rBack, lFront, lMiddle, lBack;
    public AnalogGyro gyro;
    Joystick leftJoystick = new Joystick(10);
    Joystick rightJoystick = new Joystick(11);

    public DriveSubsystem(){
      // init motors
      this.rFront = new CANSparkMax(0, MotorType.kBrushless);
      this.rMiddle = new CANSparkMax(1, MotorType.kBrushless);
      this.rBack = new CANSparkMax(2, MotorType.kBrushless);

      this.lFront = new CANSparkMax(3, MotorType.kBrushless);
      this.lMiddle = new CANSparkMax(4, MotorType.kBrushless);
      this.lBack = new CANSparkMax(5, MotorType.kBrushless);

      // init gyro
      this.gyro = new AnalogGyro(12);


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
    
    // auto
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

    public void moveRobot() { // the user uses a controller to turn
      setLeftSpeed(leftJoystick.getY());
      setRightSpeed(rightJoystick.getY());
    }

    // auto
    public void turnDegrees(double degrees) {
      if(gyro.getAngle() > 180) {
        degrees = -(360 - gyro.getAngle()); 
      }
      while(gyro.getAngle() != degrees) {
        if(gyro.getAngle() > 0) {
          turn(false);
        } else {
          turn(true);;
        }
      } 
    }
}
