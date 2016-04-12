package org.usfirst.frc2175.pid;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.loopers.Loopable;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class WheelAnglePIDController extends PIDController implements Loopable {

    private CANTalon angleTalon;
    private Encoder angleEncoder;
    private double tolerance;

    public WheelAnglePIDController(CANTalon angleTalon, Encoder angleEncoder,
            RobotConfig robotConfig) {
        double p = robotConfig.getControlLoopConfig().getAnglePID_p();
        double i = robotConfig.getControlLoopConfig().getAnglePID_i();
        double d = robotConfig.getControlLoopConfig().getAnglePID_d();
        setPID(p, i, d);

        double min = -robotConfig.getControlLoopConfig().getAnglePID_range();
        double max = robotConfig.getControlLoopConfig().getAnglePID_range();
        setOutputRange(min, max);

        this.tolerance =
                robotConfig.getControlLoopConfig().getAnglePID_tolerance();
    }

    public boolean isOnTarget() {
        return onTarget(tolerance);
    }

    @Override
    public void update() {
        angleTalon.set(calculate(angleEncoder.getDistance()));
    }

}
