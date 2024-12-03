// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrainSubsystem extends SubsystemBase {
  VictorSP motorLeft= new VictorSP(Constants.DriveTrainConstants.LeftVictorSP);
    VictorSP motorRight=new VictorSP(Constants.DriveTrainConstants.RightVictorSP);
private final Encoder encoderIzquierdo = new Encoder(0, 1,false,CounterBase.EncodingType.k4X);
private final Encoder encoderDerecho = new Encoder(2, 3,true, CounterBase.EncodingType.k4X);

DifferentialDrive differentialDrive = new DifferentialDrive(motorLeft, motorRight);


  

    /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {
    //encoderIzquierdo.setPosition(0);??? preguntar
    motorLeft.setInverted(true);
    encoderDerecho.setSamplesToAverage(5);
    encoderIzquierdo.setSamplesToAverage(5);

    encoderDerecho.setDistancePerPulse(1/360*Math.PI*6);
    encoderIzquierdo.setDistancePerPulse(1/360*Math.PI*6);

    encoderDerecho.setMinRate(1);
    encoderIzquierdo.setMinRate(1);
  }

  public void arcadeDrive(double fwd, double rot){
    differentialDrive.arcadeDrive(fwd, rot);
  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
