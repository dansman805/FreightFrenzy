package org.firstinspires.ftc.teamcode.opmode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystem.Carousel;
import org.firstinspires.ftc.teamcode.subsystem.Deposit;
import org.firstinspires.ftc.teamcode.subsystem.Intake;
import org.firstinspires.ftc.teamcode.subsystem.TurretCap;

abstract public class OpModeTemplate extends CommandOpMode {
    protected SampleMecanumDrive mecanumDrive;
    protected Deposit deposit;
    protected Intake intake;
    protected Carousel carousel;
    protected TurretCap turretCap;

    protected GamepadEx driverGamepad;
    protected GamepadEx secondaryGamepad;

    protected void initHardware(boolean isAuto) {
        mecanumDrive = new SampleMecanumDrive(hardwareMap);

        deposit = new Deposit(hardwareMap, isAuto);
        intake = new Intake(hardwareMap);
        carousel = new Carousel(hardwareMap);
        turretCap = new TurretCap(hardwareMap, isAuto);

        register(intake, deposit, carousel, turretCap);

        driverGamepad = new GamepadEx(gamepad1);
        secondaryGamepad = new GamepadEx(gamepad2);
    }

    public enum Alliance {
        RED,
        BLUE;
        public double adjust(double input) {
            return this == RED ? input : -input;
        }
    }
}
