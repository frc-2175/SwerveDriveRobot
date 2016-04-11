package org.usfirst.frc2175.subsystems.powertrain;

import org.usfirst.frc2175.config.PowertrainConfig;
import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.config.WiringConfig;
import org.usfirst.frc2175.controllers.WheelAnglePIDController;
import org.usfirst.frc2175.subsystems.BaseSubsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class PowertrainSubsystem extends BaseSubsystem {
    // Left front module
    private CANTalon driveFrontLeft;
    private CANTalon vectorFrontLeft;
    private Encoder encoderFrontLeft;
    private WheelAnglePIDController leftFrontAngleController;

    // Right front module
    private CANTalon driveFrontRight;
    private CANTalon vectorFrontRight;
    private Encoder encoderFrontRight;
    private WheelAnglePIDController rightFrontAngleController;

    // Left back module
    private CANTalon driveBackLeft;
    private CANTalon vectorBackLeft;
    private Encoder encoderBackLeft;
    private WheelAnglePIDController leftBackAngleController;

    // Right back module
    private CANTalon driveBackRight;
    private CANTalon vectorBackRight;
    private Encoder encoderBackRight;
    private WheelAnglePIDController rightBackAngleController;

    // Geometry
    private double drivebaseWidth;
    private double drivebaseLength;

    // Drive system
    private SwerveDrive swerveDrive;

    public PowertrainSubsystem(RobotConfig robotConfig) {
        WiringConfig wiringConfig = robotConfig.getWiringConfig();
        PowertrainConfig powertrainConfig = robotConfig.getPowertrainConfig();

        this.driveFrontLeft = wiringConfig.getDriveFrontLeft();
        this.vectorFrontLeft = wiringConfig.getVectorFrontLeft();
        this.encoderFrontLeft = wiringConfig.getEncoderFrontLeft();
        this.leftFrontAngleController = new WheelAnglePIDController(
                driveFrontLeft, encoderFrontLeft, robotConfig);

        this.driveFrontRight = wiringConfig.getDriveFrontRight();
        this.vectorFrontRight = wiringConfig.getVectorFrontRight();
        this.encoderFrontRight = wiringConfig.getEncoderFrontRight();
        this.rightFrontAngleController = new WheelAnglePIDController(
                driveFrontRight, encoderFrontRight, robotConfig);

        this.driveBackLeft = wiringConfig.getDriveBackLeft();
        this.vectorBackLeft = wiringConfig.getVectorBackLeft();
        this.encoderBackLeft = wiringConfig.getEncoderBackLeft();
        this.leftBackAngleController = new WheelAnglePIDController(
                driveBackLeft, encoderBackLeft, robotConfig);

        this.driveBackRight = wiringConfig.getDriveBackRight();
        this.vectorBackRight = wiringConfig.getVectorBackRight();
        this.encoderBackRight = wiringConfig.getEncoderBackRight();
        this.rightBackAngleController = new WheelAnglePIDController(
                driveBackRight, encoderBackRight, robotConfig);

        this.drivebaseWidth = powertrainConfig.getDrivebaseWidth();
        this.drivebaseLength = powertrainConfig.getDrivebaseLength();

        swerveDrive = new SwerveDrive(leftFrontAngleController,
                rightFrontAngleController, leftBackAngleController,
                rightBackAngleController);
    }

    public SwerveDrive getSwerveDrive() {
        return swerveDrive;
    }
}
