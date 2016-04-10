package org.usfirst.frc2175.config;

public class RobotConfig {
    private final LoggingConfig loggingConfig = new LoggingConfig();

    private final WiringConfig wiringConfig = new WiringConfig();

    public LoggingConfig getLoggingConfig() {
        return loggingConfig;
    }

    public WiringConfig getWiringConfig() {
        return wiringConfig;
    }

}
