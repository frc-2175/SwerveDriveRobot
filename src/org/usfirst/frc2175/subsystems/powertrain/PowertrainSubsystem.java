package org.usfirst.frc2175.subsystems.powertrain;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.config.WiringConfig;
import org.usfirst.frc2175.subsystems.BaseSubsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class PowertrainSubsystem extends BaseSubsystem {
    private CANTalon driveFrontLeft;
    private CANTalon vectorFrontLeft;
    private Encoder encoderFrontLeft;

    private CANTalon driveFrontRight;
    private CANTalon vectorFrontRight;
    private Encoder encoderFrontRight;

    private CANTalon driveBackLeft;
    private CANTalon vectorBackLeft;
    private Encoder encoderBackLeft;

    private CANTalon driveBackRight;
    private CANTalon vectorBackRight;
    private Encoder encoderBackRight;

    public PowertrainSubsystem(RobotConfig robotConfig) {
        WiringConfig wiringConfig = robotConfig.getWiringConfig();

        this.driveFrontLeft = wiringConfig.getDriveFrontLeft();
        this.vectorFrontLeft = wiringConfig.getVectorFrontLeft();
        this.encoderFrontLeft = wiringConfig.getEncoderFrontLeft();

        this.driveFrontRight = wiringConfig.getDriveFrontRight();
        this.vectorFrontRight = wiringConfig.getVectorFrontRight();
        this.encoderFrontRight = wiringConfig.getEncoderFrontRight();

        this.driveBackLeft = wiringConfig.getDriveBackLeft();
        this.vectorBackLeft = wiringConfig.getVectorBackLeft();
        this.encoderBackLeft = wiringConfig.getEncoderBackLeft();

        this.driveBackRight = wiringConfig.getDriveBackRight();
        this.vectorBackRight = wiringConfig.getVectorBackRight();
        this.encoderBackRight = wiringConfig.getEncoderBackRight();

    }
}
