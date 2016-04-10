package org.usfirst.frc2175.config;

import java.util.Properties;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;

public class WiringConfig extends BaseConfig {

    @Override
    protected String getPropertyFileName() {
        return "wiring.properties";
    }

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

    @Override
    protected void configure(Properties props) {
        this.driveFrontLeft = new CANTalon(getIntPropertyValue(
                "powertrain.talon.front.left.drive", props));
        this.vectorFrontLeft = new CANTalon(getIntPropertyValue(
                "powertrain.talon.front.left.vector", props));
        this.encoderFrontLeft = new Encoder(
                getIntPropertyValue("powertrain.encoder.front.left.a", props),
                getIntPropertyValue("powertrain.encoder.front.left.b", props));

        this.driveFrontRight = new CANTalon(getIntPropertyValue(
                "powertrain.talon.front.right.drive", props));
        this.vectorFrontRight = new CANTalon(getIntPropertyValue(
                "powertrain.talon.front.right.vector", props));
        this.encoderFrontRight = new Encoder(
                getIntPropertyValue("powertrain.encoder.front.right.a", props),
                getIntPropertyValue("powertrain.encoder.front.right.b", props));

        this.driveBackLeft = new CANTalon(
                getIntPropertyValue("powertrain.talon.back.left.drive", props));
        this.vectorBackLeft = new CANTalon(getIntPropertyValue(
                "powertrain.talon.back.left.vector", props));
        this.encoderFrontLeft = new Encoder(
                getIntPropertyValue("powertrain.encoder.back.left.a", props),
                getIntPropertyValue("powertrain.encoder.back.left.b", props));

        this.driveBackRight = new CANTalon(getIntPropertyValue(
                "powertrain.talon.back.right.drive", props));
        this.vectorBackRight = new CANTalon(getIntPropertyValue(
                "powertrain.talon.back.right.vector", props));
        this.encoderFrontRight = new Encoder(
                getIntPropertyValue("powertrain.encoder.back.right.a", props),
                getIntPropertyValue("powertrain.encoder.back.right.b", props));
    }

    public CANTalon getDriveFrontLeft() {
        return driveFrontLeft;
    }

    public CANTalon getVectorFrontLeft() {
        return vectorFrontLeft;
    }

    public Encoder getEncoderFrontLeft() {
        return encoderFrontLeft;
    }

    public CANTalon getDriveFrontRight() {
        return driveFrontRight;
    }

    public CANTalon getVectorFrontRight() {
        return vectorFrontRight;
    }

    public Encoder getEncoderFrontRight() {
        return encoderFrontRight;
    }

    public CANTalon getDriveBackLeft() {
        return driveBackLeft;
    }

    public CANTalon getVectorBackLeft() {
        return vectorBackLeft;
    }

    public Encoder getEncoderBackLeft() {
        return encoderBackLeft;
    }

    public CANTalon getDriveBackRight() {
        return driveBackRight;
    }

    public CANTalon getVectorBackRight() {
        return vectorBackRight;
    }

    public Encoder getEncoderBackRight() {
        return encoderBackRight;
    }

}
