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

    private boolean isSpoofingInputs = false;

    // Put physical inputs here
    private Joystick translateStick;
    private Joystick rotateStick;

    // Takes values from the joysticks and makes them make sense
    private JoystickInterpreter joystickInterpreter;

    // Commanded values we want to monitor. These get updated as the class is
    // run in a Looper and have getters to obtain their value for use somewhere
    // else.
    private Velocity commandedTranslateVelocity;
    private double commandedAngularVelocity;

    public OperatorInteraction(RobotConfig robotConfig) {
        this.isSpoofingInputs = false;

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

    /* ----------- Update methods for each needed value ----------------- */

    /**
     * Updates commanded translate Velocity based on a joystick reading (or
     * spoofed reading)
     */
    public void updateCommandedTranslateVelocity() {
        if (!isSpoofingInputs) {
            this.commandedTranslateVelocity =
                    joystickInterpreter.getCommandedTranslationVelocity();
        }
    }

    /**
     * Updated commanded angular velocity based on a joystick reading (or
     * spoofed reading)
     */
    public void updateCommandedAngularVelocity() {
        if (!isSpoofingInputs) {
            this.commandedAngularVelocity =
                    joystickInterpreter.getCommandedAngularVelocity();
        }
    }

    /* ----------- Getters for commanded values ----------------- */

    public Velocity getCommandedTranslateVelocity() {
        return commandedTranslateVelocity;
    }

    public double getCommandedAngularVelocity() {
        return commandedAngularVelocity;
    }

}
