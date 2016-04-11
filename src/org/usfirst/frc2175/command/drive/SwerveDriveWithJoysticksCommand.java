package org.usfirst.frc2175.command.drive;

import org.usfirst.frc2175.command.BaseCommand;
import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.subsystems.RobotSubsystems;
import org.usfirst.frc2175.subsystems.powertrain.PowertrainSubsystem;
import org.usfirst.frc2175.velocity.Velocity;

public class SwerveDriveWithJoysticksCommand extends BaseCommand {

    private PowertrainSubsystem powertrainSubsystem;
    private OperatorInteraction operatorInteraction;

    public SwerveDriveWithJoysticksCommand(
            OperatorInteraction operatorInteraction,
            RobotSubsystems robotSubsystems) {
        this.powertrainSubsystem = robotSubsystems.getPowertrainSubsystem();
        this.operatorInteraction = operatorInteraction;

        requires(this.powertrainSubsystem);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void execute() {
        Velocity translateVelocity = operatorInteraction.getTranslateVelocity();
        double angularVelocity = operatorInteraction.getAngularVelocity();

        powertrainSubsystem.driveWithInputs(translateVelocity, angularVelocity);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        powertrainSubsystem.driveWithInputs(
                new Velocity.ZeroVelocity().getZeroVelocity, 0);
        super.end();
    }

    @Override
    protected void interrupted() {

    }

}
