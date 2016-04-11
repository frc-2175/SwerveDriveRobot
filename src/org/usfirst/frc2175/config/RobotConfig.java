package org.usfirst.frc2175.config;

public class RobotConfig {
    private final LoggingConfig loggingConfig = new LoggingConfig();

    private final WiringConfig wiringConfig = new WiringConfig();
    private final ControlLoopConfig controlLoopConfig = new ControlLoopConfig();
    private final PowertrainConfig powertrainConfig = new PowertrainConfig();

    public LoggingConfig getLoggingConfig() {
        return loggingConfig;
    }

    public WiringConfig getWiringConfig() {
        return wiringConfig;
    }

    public ControlLoopConfig getControlLoopConfig() {
        return controlLoopConfig;
    }

    public PowertrainConfig getPowertrainConfig() {
        return powertrainConfig;
    }

}
