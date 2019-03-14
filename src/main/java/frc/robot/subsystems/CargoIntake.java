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

/**
 * Add your docs here.
 */
public class CargoIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public TalonSRX lift = new TalonSRX(RobotMap.cargoLift);

  public static double lowerSpeed = -0.55;
  public static double liftSpeed = .5;
  public static double stallSpeed = .1;
  public static int targetDownPos = 2400;
  public static int targetUpPos = 0;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    lift.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    lift.setSelectedSensorPosition(0 ,0, 10);
    lift.setSensorPhase(false);
    setDefaultCommand(new MoveCargo(0));
  }

  public void moveIntake(int upDown){
    
    if(upDown == 1){
      lift.set(ControlMode.PercentOutput, liftSpeed);
      System.out.println("hello awty");
    }
    else if(upDown == -1){
      lift.set(ControlMode.PercentOutput, -liftSpeed);
      System.out.println("hello awty");
    }
    else{
      lift.set(ControlMode.PercentOutput, stallSpeed);
    }
  }

  public void smartMoveIntake(int power){
    int currentPos = Math.abs(lift.getSelectedSensorPosition(0));
    if(power == 1){
      if(currentPos < targetDownPos){
        lift.set(ControlMode.PercentOutput, lowerSpeed);
      }
      else{
        lift.set(ControlMode.PercentOutput, stallSpeed);
      }
    }else if((power == 0)){
      if(currentPos > targetUpPos + 250){

        lift.set(ControlMode.PercentOutput, liftSpeed);
      }
      else{
        lift.set(ControlMode.PercentOutput, 0);
      }
    }else{
      lift.set(ControlMode.PercentOutput, 0);
    }
  }

  public void resetEncoder() {
    lift.setSelectedSensorPosition(0 ,0, 10);	
  }
}