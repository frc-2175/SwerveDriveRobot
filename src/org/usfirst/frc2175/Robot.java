
package org.usfirst.frc2175;

import org.usfirst.frc2175.config.RobotConfig;
import org.usfirst.frc2175.operatorinteraction.OperatorInteraction;
import org.usfirst.frc2175.subsystems.RobotSubsystems;
import org.usfirst.frc2175.systemcontroller.SystemController;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    private final RobotConfig robotConfig = new RobotConfig();

    private final OperatorInteraction oi = new OperatorInteraction(robotConfig);
    // Construct this after OI
    private final RobotSubsystems robotSubsystems =
            new RobotSubsystems(robotConfig, oi);

    // Make system controller
    private final SystemController systemController =
            new SystemController(oi, robotSubsystems);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        systemController.makeLoopers();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
        systemController.disable();
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        systemController.enable();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void teleopInit() {
        systemController.enable();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
    }

}
