package org.usfirst.frc2175.operatorinteraction;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickInterpreter {
    private Joystick translationJoystick;
    private Joystick rotationJoystick;

    public JoystickInterpreter(Joystick translationJoystick,
            Joystick rotationJoystick) {
        this.translationJoystick = translationJoystick;
        this.rotationJoystick = rotationJoystick;
    }

    public double getXTranslation() {
        return translationJoystick.getX();
    }

    public double getYTranslation() {
        return translationJoystick.getY();
    }

    public double getRotationJoystickAngle() {
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
