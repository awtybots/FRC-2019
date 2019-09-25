/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeGamepiece extends Command {
  public double intakeSpeed, outtakeSpeed;

  public IntakeGamepiece() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.cargo);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {}

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    intakeSpeed = Robot.oi.xbox2.getRawAxis(2);
    intakeSpeed = Robot.oi.xbox.getRawAxis(2);
    outtakeSpeed = Robot.oi.xbox2.getRawAxis(3);
    outtakeSpeed = Robot.oi.xbox.getRawAxis(3);
    
    if (Math.abs(intakeSpeed) < .5) {
        intakeSpeed = 0;
    }if (Math.abs(outtakeSpeed) < .5) {
        outtakeSpeed = 0;
    }

    if(outtakeSpeed > 0 && intakeSpeed > 0){
      Robot.cargo.intakeCargo(0); // hold it in/nothing
    }else if(outtakeSpeed > 0 && intakeSpeed == 0){
      Robot.cargo.intakeCargo(1); //outtake
    }else if(outtakeSpeed == 0 && intakeSpeed > 0){
      Robot.cargo.intakeCargo(-1); //intake
    }else if(outtakeSpeed == 0 && intakeSpeed == 0){
      Robot.cargo.intakeCargo(0); //hold it in
    }
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
