package org.usfirst.frc2175.operatorinteraction;

import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.velocity.Velocity;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorInteraction {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Joystick translateStick;
    private Joystick rotateStick;

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

    public Velocity getTranslateVelocity() {
        Velocity translateVelocity =
                joystickInterpreter.getTranslationVelocity();
        return translateVelocity;
    }

    public double getAngularVelocity() {
        double angularVelocity = joystickInterpreter.getAngularVelocity();
        return angularVelocity;
    }
}
