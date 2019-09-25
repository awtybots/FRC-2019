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
import com.sun.jdi.connect.Connector.BooleanArgument;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.MoveCargo;
import frc.robot.commands.DumbCargo;

/**
 * Add your docs here.
 */
public class IntakeLifter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX leftLift = new TalonSRX(RobotMap.cargoLiftLeft);
  public TalonSRX rightLift = new TalonSRX(RobotMap.cargoLiftRight);

  public static int currentPos;
  public static double lowerSpeed = -.3;
  public static double liftSpeed = .3;
  public static double stallSpeed = .1;
  public static int targetDownPos = 21;
  // 00; //CHANGE
  public static int targetUpPos = 0; //CHANGE

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    rightLift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); //CHANGE
    rightLift.setSelectedSensorPosition(0 ,0, 10);
    rightLift.setSensorPhase(false);
    setDefaultCommand(new DumbCargo(0));
  }

  public void moveIntake(int upDown){
    currentPos = Math.abs(rightLift.getSelectedSensorPosition(0));
    System.out.println(currentPos);
    if(upDown == 1){
      leftLift.set(ControlMode.PercentOutput, liftSpeed);
      rightLift.set(ControlMode.PercentOutput, liftSpeed);
      System.out.println(currentPos);
    }
    else if(upDown == -1){
      leftLift.set(ControlMode.PercentOutput, liftSpeed);
      rightLift.set(ControlMode.PercentOutput, liftSpeed);
      System.out.println(currentPos);
    }
    else{
      leftLift.set(ControlMode.PercentOutput, 0);
      rightLift.set(ControlMode.PercentOutput, 0);
      System.out.println(currentPos);
    }
  }

  public void smartMoveIntake(int power){
    currentPos = Math.abs(rightLift.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("Intake Lifter Encoder", currentPos);
    System.out.println(currentPos);
    if(power == 1){
      if(currentPos < targetDownPos){
        leftLift.set(ControlMode.PercentOutput, lowerSpeed);
        rightLift.set(ControlMode.PercentOutput, lowerSpeed);
      }
      else{
        leftLift.set(ControlMode.PercentOutput, stallSpeed);
        rightLift.set(ControlMode.PercentOutput, stallSpeed);
      }
    }else if((power == 0)){
      if(currentPos > targetUpPos + 400){

        leftLift.set(ControlMode.PercentOutput, liftSpeed);
        rightLift.set(ControlMode.PercentOutput, liftSpeed);
      }
      else{
        leftLift.set(ControlMode.PercentOutput, stallSpeed);
        rightLift.set(ControlMode.PercentOutput, stallSpeed);
      }
    }else{
      leftLift.set(ControlMode.PercentOutput, stallSpeed);
      rightLift.set(ControlMode.PercentOutput, stallSpeed);
    }
  }

  public void dumbCargo(int option)
  {
    currentPos = Math.abs(rightLift.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("Intake Lifter Encoder", currentPos);
    System.out.println(currentPos);
    if(option == 1){ // raise?
      leftLift.set(ControlMode.PercentOutput, liftSpeed);
      rightLift.set(ControlMode.PercentOutput, liftSpeed);
      System.out.println(currentPos);
    }else if(option == -1){
      leftLift.set(ControlMode.PercentOutput, lowerSpeed);
      rightLift.set(ControlMode.PercentOutput, lowerSpeed);
      System.out.println(currentPos);
    }else{
      leftLift.set(ControlMode.PercentOutput, 0.1);
      rightLift.set(ControlMode.PercentOutput, 0.1);
      System.out.println(currentPos);
    }
  }

  public void resetEncoder() {
    rightLift.setSelectedSensorPosition(0 ,0, 10);	
  }
}