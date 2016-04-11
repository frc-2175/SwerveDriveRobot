package org.usfirst.frc2175.subsystems.powertrain;

import org.usfirst.frc2175.operatorinteraction.DriveMode;

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
        this.driveMode = DriveMode.UNICORN;
    }

    public double calculateModuleAngle(double xTranslation, double yTranslation,
            double rotation) {
        // TODO fill in
        return 0;
    }

    public double calculateModuleSpeed(double xTranslation, double yTranslation,
            double rotation) {
        // TODO fill in
        return 0;
    }

    public ModuleLocation getModuleLocation() {
        return moduleLocation;
    }

}
