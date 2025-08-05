package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slides {
    public DcMotorEx intakeSlides;
    private Gamepad gamepad1;

    public Slides(HardwareMap hardwareMap, Gamepad gamepad1) {
        intakeSlides = hardwareMap.get(DcMotorEx.class, "inSlides");

        intakeSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Important for holding

        this.gamepad1 = gamepad1;
    }

    public void intakeSlides() {
        if (gamepad1.right_trigger > 0.05) {
            intakeSlides.setPower(gamepad1.right_trigger);
        } else if (gamepad1.left_trigger > 0.05) {
            intakeSlides.setPower(-gamepad1.left_trigger);
        } else {
            intakeSlides.setPower(0);
        }
    }
    public String telemetry(){
        return "Intake slides pos: " + intakeSlides.getCurrentPosition();
    }
}