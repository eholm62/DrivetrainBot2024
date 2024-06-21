// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  public Driveside left;
  public Driveside right;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    left = new Driveside(Constants.FRONT_LEFT, Constants.BACK_LEFT);
    right = new Driveside(Constants.FRONT_RIGHT, Constants.BACK_RIGHT);
  }

  public class Driveside {
    public TalonSRX lead;
    public TalonSRX follower;

    public Driveside(int lead, int follower) {
      this.lead = new TalonSRX(lead);
      this.follower = new TalonSRX(follower);
      this.follower.follow(this.lead);
      this.lead.setNeutralMode(NeutralMode.Brake);
      this.follower.setNeutralMode(NeutralMode.Brake);
    }

    public void setPower(double front, double back) {
      this.lead.set(ControlMode.PercentOutput, front);
      this.follower.set(ControlMode.PercentOutput, back);
    }
  }

  public void setPower(double left, double right) {
    this.left.setPower(left, left);
    this.right.setPower(-right, -right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
