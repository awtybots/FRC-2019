/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.DumbElevator;

/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX topLeft = new TalonSRX(RobotMap.elevatorTopLeft);
  public static TalonSRX bottomLeft = new TalonSRX(RobotMap.elevatorBottomLeft);
  public static TalonSRX topRight = new TalonSRX(RobotMap.elevatorTopRight);
  public static TalonSRX bottomRight = new TalonSRX(RobotMap.elevatorBottomRight);

  public static double currentPos, position;
  public static double elevDownSpeed = 0.50;
  public static double elevUpSpeed = -0.5;
  public static double elevStall = 0.05;

  public static double P = 1.0;
  public static double I = 0.0;
  public static double D = 0.0;

  @Override
  public void initDefaultCommand() {
    bottomLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    topLeft.follow(bottomLeft);
    topRight.follow(bottomLeft);
    topRight.setInverted(false);
    bottomRight.follow(bottomLeft);
    bottomRight.setInverted(false);

    bottomLeft.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

		/* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
		bottomLeft.config_kF(Constants.kPIDLoopIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		bottomLeft.config_kP(Constants.kPIDLoopIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		bottomLeft.config_kI(Constants.kPIDLoopIdx, Constants.kGains.kI, Constants.kTimeoutMs);
    bottomLeft.config_kD(Constants.kPIDLoopIdx, Constants.kGains.kD, Constants.kTimeoutMs);
    
    bottomLeft.setSensorPhase(false);
    bottomLeft.setSelectedSensorPosition(0 ,0, 10);	
    setDefaultCommand(new DumbElevator(0));
  }

  public void PIDElevator(int encTicks){
    bottomLeft.set(ControlMode.Position, encTicks);
  }

  public void basicElevator(int power){
    if(power == -1){
      bottomLeft.set(ControlMode.PercentOutput, -elevUpSpeed);
    }else if(power == 1){
      bottomLeft.set(ControlMode.PercentOutput, elevUpSpeed);
    }else{
      bottomLeft.set(ControlMode.PercentOutput, elevStall);
    }
  }

  public void smartyElevator(int targetEncTicks){
    int currentPos = Math.abs(bottomLeft.getSelectedSensorPosition(0));
    if(currentPos < targetEncTicks + 2000){ // above
      bottomLeft.set(ControlMode.PercentOutput, elevDownSpeed);
    }else if(currentPos > targetEncTicks - 2000){ // below
      bottomLeft.set(ControlMode.PercentOutput, elevUpSpeed);
    }else{
      bottomLeft.set(ControlMode.PercentOutput, elevStall);
    }
  }

  public void resetEncoder() {
    bottomLeft.setSelectedSensorPosition(0 ,0, 10);	
  }
}