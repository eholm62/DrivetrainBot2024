// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Xbox;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TankDrive extends Command {
  private final Drivetrain m_drivetrain;
  private Xbox m_controller;
  private double power_multiplier;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TankDrive(Drivetrain drivetrain, Xbox controller) {
    m_drivetrain = drivetrain;
    m_controller = controller;
    power_multiplier = 1;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.setPower(m_controller.getLeftStickY()*power_multiplier,m_controller.getRightStickY()*power_multiplier);
    if (m_controller.getXButtonPressed() && power_multiplier > 0){
      power_multiplier -= 0.05;
      System.out.println("Power multiplier: " + power_multiplier);
    }
    if (m_controller.getYButtonPressed() && power_multiplier <= 1){
      power_multiplier += 0.05;
      System.out.println("Power multiplier; " + power_multiplier);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setPower(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_controller.getBButtonPressed();
  }
}
