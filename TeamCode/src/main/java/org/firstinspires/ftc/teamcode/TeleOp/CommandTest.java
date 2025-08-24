package org.firstinspires.ftc.teamcode.TeleOp;

import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Choreo.ChamberIntake;
import org.firstinspires.ftc.teamcode.Commands.Choreo.DropToBucket1;
import org.firstinspires.ftc.teamcode.Commands.Choreo.DropToBucket2;
import org.firstinspires.ftc.teamcode.Commands.Choreo.PickUpPrep;
import org.firstinspires.ftc.teamcode.Commands.Choreo.PickUpSample;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket1;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket2;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos0;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.David;
import org.firstinspires.ftc.teamcode.util.Logger;

@TeleOp(name = "Command Test")
public class CommandTest extends LinearOpMode {
        @Override
        public void runOpMode() throws InterruptedException {
            David.init(hardwareMap, gamepad1, gamepad2);

            Logger.init("teleop_log.txt");
            Logger.log("CommandTest LinearOpMode started");

            DropToBucket1 dropToBucket1 = new DropToBucket1(gamepad1);
            DropToBucket2 dropToBucket2 = new DropToBucket2(gamepad1);
            PickUpSample pickUpSample = new PickUpSample(gamepad1);
            ChamberIntake chamberIntake = new ChamberIntake(gamepad1);
            PickUpPrep pickUpPrep = new PickUpPrep(gamepad1);

            waitForStart();
            if (isStopRequested()) return;

            while (opModeIsActive()) {

                David.mecanumDrive.drive(); // joysticks
                David.slidesIntake.control(); // triggers, X Button
                chamberIntake.runRoutine(); // A Button
                pickUpPrep.runRoutine(); // Y Button
                pickUpSample.runRoutine(); // B Button
                dropToBucket1.runRoutine(); // Dpad down
                dropToBucket2.runRoutine(); // Dpad Up

                telemetry.addData("", David.outtakeSlides.telemetry());
                telemetry.addData("", David.outtakeSlides.getCurrentPosition());
                telemetry.addData("Outtake Slides Target Position", David.outtakeSlides.getTargetPosition());
                telemetry.addData("", David.arm.telemetry());
                telemetry.addData("", David.wrist.telemetry());
                telemetry.update();
            }
        }
    }

