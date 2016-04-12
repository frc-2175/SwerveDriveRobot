package org.usfirst.frc2175.pid;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.loopers.Loopable;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class WheelSpeedPIDController extends PIDController implements Loopable {

    private CANTalon driveTalon;
    private Encoder driveEncoder;
    private double tolerance;

    public WheelSpeedPIDController(CANTalon driveTalon, Encoder driveEncoder,
            RobotConfig robotConfig) {
        double p = robotConfig.getControlLoopConfig().getSpeedPID_p();
        double i = robotConfig.getControlLoopConfig().getSpeedPID_i();
        double d = robotConfig.getControlLoopConfig().getSpeedPID_d();
        setPID(p, i, d);

        double min = -robotConfig.getControlLoopConfig().getSpeedPID_range();
        double max = robotConfig.getControlLoopConfig().getSpeedPID_range();
        setOutputRange(min, max);

        this.tolerance =
                robotConfig.getControlLoopConfig().getAnglePID_tolerance();
    }

    public boolean isOnTarget() {
        return onTarget(tolerance);
    }

    @Override
    public void update() {
        driveTalon.set(calculate(driveEncoder.getDistance()));
    }

}
