package org.usfirst.frc2175.subsystems.powertrain;

/**
 * A Velocity serves as a framework for vector math. The key features for a
 * Velocity are that they have a magnitude, a direction, and can be added
 * together. Velocities are used to represent the movement of each module in the
 * swerve drive, but can be used for other things as well.
 *
 * Velocity is currently only implemented for two-dimensional vectors, but could
 * be expanded to work in more dimensions as well.
 *
 * @author Max Haland
 *
 */
public class Velocity {
    double magnitude;
    double direction;

    public Velocity(double magnitude, double direction) {
        this.magnitude = magnitude;
        this.direction = direction;
    }

}
