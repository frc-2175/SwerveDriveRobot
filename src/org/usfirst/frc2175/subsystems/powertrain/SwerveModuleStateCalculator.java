package org.usfirst.frc2175.subsystems.powertrain;

public class SwerveModuleStateCalculator {

    private double xTranslation;
    private double yTranslation;
    private double rotation;
    private ModuleLocation moduleLocation;

    public SwerveModuleStateCalculator(ModuleLocation moduleLocation) {
        this.moduleLocation = moduleLocation;
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
