package org.usfirst.frc2175.systemcontroller;

import java.util.ArrayList;

import org.usfirst.frc2175.loopers.CommandLooper;
import org.usfirst.frc2175.loopers.Looper;
import org.usfirst.frc2175.loopers.MultiLooper;
import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.subsystems.CalculatorSubsystem;
import org.usfirst.frc2175.subsystems.RobotSubsystems;

/**
 * Runs Loopers for robot systems. Handles running the OI, along with a vector
 * of subsystems.
 *
 * @author Max Haland
 */
public class SystemController {
    private OperatorInteraction oi;

    private ArrayList<CalculatorSubsystem> subsystems;

    private Looper oiLooper;
    private CommandLooper commandLooper;
    private MultiLooper subsystemLooper;

    public SystemController(OperatorInteraction oi,
            RobotSubsystems robotSubsystems) {
        this.oi = oi;

        // Add subsystems to subsystemLooper
        for (CalculatorSubsystem e : robotSubsystems.getSubsystemsList()) {
            subsystemLooper.addLoopable(e);
        }
    }

    public void makeLoopers() {
        // This one should be slow, as it is limited by FMS
        // Set to 50 Hz
        oiLooper = new Looper(oi, 1 / 50);

        // The should run at the same speed as the OI looper. It should only run
        // commands that set "spoofed" inputs for the OI instance.
        commandLooper = new CommandLooper(1 / 50);

        // This one we want as fast as possible.
        // Currently set to 200Hz
        subsystemLooper = new MultiLooper(1 / 200);

    }

    public void enable() {
        oiLooper.enable();
        subsystemLooper.enable();
        commandLooper.enable();
    }

    public void disable() {
        oiLooper.disable();
        subsystemLooper.disable();
        commandLooper.disable();
    }

    public MultiLooper getSubsystemLooper() {
        return this.subsystemLooper;
    }

}
