package org.usfirst.frc2175.velocity;

/**
 * Math functions for Velocities
 *
 * @author Max Haland
 */
public class VelocityMath {

    public double dotProduct(Velocity v1, Velocity v2) {
        return v1.getMagnitude() * v2.getMagnitude()
                * Math.cos(v1.getDirection() - v2.getDirection());
    }

    public Velocity add(Velocity v1, Velocity v2) {
        Velocity v1_plus_v2 = new Velocity();
        double v1_x = v1.getMagnitude() * Math.cos(v1.getDirection());
        double v1_y = v1.getMagnitude() * Math.sin(v1.getDirection());

        double v2_x = v2.getMagnitude() * Math.cos(v2.getDirection());
        double v2_y = v2.getMagnitude() * Math.sin(v2.getDirection());

        // Add componentwise
        double new_x_component = v1_x + v2_x;
        double new_y_component = v1_y + v2_y;

        // Use arctangent to calculate the new angle
        double new_direction = 0;
        double atan = Math.abs(Math.atan(new_y_component / new_x_component));
        // Handle quadrants
        if (new_y_component >= 0 && new_x_component >= 0) {
            new_direction = atan;
        } else if (new_y_component >= 0 && new_x_component < 0) {
            new_direction = atan + Math.PI / 2;
        } else if (new_y_component < 0 && new_x_component < 0) {
            new_direction = atan + Math.PI;
        } else if (new_y_component < 0 && new_x_component >= 0) {
            new_direction = atan + (3 * Math.PI / 2);
        }

        v1_plus_v2.setMagnitude(Math.sqrt((new_x_component) * (new_x_component)
                + (new_y_component * new_y_component)));
        v1_plus_v2.setDirection(new_direction);

        return v1_plus_v2;
    }

    public Velocity scalarMult(Velocity v, double a) {
        Velocity v_new = new Velocity(a * v.getMagnitude(), v.getDirection());
        return v_new;
    }

}
