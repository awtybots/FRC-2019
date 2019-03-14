/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.CentricDrive;
import frc.robot.commands.HolonomicDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static TalonSRX frontRightPro = new TalonSRX(RobotMap.frontRightPro);
  public static TalonSRX frontRightCim = new TalonSRX(RobotMap.frontRightCim);
  public static TalonSRX frontLeftPro = new TalonSRX(RobotMap.frontLeftPro);
  public static TalonSRX frontLeftCim = new TalonSRX(RobotMap.frontLeftCim);
  public static TalonSRX backRightPro = new TalonSRX(RobotMap.backRightPro);
  public static TalonSRX backRightCim = new TalonSRX(RobotMap.backRightCim);
  public static TalonSRX backLeftPro = new TalonSRX(RobotMap.backLeftPro);
  public static TalonSRX backLeftCim = new TalonSRX(RobotMap.backLeftCim);

  public static double FR1S, FL1S, BR1S, BL1S, FR2S, FL2S, BR2S, BL2S;

  public static AHRS ahrs = new AHRS(SPI.Port.kMXP);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new HolonomicDrive());
  }

  public static void Holonomic(double straight, double rotate, double strafe){

    SmartDashboard.putNumber("Straigt Value: ", straight);
    SmartDashboard.putNumber("Strafe Value: ", strafe);
    SmartDashboard.putNumber("Rotate Value: ", rotate);

    FR1S = straight + strafe + rotate;
    FR2S = (straight + strafe + rotate);
    FL1S = -straight + strafe + rotate;
    FL2S = (-straight + strafe + rotate);
    BR1S = straight - strafe + rotate;
    BR2S = (straight - strafe + rotate);
    BL1S = -straight - strafe + rotate;
    BL2S = (-straight - strafe + rotate);

    frontRightPro.configOpenloopRamp(.5, 0);
    frontRightCim.configOpenloopRamp(.5, 0);
    frontLeftPro.configOpenloopRamp(.5, 0);
    frontLeftCim.configOpenloopRamp(.5, 0);
    backRightPro.configOpenloopRamp(.5, 0);
    backRightCim.configOpenloopRamp(.5, 0);
    backLeftPro.configOpenloopRamp(.5, 0);
    backLeftCim.configOpenloopRamp(.5, 0);

    frontRightPro.set(ControlMode.PercentOutput, -FR1S);
    frontRightCim.set(ControlMode.PercentOutput, FR2S);
    frontLeftPro.set(ControlMode.PercentOutput, -FL1S);
    frontLeftCim.set(ControlMode.PercentOutput, FL2S);
    backRightPro.set(ControlMode.PercentOutput, -BR1S);
    backRightCim.set(ControlMode.PercentOutput, BR2S);
    backLeftPro.set(ControlMode.PercentOutput, BL1S);
    backLeftCim.set(ControlMode.PercentOutput, BL2S);

    SmartDashboard.putNumber("Front Right Value: ", FR1S);
    SmartDashboard.putNumber("Front Left Value: ", FL1S);
    SmartDashboard.putNumber("Back Right Value: ", BR1S);
    SmartDashboard.putNumber("Back Left Value: ", BL1S);
  }

  public static void CentricDrive(double straight, double strafe, double rotate){

    SmartDashboard.putNumber("Straight Value: ", straight);
    SmartDashboard.putNumber("Strafe Value: ", strafe);
    SmartDashboard.putNumber("Rotate Value: ", rotate);

    FR1S = -straight + strafe + rotate;
    FR2S = (-straight + strafe + rotate);
    FL1S = straight - strafe + rotate;
    FL2S = (straight - strafe + rotate);
    BR1S = -straight - strafe + rotate;
    BR2S = (-straight - strafe + rotate);
    BL1S = straight + strafe + rotate;
    BL2S = (straight + strafe + rotate);

    frontRightPro.configOpenloopRamp(.5, 0);
    frontRightCim.configOpenloopRamp(.5, 0);
    frontLeftPro.configOpenloopRamp(.5, 0);
    frontLeftCim.configOpenloopRamp(.5, 0);
    backRightPro.configOpenloopRamp(.5, 0);
    backRightCim.configOpenloopRamp(.5, 0);
    backLeftPro.configOpenloopRamp(.5, 0);
    backLeftCim.configOpenloopRamp(.5, 0);

    frontRightPro.set(ControlMode.PercentOutput, -FR1S);
    frontRightCim.set(ControlMode.PercentOutput, FR2S);
    frontLeftPro.set(ControlMode.PercentOutput, FL1S);
    frontLeftCim.set(ControlMode.PercentOutput, -FL2S);
    backRightPro.set(ControlMode.PercentOutput, -BR1S);
    backRightCim.set(ControlMode.PercentOutput, BR2S);
    backLeftPro.set(ControlMode.PercentOutput, -BL1S);
    backLeftCim.set(ControlMode.PercentOutput, -BL2S);

    SmartDashboard.putNumber("Front Right Value: ", FR1S);
    SmartDashboard.putNumber("Front Left Value: ", FL1S);
    SmartDashboard.putNumber("Back Right Value: ", BR1S);
    SmartDashboard.putNumber("Back Left Value: ", BL1S);
  }
}
