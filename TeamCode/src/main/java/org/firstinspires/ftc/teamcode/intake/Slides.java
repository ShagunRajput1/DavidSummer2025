package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Slides {
    private final DcMotorEx intakeSlides;

    public Slides(HardwareMap hardwareMap) {
        intakeSlides = hardwareMap.get(DcMotorEx.class, "inSlides");
    }

    public void intakeSlides(Gamepad gamepad1) {
        if (gamepad1.right_trigger > 0) {
            intakeSlides.setPower(gamepad1.right_trigger);
        } else if (gamepad1.left_trigger > 0) {
            intakeSlides.setPower(-gamepad1.left_trigger);
        } else {
            intakeSlides.setPower(0);
        }
    }
}