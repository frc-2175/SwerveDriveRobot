package org.usfirst.frc2175.subsystems.powertrain;

import org.usfirst.frc2175.config.PowertrainConfig;
import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.config.WiringConfig;
import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.pid.WheelAnglePIDController;
import org.usfirst.frc2175.subsystems.CalculatorSubsystem;
import org.usfirst.frc2175.velocity.Velocity;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class PowertrainSubsystem extends CalculatorSubsystem {
    // OI
    private OperatorInteraction oi;
    private Velocity commandedTranslateVelocity;
    private double commandedAngularVelocity;

    // TODO add speed PID controllers
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

    public PowertrainSubsystem(RobotConfig robotConfig,
            OperatorInteraction oi) {
        this.oi = oi;
        WiringConfig wiringConfig = robotConfig.getWiringConfig();
        PowertrainConfig powertrainConfig = robotConfig.getPowertrainConfig();

        this.driveFrontLeft = wiringConfig.getDriveFrontLeft();
        this.vectorFrontLeft = wiringConfig.getVectorFrontLeft();
        this.encoderFrontLeft = wiringConfig.getEncoderFrontLeft();
        this.leftFrontAngleController = new WheelAnglePIDController(
                vectorFrontLeft, encoderFrontLeft, robotConfig);

        this.driveFrontRight = wiringConfig.getDriveFrontRight();
        this.vectorFrontRight = wiringConfig.getVectorFrontRight();
        this.encoderFrontRight = wiringConfig.getEncoderFrontRight();
        this.rightFrontAngleController = new WheelAnglePIDController(
                vectorFrontRight, encoderFrontRight, robotConfig);

        this.driveBackLeft = wiringConfig.getDriveBackLeft();
        this.vectorBackLeft = wiringConfig.getVectorBackLeft();
        this.encoderBackLeft = wiringConfig.getEncoderBackLeft();
        this.leftBackAngleController = new WheelAnglePIDController(
                vectorBackLeft, encoderBackLeft, robotConfig);

        this.driveBackRight = wiringConfig.getDriveBackRight();
        this.vectorBackRight = wiringConfig.getVectorBackRight();
        this.encoderBackRight = wiringConfig.getEncoderBackRight();
        this.rightBackAngleController = new WheelAnglePIDController(
                vectorBackRight, encoderBackRight, robotConfig);

        this.drivebaseWidth = powertrainConfig.getDrivebaseWidth();
        this.drivebaseLength = powertrainConfig.getDrivebaseLength();

        swerveDrive = new SwerveDrive(leftFrontAngleController,
                rightFrontAngleController, leftBackAngleController,
                rightBackAngleController);
    }

    /**
     * Sets the DriveMode for the swerve controller
     *
     * @param mode
     *            mode to use from DriveMode
     */
    private void setDriveMode(DriveMode mode) {
        swerveDrive.setDriveMode(mode);
    }

    @Override
    public void update() {
        grabCurrentOIData();
        updateDriveInputs(commandedTranslateVelocity, commandedAngularVelocity);
        swerveDrive.update();
    }

    /**
     * Updates the setpoints of the swerve drive controlller
     *
     * @param translationVelocity
     *            Desired translation Velocity
     * @param angularVelocity
     *            desired angular velocity.
     */
    public void updateDriveInputs(Velocity translationVelocity,
            double angularVelocity) {
        swerveDrive.updateDriveSetpoints(translationVelocity, angularVelocity);
    }

    /**
     * Grabs commanded translate Velocity and angular velocity from the OI
     * instance.
     */
    @Override
    public void grabCurrentOIData() {
        this.commandedTranslateVelocity = oi.getCommandedTranslateVelocity();
        this.commandedAngularVelocity = oi.getCommandedAngularVelocity();
    }
}
