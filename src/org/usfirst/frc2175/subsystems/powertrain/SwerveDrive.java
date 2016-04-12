package org.usfirst.frc2175.subsystems.powertrain;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.usfirst.frc2175.loopers.Loopable;
import org.usfirst.frc2175.pid.WheelAnglePIDController;
import org.usfirst.frc2175.velocity.Velocity;

public class SwerveDrive implements Loopable {
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

    public SwerveDrive(WheelAnglePIDController leftFrontController,
            WheelAnglePIDController rightFrontController,
            WheelAnglePIDController leftBackController,
            WheelAnglePIDController rightBackController) {
        this.leftFrontController = leftFrontController;
        this.rightFrontController = rightFrontController;
        this.leftBackController = leftBackController;
        this.rightBackController = rightBackController;

        // This is currently magic, may want to change later. It should be the
        // smallest that the RoboRIO can keep consistent loop times.

        log.log(Level.INFO, "Initialized new SwerveDrive instance");
    }

    @Override
    public void update() {
        leftFrontController.update();
        rightFrontController.update();
        leftBackController.update();
        rightBackController.update();
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

}
