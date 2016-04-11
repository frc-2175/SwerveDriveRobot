package org.usfirst.frc2175.subsystems.powertrain;

import org.usfirst.frc2175.velocity.Velocity;

public class SwerveModuleStateCalculator {

    private ModuleLocation moduleLocation;
    private DriveMode driveMode;

    // This should only be used by the powertrain class, with DriveMode
    // consistent across all modules
    protected SwerveModuleStateCalculator(ModuleLocation moduleLocation,
            DriveMode driveMode) {
        this.moduleLocation = moduleLocation;
        this.driveMode = driveMode;
    }

    protected SwerveModuleStateCalculator(ModuleLocation moduleLocation) {
        this.moduleLocation = moduleLocation;
        this.driveMode = DriveMode.CRAB;
    }

    public void setDriveMode(DriveMode driveMode) {
        this.driveMode = driveMode;
    }

    private double calculateModuleAngle(Velocity translationVelocity,
            double angularVelocity) {
        double angle = 0;
        switch (driveMode) {
        case CRAB:
            angle = translationVelocity.getDirection();
            break;
        case CAR:
            // car stuff here
            break;
        case UNICORN:
            // unicorn stuff here
            break;
        case LOCK:
            // lock stuff here
            break;
        }

        // TODO fill in
        return angle;
    }

    private double calculateIdealModuleSpeed(Velocity translationVelocity,
            double angularVelocity) {
        double angle = 0;
        switch (driveMode) {
        case CRAB:
            angle = translationVelocity.getMagnitude();
            break;
        case CAR:
            // car stuff here
            break;
        case UNICORN:
            // unicorn stuff here
            break;
        case LOCK:
            angle = 0;
            break;
        }
        // TODO fill in
        return 0;
    }

    public Velocity getModuleVelocity(Velocity translationVelocity,
            double angularVelocity) {
        return new Velocity(
                calculateIdealModuleSpeed(translationVelocity, angularVelocity),
                calculateModuleAngle(translationVelocity, angularVelocity));
    }

    public ModuleLocation getModuleLocation() {
        return moduleLocation;
    }

}
