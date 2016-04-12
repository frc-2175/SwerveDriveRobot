package org.usfirst.frc2175.operatorinteraction;

import org.usfirst.frc2175.velocity.Velocity;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickInterpreter {
    private Joystick translationJoystick;
    private Joystick rotationJoystick;

    public JoystickInterpreter(Joystick translationJoystick,
            Joystick rotationJoystick) {
        this.translationJoystick = translationJoystick;
        this.rotationJoystick = rotationJoystick;
    }

    public Velocity getCommandedTranslationVelocity() {
        Velocity translationVelocity = new Velocity(
                getTranslationJoystickMagnitude(), getRotationJoystickAngle());
        return translationVelocity;
    }

    private double getCommandedXTranslation() {
        return translationJoystick.getX();
    }

    private double getCommandedYTranslation() {
        return translationJoystick.getY();
    }

    private double getTranslationJoystickAngle() {
        // TODO abstract this, used several times
        double angle = 0;
        double x = translationJoystick.getX();
        double y = translationJoystick.getY();
        double atan = Math.abs(Math.atan(y / x));
        // Handle quadrants
        if (y >= 0 && x >= 0) {
            angle = atan;
        } else if (y >= 0 && x < 0) {
            angle = atan + Math.PI / 2;
        } else if (y < 0 && x < 0) {
            angle = atan + Math.PI;
        } else if (y < 0 && x >= 0) {
            angle = atan + (3 * Math.PI / 2);
        }
        return angle;
    }

    private double getTranslationJoystickMagnitude() {
        double x = translationJoystick.getX();
        double y = translationJoystick.getY();
        return Math.sqrt((x * x) + (y * y));
    }

    public double getCommandedAngularVelocity() {
        // TODO fill in
        return 0;
    }

    private double getRotationJoystickAngle() {
        double angle = 0;
        double x = rotationJoystick.getX();
        double y = rotationJoystick.getY();
        double atan = Math.abs(Math.atan(y / x));
        // Handle quadrants
        if (y >= 0 && x >= 0) {
            angle = atan;
        } else if (y >= 0 && x < 0) {
            angle = atan + Math.PI / 2;
        } else if (y < 0 && x < 0) {
            angle = atan + Math.PI;
        } else if (y < 0 && x >= 0) {
            angle = atan + (3 * Math.PI / 2);
        }
        return angle;
    }

}
