// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private TalonSRX frontLeft;
  private TalonSRX frontRight;
  private TalonSRX backLeft;
  private TalonSRX backRight;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    frontLeft = new TalonSRX(Constants.FRONT_LEFT);
    frontRight = new TalonSRX(Constants.FRONT_RIGHT);
    backLeft = new TalonSRX(Constants.BACK_LEFT);
    backRight = new TalonSRX(Constants.BACK_RIGHT);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.setNeutralMode(NeutralMode.Brake);
    frontRight.setNeutralMode(NeutralMode.Brake);
  }

  public void setPower(double Left, double Right) {
    frontLeft.set(ControlMode.PercentOutput, Left);
    frontRight.set(ControlMode.PercentOutput, Right);
    backLeft.set(ControlMode.PercentOutput, Left);
    backRight.set(ControlMode.PercentOutput, Right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
