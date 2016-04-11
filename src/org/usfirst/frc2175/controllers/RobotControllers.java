package org.usfirst.frc2175.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.subsystems.RobotSubsystems;

public class RobotControllers {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final RobotConfig robotConfig;

    public RobotControllers(RobotSubsystems robotSubsystems,
            RobotConfig robotConfig) {
        log.info("Configuring class=" + getClass());

        try {
            this.robotConfig = robotConfig;
        } catch (Exception e) {
            final String msg =
                    "Error instantiating a PIDController in RobotControllers:";
            log.log(Level.SEVERE, msg, e);
            throw e;
        }
    }

}
