/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.SPI;

public class CentricDrive extends Command {

  public double straight, strafe, rotate;
  public AHRS gyro = new AHRS(SPI.Port.kMXP);
  
  public CentricDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivebase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    gyro.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    straight = Robot.oi.xbox.getRawAxis(1);//I flipped numbers 1 and 4
    rotate = Robot.oi.xbox.getRawAxis(4); //don't get mad at me if this messes everything up
    strafe = Robot.oi.xbox.getRawAxis(0);

    if(Robot.oi.xbox.getRawButton(7)){
      gyro.reset();
    }

    double pi = Math.PI;

    double degrees = gyro.getYaw();
    double radians = degrees * pi/180;
    double temp = straight * Math.cos(radians) - strafe * Math.sin(radians);
    strafe = straight * Math.sin(radians) + strafe * Math.cos(radians);
    straight = temp;

    SmartDashboard.putNumber("Gyro Value: ", degrees);

    if(Math.abs(straight) < .2)
    {
      straight = 0;
    }
    if(Math.abs(strafe) < .2)
    {
      strafe = 0;
    }
    if(Math.abs(rotate) < .2)
    {
      rotate = 0;
    }

   //DriveTrain.CentricDrive(straight, strafe, rotate);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
