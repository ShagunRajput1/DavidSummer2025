package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.David.arm;
import static org.firstinspires.ftc.teamcode.David.chamber;
import static org.firstinspires.ftc.teamcode.David.claw;
import static org.firstinspires.ftc.teamcode.David.mecanumDrive;
import static org.firstinspires.ftc.teamcode.David.outtakeSlides;
import static org.firstinspires.ftc.teamcode.David.roller;
import static org.firstinspires.ftc.teamcode.David.slidesIntake;
import static org.firstinspires.ftc.teamcode.David.wrist;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.David;

@TeleOp
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        David.init(hardwareMap, gamepad1, gamepad2);


        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()){
            mecanumDrive.drive();
            chamber.control();
            slidesIntake.control();
            roller.control();
            arm.control();
            outtakeSlides.control();
            wrist.control();
            claw.control();


            telemetry.addData("", chamber.telemetry());
            telemetry.addData("", slidesIntake.telemetry());
            telemetry.addData("", arm.telemetry());
            telemetry.addData("", outtakeSlides.telemetry());
            telemetry.addData("", wrist.telemetry());
            telemetry.addData("", claw.telemetry());

            telemetry.update();
            }
        }
    }
