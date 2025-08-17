package org.firstinspires.ftc.teamcode.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.MecanumDriveEx;
import org.firstinspires.ftc.teamcode.intake.Chamber;
import org.firstinspires.ftc.teamcode.intake.InSlides;
import org.firstinspires.ftc.teamcode.intake.RollerIntake;
import org.firstinspires.ftc.teamcode.outtake.Arm;
import org.firstinspires.ftc.teamcode.outtake.Claw;
import org.firstinspires.ftc.teamcode.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.outtake.Wrist;

@TeleOp
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDriveEx mecanumDrive = new MecanumDriveEx(hardwareMap, gamepad1);
        RollerIntake roller = new RollerIntake(hardwareMap);
        InSlides slidesIntake = new InSlides(hardwareMap, gamepad1);
        Chamber chamber = new Chamber(hardwareMap);
        OutSlides outtakeSlides= new OutSlides(hardwareMap);
        Arm arm = new Arm(hardwareMap);
        Claw claw = new Claw(hardwareMap);
        Wrist wrist = new Wrist(hardwareMap);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()){

            mecanumDrive.drive();
//
        }
    }
}
