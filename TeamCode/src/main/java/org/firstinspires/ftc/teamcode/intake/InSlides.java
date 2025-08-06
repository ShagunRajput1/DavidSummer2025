package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class InSlides {
    public DcMotorEx intakeSlides;
    private final Gamepad gamepad;

    public InSlides(HardwareMap hardwareMap, Gamepad gamepad) {
        intakeSlides = hardwareMap.get(DcMotorEx.class, "inSlides");

        intakeSlides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeSlides.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeSlides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Important for holding

        this.gamepad = gamepad;
    }

    public void extend() {
        if (gamepad.right_trigger > 0.05) {
            intakeSlides.setPower(gamepad.right_trigger);
        } else if (gamepad.left_trigger > 0.05) {
            intakeSlides.setPower(-gamepad.left_trigger);
        } else {
            intakeSlides.setPower(0);
        }
    }

    public String telemetry() {
        return "Intake slides pos: " + intakeSlides.getCurrentPosition();
    }
}