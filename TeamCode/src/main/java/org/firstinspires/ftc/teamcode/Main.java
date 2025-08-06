package org.firstinspires.ftc.teamcode;

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
        RollerIntake rollerIntake = new RollerIntake(hardwareMap, gamepad1);
        InSlides slidesIntake = new InSlides(hardwareMap, gamepad1);
        Chamber chamber = new Chamber(hardwareMap, gamepad1);
        OutSlides slidesOuttake = new OutSlides(hardwareMap, gamepad2);
        Arm arm = new Arm(hardwareMap, gamepad2);
        Claw claw = new Claw(hardwareMap, gamepad2);
        Wrist wrist = new Wrist(hardwareMap, gamepad2);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()){

            mecanumDrive.drive();
            rollerIntake.spin();
            slidesIntake.extend();
            slidesOuttake.extend();
            chamber.lift();
            arm.move();
            claw.move();
            wrist.move();

            telemetry.addData("", slidesIntake.telemetry());
            telemetry.addData("", slidesOuttake.telemetry());
            telemetry.addData("", chamber.telemetry());
            telemetry.addData("", arm.telemetry());
            telemetry.addData("", claw.telemetry());
            telemetry.addData("", wrist.telemetry());
            telemetry.update();
        }
    }
}
