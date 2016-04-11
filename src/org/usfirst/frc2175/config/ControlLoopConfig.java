package org.usfirst.frc2175.config;

import java.util.Properties;

public class ControlLoopConfig extends BaseConfig {
    @Override
    protected String getPropertyFileName() {
        return "controlLoopConfig.properties";
    }

    private double anglePID_p;
    private double anglePID_i;
    private double anglePID_d;
    private double anglePID_range;
    private double anglePID_tolerance;

    private double speedPID_p;
    private double speedPID_i;
    private double speedPID_d;
    private double speedPID_range;
    private double speedPID_tolerance;

    @Override
    protected void configure(Properties props) {
        this.anglePID_p = getDoublePropertyValue("pid.angle.p", props);
        this.anglePID_i = getDoublePropertyValue("pid.angle.i", props);
        this.anglePID_d = getDoublePropertyValue("pid.angle.d", props);
        this.anglePID_range = getDoublePropertyValue("pid.angle.range", props);
        this.anglePID_tolerance =
                getDoublePropertyValue("pid.angle.tolerance", props);

        this.speedPID_p = getDoublePropertyValue("pid.speed.p", props);
        this.speedPID_i = getDoublePropertyValue("pid.speed.i", props);
        this.speedPID_d = getDoublePropertyValue("pid.speed.d", props);
        this.speedPID_range = getDoublePropertyValue("pid.speed.range", props);
        this.speedPID_tolerance =
                getDoublePropertyValue("pid.speed.tolerance", props);
    }

    public double getAnglePID_p() {
        return anglePID_p;
    }

    public double getAnglePID_i() {
        return anglePID_i;
    }

    public double getAnglePID_d() {
        return anglePID_d;
    }

    public double getAnglePID_range() {
        return anglePID_range;
    }

    public double getAnglePID_tolerance() {
        return anglePID_tolerance;
    }

    public double getSpeedPID_p() {
        return speedPID_p;
    }

    public double getSpeedPID_i() {
        return speedPID_i;
    }

    public double getSpeedPID_d() {
        return speedPID_d;
    }

    public double getSpeedPID_range() {
        return speedPID_range;
    }

    public double getSpeedPID_tolerance() {
        return speedPID_tolerance;
    }

}
