package org.usfirst.frc2175.config;

import java.util.Properties;

import edu.wpi.first.wpilibj.Joystick;

public class JoysticksConfig extends BaseConfig {

    private Joystick translateJoystick;
    private Joystick rotateJoystick;

    @Override
    protected String getPropertyFileName() {
        return "joysticks.properties";
    }

    @Override
    protected void configure(Properties properties) {
        int translateJoystickPort =
                getIntPropertyValue("joystick.translate.port", properties);
        this.translateJoystick = new Joystick(translateJoystickPort);

        int rotateJoystickPort =
                getIntPropertyValue("joystick.rotate.port", properties);
        this.rotateJoystick = new Joystick(rotateJoystickPort);
    }

    public Joystick getTranslateJoystick() {
        return translateJoystick;
    }

    public Joystick getRotateJoystick() {
        return rotateJoystick;
    }

}
