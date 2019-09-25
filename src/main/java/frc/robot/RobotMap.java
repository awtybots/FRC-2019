/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static int frontLeftDrive = 1;
  public static int middleLeftDrive = 3;
  public static int backLeftDrive = 4;
  public static int frontRightDrive = 12;
  public static int middleRightDrive = 13;
  public static int backRightDrive = 14;

  public static int elevatorTopLeft = 2; //ENC
  public static int elevatorBottomLeft = 5; //CHANGE
  public static int elevatorTopRight = 7; //CHANGE
  public static int elevatorBottomRight = 8; //CHANGE

  public static int cargoIntake = 11; //CHANGE
  public static int cargoLiftLeft = 10; //CHANGE
  public static int cargoLiftRight = 9; //ENC

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int armOpen = 0; //CHANGE
  public static int armClose = 1; //CHANGE
}
