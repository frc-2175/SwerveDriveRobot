package org.usfirst.frc2175.systemcontroller;

import java.util.Vector;

import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.subsystems.CalculatorSubsystem;
import org.usfirst.frc2175.subsystems.RobotSubsystems;
import org.usfirst.frc2175.util.Looper;
import org.usfirst.frc2175.util.MultiLooper;

/**
 * Runs Loopers for robot systems. Handles running the OI, along with a vector
 * of subsystems.
 *
 * @author Max Haland
 */
public class SystemController {
    private OperatorInteraction oi;

    private Vector<CalculatorSubsystem> subsystems;

    private Looper oiLooper;
    private MultiLooper subsystemLooper;

    public SystemController(OperatorInteraction oi,
            RobotSubsystems robotSubsystems) {
        this.oi = oi;

        // Add subsystems to subsystemLooper
        subsystemLooper.addLoopables(robotSubsystems.getSubsystemsVector());
    }

    public void makeLoopers() {
        // This one should be slow, as it is limited by FMS
        // Set to 50 Hz
        oiLooper = new Looper(oi, 1 / 50);

        // This one we want as fast as possible.
        // Currently set to 200Hz
        subsystemLooper = new MultiLooper(1 / 200);

    }

    public void enable() {
        oiLooper.enable();
        subsystemLooper.enable();
    }

    public void disable() {
        oiLooper.disable();
        subsystemLooper.disable();
    }

    public MultiLooper getSubsystemLooper() {
        return this.subsystemLooper;
    }

}
