package org.firstinspires.ftc.teamcode.tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "motorTest")
public class motorTest extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException{
        DcMotor motor = hardwareMap.get(DcMotor.class, "br");

        waitForStart();

        while (opModeIsActive()){

                if (gamepad1.a) {
                    motor.setPower(1);
                } else if (gamepad1.b) {
                    motor.setPower(-1);
                } else {
                    motor.setPower(0);
                }

                telemetry.addData("motor pos: ", motor.getCurrentPosition());
                telemetry.update();
            }
        }
    }
