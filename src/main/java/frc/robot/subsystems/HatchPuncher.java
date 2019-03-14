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
import frc.robot.commands.HatchPunch;

/**
 * Add your docs here.
 */
public class HatchPuncher extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static DoubleSolenoid puncher = new DoubleSolenoid(RobotMap.puncherOpen, RobotMap.puncherClose);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    puncher.set(DoubleSolenoid.Value.kReverse);
    setDefaultCommand(new HatchPunch(1));
  }

  public static void hatchPunch(int punch)
  {
    if(punch == 1){
      puncher.set(DoubleSolenoid.Value.kForward);
    }
    if(punch == 0){
      puncher.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
