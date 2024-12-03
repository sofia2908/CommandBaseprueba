// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
/** An example command that uses an example subsystem. */
public class DriveWithTeleoperatedCommand extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSubsystem driveTrainSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithTeleoperatedCommand(DriveTrainSubsystem driveTrainSubsystem) {
   this.driveTrainSubsystem = driveTrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //DriveTrainSubsystem.differentialDrive(-PS4Controller.getLeftY(), -PS4Controller.getRightX());
  
  //SmartDashboard.putNumber("Encoder Distance CM derecho", Math.round(2.54 * encoderDerecho.getDistance()*100)/100d);
  //SmartDashboard.putNumber("Encoder Distance CM izquierdo", Math.round(2.54 * encoderIzquierdo.getDistance()*100)/100d);
    double forwardSpeed = RobotContainer.ps4Controller.getLeftY();
    double turningSpeed = RobotContainer.ps4Controller.getRightX();
    driveTrainSubsystem.arcadeDrive(forwardSpeed,turningSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
