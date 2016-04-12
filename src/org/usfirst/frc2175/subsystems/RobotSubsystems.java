package org.usfirst.frc2175.subsystems;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.subsystems.powertrain.PowertrainSubsystem;

/**
 * Initializes subsystems and makes an ArrayList out of them
 *
 * @author Max Haland
 *
 */
public class RobotSubsystems {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final RobotConfig robotConfig;

    private ArrayList<CalculatorSubsystem> subsystems;

    public RobotSubsystems(RobotConfig robotConfig, OperatorInteraction oi) {
        log.info("Configuring class=" + getClass());

        this.robotConfig = robotConfig;

        this.subsystems = new ArrayList<CalculatorSubsystem>();
        // Add subsystems here
        PowertrainSubsystem powertrainSubsystem =
                new PowertrainSubsystem(robotConfig, oi);
        // Index zero
        this.subsystems.add(powertrainSubsystem);

    }

    public void setDefaultCommands() {
        // TODO write this
    }

    public ArrayList<CalculatorSubsystem> getSubsystemsList() {
        return subsystems;
    }

    /**
     * Looks up a subsystem by class name and returns it
     *
     * @param name
     *            Subsystem name to look up
     * @return The subsystem with the desired name
     */
    public CalculatorSubsystem getSubsystemByName(String name) {
        CalculatorSubsystem correctSubsystem = null;
        try {
            for (CalculatorSubsystem e : subsystems) {
                String subsystemName = e.getClass().getName();
                if (subsystemName == name) {
                    correctSubsystem = e;
                }
            }
            if (correctSubsystem == null) {
                IllegalAccessException e =
                        new IllegalAccessException("Subsystem not found");
                throw e;
            }
        } catch (IllegalAccessException e) {
            log.log(Level.SEVERE,
                    "Subsystem not found! This is really bad. Check if you initialized it into the subsystem Vector",
                    e);
        }
        return correctSubsystem;
    }

}
