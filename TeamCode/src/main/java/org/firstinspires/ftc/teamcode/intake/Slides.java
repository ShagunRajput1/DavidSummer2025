package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Slides {
    public DcMotorEx intakeSlides;
    public int targetPos;

    public Slides(HardwareMap hardwareMap) {
        intakeSlides = hardwareMap.get(DcMotorEx.class, "inSlides");

        intakeSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Important for holding

        targetPos = 0;
    }

    public void intakeSlides(Gamepad gamepad1) {
        if (gamepad1.right_trigger > 0.05) {
            intakeSlides.setPower(gamepad1.right_trigger);
        } else if (gamepad1.left_trigger > 0.05) {
            intakeSlides.setPower(-gamepad1.left_trigger);
        } else {
            intakeSlides.setPower(0);
        }


    }
}