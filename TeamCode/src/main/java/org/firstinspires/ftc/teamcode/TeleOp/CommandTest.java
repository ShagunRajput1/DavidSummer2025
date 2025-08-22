package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Choreo.DepositPrep;
import org.firstinspires.ftc.teamcode.Commands.Choreo.DropToBucket1;
import org.firstinspires.ftc.teamcode.Commands.Choreo.DropToBucket2;
import org.firstinspires.ftc.teamcode.Commands.Choreo.PickUpSample;
import org.firstinspires.ftc.teamcode.David;
import org.firstinspires.ftc.teamcode.util.Logger;

@TeleOp(name = "Command Test")
public class CommandTest extends LinearOpMode {
        @Override
        public void runOpMode() throws InterruptedException {
            David.init(hardwareMap, gamepad1, gamepad2);
            Logger.init("teleop_log.txt");
            Logger.log("CommandTest LinearOpMode started");
            DepositPrep depositPrep = new DepositPrep(David.arm, David.wrist, gamepad1);
            DropToBucket1 dropToBucket1 = new DropToBucket1(David.outtakeSlides, David.claw, David.wrist, David.arm, gamepad1);
            DropToBucket2 dropToBucket2 = new DropToBucket2(David.outtakeSlides, David.claw, David.wrist, David.arm, gamepad1);
            PickUpSample pickUpSample = new PickUpSample(David.outtakeSlides, David.arm, David.wrist, David.claw, gamepad1, telemetry);

            waitForStart();
            if (isStopRequested()) return;

            while (opModeIsActive()) {
                depositPrep.runRoutine();
                dropToBucket1.runRoutine();
                dropToBucket2.runRoutine();
                pickUpSample.runRoutine();
                telemetry.addData("", David.outtakeSlides.telemetry());
                telemetry.addData("", David.arm.telemetry());
                telemetry.addData("", David.wrist.telemetry());
                telemetry.update();
            }
        }
    }

