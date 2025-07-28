package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "servo test")
public class servoTest extends LinearOpMode {

    Servo servo;

    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.get(Servo.class, "servo");

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad1.a) {
                servo.setPosition(1);
            } else if (gamepad1.b) {
                servo.setPosition(0.5);
            } else {
                servo.setPosition(0);
            }

            telemetry.addData("chamber position:", servo.getPosition());
            telemetry.update();
        }
    }
}
