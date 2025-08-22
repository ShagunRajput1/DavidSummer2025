package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.drivetrain.MecanumDriveEx;
import org.firstinspires.ftc.teamcode.Subsystems.intake.Chamber;
import org.firstinspires.ftc.teamcode.Subsystems.intake.InSlides;
import org.firstinspires.ftc.teamcode.Subsystems.intake.RollerIntake;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;


public class David {
    public static MecanumDriveEx mecanumDrive;
    public static RollerIntake roller;
    public static InSlides slidesIntake;
    public static Chamber chamber;
    public static OutSlides outtakeSlides;
    public static Arm arm;
    public static Claw claw;
    public static Wrist wrist;

    public static void init(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2 ) {

        mecanumDrive = new MecanumDriveEx(hardwareMap, gamepad1);
        roller = new RollerIntake(hardwareMap, gamepad1);
        slidesIntake = new InSlides(hardwareMap, gamepad1);
        chamber = new Chamber(hardwareMap, gamepad1);
        outtakeSlides = new OutSlides(hardwareMap, gamepad2);
        arm = new Arm(hardwareMap, gamepad2);
        claw = new Claw(hardwareMap, gamepad2);
        wrist = new Wrist(hardwareMap, gamepad2);
    }
}

