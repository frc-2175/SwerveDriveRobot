package org.usfirst.frc2175.velocity;

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

    public Velocity() {
    }

    public Velocity(double magnitude, double direction) {
        this.magnitude = magnitude;
        this.direction = direction;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public static final class ZeroVelocity {
        public final Velocity getZeroVelocity = new Velocity(0, 0);
    }

}
