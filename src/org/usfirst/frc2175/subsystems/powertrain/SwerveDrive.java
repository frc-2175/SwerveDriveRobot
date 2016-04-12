package org.usfirst.frc2175.subsystems.powertrain;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc2175.pid.WheelAnglePIDController;
import org.usfirst.frc2175.util.MultiLooper;
import org.usfirst.frc2175.velocity.Velocity;

public class SwerveDrive {
    private final Logger log = Logger.getLogger(getClass().getName());

    private final SwerveModuleStateCalculator leftFrontModule =
            new SwerveModuleStateCalculator(ModuleLocation.FRONT_LEFT);
    private final SwerveModuleStateCalculator rightFrontModule =
            new SwerveModuleStateCalculator(ModuleLocation.FRONT_RIGHT);
    private final SwerveModuleStateCalculator leftBackModule =
            new SwerveModuleStateCalculator(ModuleLocation.BACK_LEFT);
    private final SwerveModuleStateCalculator rightBackModule =
            new SwerveModuleStateCalculator(ModuleLocation.BACK_RIGHT);

    private WheelAnglePIDController leftFrontController;
    private WheelAnglePIDController rightFrontController;
    private WheelAnglePIDController leftBackController;
    private WheelAnglePIDController rightBackController;

    private MultiLooper wheelPIDLooper;

    public SwerveDrive(WheelAnglePIDController leftFrontController,
            WheelAnglePIDController rightFrontController,
            WheelAnglePIDController leftBackController,
            WheelAnglePIDController rightBackController) {
        this.leftFrontController = leftFrontController;
        this.rightFrontController = rightFrontController;
        this.leftBackController = leftBackController;
        this.rightBackController = rightBackController;

        wheelPIDLooper = new MultiLooper(1 / 100);
        wheelPIDLooper.addLoopable(leftFrontController);
        wheelPIDLooper.addLoopable(rightFrontController);
        wheelPIDLooper.addLoopable(leftBackController);
        wheelPIDLooper.addLoopable(rightBackController);

        log.log(Level.INFO, "Initialized new SwerveDrive instance");
    }

    /**
     * Updates the setpoints for each drive module.
     *
     * @param translationVelocity
     *            Overall desired velocity
     * @param angularVelocity
     *            Desired angular velocity
     */
    // TODO currently only has angle one implemented
    public void updateDriveSetpoints(Velocity translationVelocity,
            double angularVelocity) {
        Velocity leftFrontVelocity = leftFrontModule
                .getModuleVelocity(translationVelocity, angularVelocity);
        leftFrontController.setSetpoint(leftFrontVelocity.getDirection());

        Velocity rightFrontVelocity = rightFrontModule
                .getModuleVelocity(translationVelocity, angularVelocity);
        rightFrontController.setSetpoint(rightFrontVelocity.getDirection());

        Velocity leftBackVelocity = leftBackModule
                .getModuleVelocity(translationVelocity, angularVelocity);
        leftBackController.setSetpoint(leftBackVelocity.getDirection());

        Velocity rightBackVelocity = rightBackModule
                .getModuleVelocity(translationVelocity, angularVelocity);
        rightBackController.setSetpoint(rightBackVelocity.getDirection());
    }

    /**
     * Update the drive mode for the swerve drive
     *
     * @param mode
     *            The mode to use
     */
    public void setDriveMode(DriveMode mode) {
        leftFrontModule.setDriveMode(mode);
        rightFrontModule.setDriveMode(mode);
        leftBackModule.setDriveMode(mode);
        rightBackModule.setDriveMode(mode);
        log.log(Level.FINE, "Setting drive mode to " + mode);
    }

    public void enable() {
        wheelPIDLooper.enable();
        log.log(Level.INFO, "Enabling drive controllers");
    }

    public void disable() {
        wheelPIDLooper.disable();
        log.log(Level.INFO, "Disabling drive controllers");
    }

}
