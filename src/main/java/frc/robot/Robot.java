// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.DriveSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;;

public class Robot extends TimedRobot {
  public static DriveSubsystem driveSubsystem = new DriveSubsystem();

  public static OI oi = new OI();

  private CANSparkMax motorOne;
  private CANSparkMax motorTwo;
  private CANSparkMax motorThree;

  @Override
  public void robotInit() {
    motorOne    = new CANSparkMax(0, MotorType.kBrushless);
    motorTwo    = new CANSparkMax(1, MotorType.kBrushless);
    motorThree  = new CANSparkMax(2, MotorType.kBrushless);
  }

  @Override
  public void robotPeriodic() {
    System.out.println("This is robot periodic");
  }

  @Override
  public void autonomousInit() {
    System.out.println("This is autonomous init");
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    motorOne.set(1);
    motorTwo.set(1);
    motorThree.set(1);
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    System.out.println("This is teleop init");
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    System.out.println("This is teleop periodic");
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    System.out.println("This is disabled init");
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
    System.out.println("This is disabled periodic");
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    System.out.println("This is test init");
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    System.out.println("This is test periodic");
  }
}
