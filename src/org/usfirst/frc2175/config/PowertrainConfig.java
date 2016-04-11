package org.usfirst.frc2175.config;

import java.util.Properties;

public class PowertrainConfig extends BaseConfig {

    private double drivebaseWidth;
    private double drivebaseLength;

    @Override
    protected String getPropertyFileName() {
        return "powertrain.properties";
    }

    @Override
    protected void configure(Properties props) {
        this.drivebaseWidth = getDoublePropertyValue("drivebase.width", props);
        this.drivebaseLength =
                getDoublePropertyValue("drivebase.length", props);
    }

    public double getDrivebaseWidth() {
        return drivebaseWidth;
    }

    public double getDrivebaseLength() {
        return drivebaseLength;
    }

}
