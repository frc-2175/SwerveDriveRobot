package org.usfirst.frc2175.pid;

import org.usfirst.frc2175.config.RobotConfig;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class WheelAnglePIDController extends PIDControllerComplete {

    private CANTalon angleTalon;
    private Encoder angleEncoder;

    public WheelAnglePIDController(CANTalon angleTalon, Encoder angleEncoder,
            RobotConfig robotConfig) {
        double p = robotConfig.getControlLoopConfig().getAnglePID_p();
        double i = robotConfig.getControlLoopConfig().getAnglePID_i();
        double d = robotConfig.getControlLoopConfig().getAnglePID_d();
        setPID(p, i, d);

        double min = -robotConfig.getControlLoopConfig().getAnglePID_range();
        double max = robotConfig.getControlLoopConfig().getAnglePID_range();
        setOutputRange(min, max);

        double tolerance =
                robotConfig.getControlLoopConfig().getAnglePID_tolerance();
        setAbsoluteTolerance(tolerance);
    }

    @Override
    public double pidGet() {
        // TODO Figure out the way to calculate the current angle-will depend on
        // the physical robot
        return 0;
    }

    @Override
    public void pidWrite(double output) {
    }

}
