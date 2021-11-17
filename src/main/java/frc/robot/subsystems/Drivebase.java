// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotContainer;

public class Drivebase extends SubsystemBase {
  /** Creates a new DriveBase. */
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(1);
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX(2);
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(3);
  public WPI_TalonSRX leftFollow = new WPI_TalonSRX(4);
  
  public Drivebase() {
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
    leftMaster.setInverted(true);
  }

  public void drive(double leftDrive, double rightDrive) {
    leftMaster.set(leftDrive);
    rightMaster.set(rightDrive);
  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double boost = RobotContainer.stick.getRawButton(2) ? 0.8 : 0.4;

    drive(RobotContainer.stick.getRawAxis(1) + boost, RobotContainer.stick.getRawAxis(3) + boost);
  }
}
