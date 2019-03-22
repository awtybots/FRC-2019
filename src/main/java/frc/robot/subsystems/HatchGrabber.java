/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.HatchGrab;

/**
 * Add your docs here.
 */
public class HatchGrabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static DoubleSolenoid gripper = new DoubleSolenoid(RobotMap.gripperOpen, RobotMap.gripperClose);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    gripper.set(DoubleSolenoid.Value.kReverse);
    setDefaultCommand(new HatchGrab(1));
  }

  public static void hatchGrab(int grab)
  {
    if(grab == 1){
      gripper.set(DoubleSolenoid.Value.kForward);
    }
    if(grab == 0){
      gripper.set(DoubleSolenoid.Value.kReverse);
    }
  }
}