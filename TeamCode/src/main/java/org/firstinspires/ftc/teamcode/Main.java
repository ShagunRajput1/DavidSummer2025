package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.MecanumDriveEx;
import org.firstinspires.ftc.teamcode.intake.RollerIntake;
import org.firstinspires.ftc.teamcode.intake.Slides;

@TeleOp
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDriveEx mecanumDrive = new MecanumDriveEx(hardwareMap);
        RollerIntake rollerIntake = new RollerIntake(hardwareMap);
        Slides slidesIntake = new Slides(hardwareMap);
        Slides chamberLift = new Slides(hardwareMap);

        waitForStart();

        // initialising code will be entered before; if nothing then have to start to start code


        while(opModeIsActive()){
            mecanumDrive.drive(gamepad1, telemetry);
            rollerIntake.roller(gamepad1);
            slidesIntake.intakeSlides(gamepad1);
            chamberLift.chamber(gamepad1, telemetry);
        }
    }


}
