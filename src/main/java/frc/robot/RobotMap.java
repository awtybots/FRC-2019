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

  public static int frontLeftPro = 3;
  public static int frontLeftCim = 14;
  public static int frontRightPro = 5;
  public static int frontRightCim = 8;
  public static int backLeftPro = 1;
  public static int backLeftCim = 2;
  public static int backRightPro = 7;
  public static int backRightCim = 6;
  public static int elevatorTopLeft = 13;
  public static int elevatorBottomLeft = 14;
  public static int elevatorTopRight = 9;
  public static int elevatorBottomRight = 10;
  public static int cargoIntake = 4;
  public static int cargoLift = 11;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static int gripperOpen = 2;
  public static int gripperClose = 3;
  public static int puncherOpen = 0;
  public static int puncherClose = 1;
}
