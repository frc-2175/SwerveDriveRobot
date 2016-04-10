package org.usfirst.frc2175.subsystems;

import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.subsystems.powertrain.PowertrainSubsystem;

public class RobotSubsystems {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final RobotConfig robotConfig;

    private final PowertrainSubsystem powertrainSubsystem;

    public RobotSubsystems(RobotConfig robotConfig) {
        log.info("Configuring class=" + getClass());

        this.robotConfig = robotConfig;

        powertrainSubsystem = new PowertrainSubsystem(robotConfig);
    }

    public void setDefaultCommands() {
        // TODO write this
    }

    public PowertrainSubsystem getPowertrainSubsystem() {
        return powertrainSubsystem;
    }

}
