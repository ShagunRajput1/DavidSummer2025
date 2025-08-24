package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Choreo.StepByStep;
import org.firstinspires.ftc.teamcode.David;

@TeleOp(name = "Steps Check")
public class StepsChecks extends LinearOpMode {
        @Override
        public void runOpMode() throws InterruptedException {
            David.init(hardwareMap, gamepad1, gamepad2);

            StepByStep a = new StepByStep(gamepad1);

            waitForStart();
            if (isStopRequested()) return;

            while (opModeIsActive()) {
                a.runRoutine();

                telemetry.addData("outtake slides", David.outtakeSlides.getVelocity());
            }
        }
    }

