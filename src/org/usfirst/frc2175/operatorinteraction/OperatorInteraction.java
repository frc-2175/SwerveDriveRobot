package org.usfirst.frc2175.operatorinteraction;

import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.util.Loopable;
import org.usfirst.frc2175.velocity.Velocity;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Updates a set of variables corresponding to the current state of the driver
 * controls (e.g. buttons currently pushed, current stick positions, etc). The
 * values are then usable by other classes or controllers through a number of
 * getters.
 *
 * @author Max Haland
 */
public class OperatorInteraction implements Loopable {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Joystick translateStick;
    private Joystick rotateStick;

    // Inputs we want to monitor. These get updated as the class is run in a
    // Looper and have getters to obtain their value for use somewhere else.
    private Velocity commandedTranslateVelocity;
    private double commandedAngularVelocity;

    private JoystickInterpreter joystickInterpreter;

    public OperatorInteraction(RobotConfig robotConfig) {
        // Initialize the sticks from joysticksConfig
        this.translateStick =
                robotConfig.getJoysticksConfig().getTranslateJoystick();
        this.rotateStick = robotConfig.getJoysticksConfig().getRotateJoystick();

        // Make a new joystick interpreter for the two sticks
        this.joystickInterpreter =
                new JoystickInterpreter(translateStick, rotateStick);
    }

    @Override
    public void update() {
        // Add in update calls as needed
        updateCommandedTranslateVelocity();
        updateCommandedAngularVelocity();
    }

    public void updateCommandedTranslateVelocity() {
        this.commandedTranslateVelocity =
                joystickInterpreter.getCommandedTranslationVelocity();
    }

    public void updateCommandedAngularVelocity() {
        this.commandedAngularVelocity =
                joystickInterpreter.getCommandedAngularVelocity();
    }

    public Velocity getCommandedTranslateVelocity() {
        return commandedTranslateVelocity;
    }

    public double getCommandedAngularVelocity() {
        return commandedAngularVelocity;
    }

}
