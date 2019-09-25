/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeGamepiece;


/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem

  // here. Call these from Commands
  
  public static TalonSRX intake = new TalonSRX(RobotMap.cargoIntake);

  public static final double intakeSpeed = -.75;
  public static final double outtakeSpeed = .50;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new IntakeGamepiece());
  }

  public void intakeCargo(int option){
    if(option == 1){
      intake.set(ControlMode.PercentOutput, outtakeSpeed);
    }
    else if(option == -1){
      intake.set(ControlMode.PercentOutput, intakeSpeed);
    }
    else{
      intake.set(ControlMode.PercentOutput, 0.4);
    }
  }
}
