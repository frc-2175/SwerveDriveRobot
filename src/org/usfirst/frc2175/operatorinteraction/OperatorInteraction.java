package org.usfirst.frc2175.operatorinteraction;

import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.loopers.Loopable;
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
    // else. In addition, there is a spoofed version of each one.
    private Velocity commandedTranslateVelocity;
    private Velocity spoofedTranslateVelocity =
            new Velocity.ZeroVelocity().ZERO_VELOCITY;
    private double commandedAngularVelocity;
    private double spoofedAngularVelocity = 0;

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

    public void setSpoofingInputs(boolean isSpoofingInputs) {
        this.isSpoofingInputs = isSpoofingInputs;
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
     * spoofed reading).
     */
    public void updateCommandedTranslateVelocity() {
        if (isSpoofingInputs) {
            this.commandedTranslateVelocity = this.spoofedTranslateVelocity;
        } else {
            this.commandedTranslateVelocity =
                    joystickInterpreter.getCommandedTranslationVelocity();
        }
    }

    /**
     * Sets the spoof value for the translate Velocity.
     */
    public void setSpoofedTranslateVelocity(Velocity v) {
        this.spoofedTranslateVelocity = v;
    }

    /**
     * Updated commanded angular velocity based on a joystick reading (or
     * spoofed reading)
     */
    public void updateCommandedAngularVelocity() {
        if (isSpoofingInputs) {
            this.commandedAngularVelocity = this.spoofedAngularVelocity;
        } else {
            this.commandedAngularVelocity =
                    joystickInterpreter.getCommandedAngularVelocity();
        }
    }

    public void setSpoofedAngularVelocity(double v) {
        this.spoofedAngularVelocity = v;
    }

    /* ----------- Getters for commanded values ----------------- */

    public Velocity getCommandedTranslateVelocity() {
        return commandedTranslateVelocity;
    }

    public double getCommandedAngularVelocity() {
        return commandedAngularVelocity;
    }

}
