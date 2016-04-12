package org.usfirst.frc2175.subsystems;

import java.util.Vector;
import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.subsystems.powertrain.PowertrainSubsystem;
import org.usfirst.frc2175.util.Loopable;

/**
 * Initializes subsystems and makes a vector out of them
 *
 * @author Max Haland
 *
 */
public class RobotSubsystems {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final RobotConfig robotConfig;

    private Vector<Loopable> subsystems;

    public RobotSubsystems(RobotConfig robotConfig, OperatorInteraction oi) {
        log.info("Configuring class=" + getClass());

        this.robotConfig = robotConfig;

        this.subsystems = new Vector<Loopable>();
        // Add subsystems here
        PowertrainSubsystem powertrainSubsystem =
                new PowertrainSubsystem(robotConfig, oi);
        this.subsystems.addElement(powertrainSubsystem);

    }

    public void setDefaultCommands() {
        // TODO write this
    }

    public Vector<Loopable> getSubsystemsVector() {
        return subsystems;
    }

}
