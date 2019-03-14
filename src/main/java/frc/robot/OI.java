/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.CargoRoller;
import frc.robot.commands.DumbElevator;
import frc.robot.commands.HatchGrab;
import frc.robot.commands.HatchPunch;
import frc.robot.commands.MoveCargo;
//import frc.robot.commands.SmartElevator;
import frc.robot.commands.SmartElevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

	public Joystick xbox = new Joystick(0);
  public Joystick xbox2 = new Joystick(1);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //Controller 1
	Button btnA = new JoystickButton(xbox, 1); // A button
	Button btnB = new JoystickButton(xbox, 2); // B button
	Button btnX = new JoystickButton(xbox, 3); // X button
	Button btnY = new JoystickButton(xbox, 4); // Y button
	Button btnL1 = new JoystickButton(xbox, 5); // Left Bumper?
	Button btnR1 = new JoystickButton(xbox, 6); // Right Bumper?
	Button btnM = new JoystickButton(xbox, 7); // what is this
	Button btnS = new JoystickButton(xbox, 8); // what is this
  Button btnW = new JoystickButton(xbox, 9); // what is this
  
  //Controller 2
  Button btnA2 = new JoystickButton(xbox2, 1); // A button
	Button btnB2 = new JoystickButton(xbox2, 2); // B button
	Button btnX2 = new JoystickButton(xbox2, 3); // X button
	Button btnY2 = new JoystickButton(xbox2, 4); // Y button
	Button btnL2 = new JoystickButton(xbox2, 5); // Left Bumper?
	Button btnR2 = new JoystickButton(xbox2, 6); // Right Bumper?
	Button btnM2 = new JoystickButton(xbox2, 7); // what is this
	Button btnS2 = new JoystickButton(xbox2, 8); // what is this
  Button btnW2 = new JoystickButton(xbox2, 9); // what is this
  
  public double getRawAnalogStickALX() {
		return xbox.getRawAxis(0);
	}
	
	public double getRawAnalogStickALY() {
		return xbox.getRawAxis(1);
	}
	
	public double getRawAnalogStickARX() {
		return xbox.getRawAxis(4);
	}
	
	public double getRawAnalogStickARY() {
		return xbox.getRawAxis(5);
	}

	public double getRawLZ(){
		return xbox.getRawAxis(2);
	}
	public double getRawRZ(){
		return xbox.getRawAxis(3);
	}

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public OI(){
    btnL2.whenPressed(new DumbElevator(1));
	btnL2.whenReleased(new DumbElevator(0));

	btnR2.whenPressed(new DumbElevator(-1));
	btnR2.whenReleased(new DumbElevator(0));

	btnR1.whenPressed(new MoveCargo(1));
	btnR1.whenPressed(new CargoRoller(1));
	btnR1.whenReleased(new MoveCargo(0));
	btnR1.whenReleased(new CargoRoller(0));

	btnL1.whenPressed(new CargoRoller(-1));
	btnL1.whenReleased(new CargoRoller(0));

	/*btnB2.whenPressed(new CargoRoller(1));
	btnB2.whenReleased(new CargoRoller(0));

	btnA2.whenPressed(new CargoRoller(-1));
	btnA2.whenReleased(new CargoRoller(0));*/


    //btnA2.whenPressed(new SmartElevator(16000)); // middle hatch slot
		//btnB2.whenPressed(new SmartElevator(16000)); // top hatch slot
		//btnX2.whenPressed(new SmartElevator(16000)); // middle cargo slot
		//btnY2.whenPressed(new SmartElevator(16000)); // top cargo slot

	/*btnR2.whileHeld(new MoveCargo(3050, 1));
	btnR2.whenReleased(new MoveCargo(0, 0));
	btnR2.whenPressed(new CargoRoller(-1));
	btnR2.whenReleased(new CargoRoller(0));*/

	/*btnR2.whenPressed(new MoveCargo(1));
	btnR2.whenReleased(new MoveCargo(0));
	btnL2.whenPressed(new MoveCargo(-1));
	btnL2.whenReleased(new MoveCargo(0));*/

	btnY.toggleWhenPressed(new HatchGrab(0));
	btnX.whileHeld(new HatchPunch(0));
	btnX.toggleWhenPressed(new HatchGrab(0));

	btnX2.whenPressed(new SmartElevator(48750));
	btnY2.whenPressed(new SmartElevator(92500));
	btnB.whenPressed(new SmartElevator(5000));															
  }
}