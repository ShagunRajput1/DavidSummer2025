package org.firstinspires.ftc.teamcode.Tests;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "servoTest" )
public class servoSetPos extends LinearOpMode {

    Servo servo;

    @Override
    public void runOpMode() throws InterruptedException {
        servo = hardwareMap.get(Servo.class, "chamber");

        waitForStart();
        servo.setPosition(0);

        while(opModeIsActive()) {
            if (gamepad1.a){// start
                servo.setPosition(0.5);
            } else if (gamepad1.b){
                servo.setPosition(0);
            }

            telemetry.addData("servo Position:", servo.getPosition());
            telemetry.update();

        }
    }

}
