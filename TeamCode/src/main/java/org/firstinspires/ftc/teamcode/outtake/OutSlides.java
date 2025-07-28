package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OutSlides {
    private final DcMotorEx outtakeSlide1;
    private final DcMotorEx outtakeSlide2;

    public OutSlides(HardwareMap hardwareMap){
        outtakeSlide1 = hardwareMap.get(DcMotorEx.class, "outSlide1");
        outtakeSlide2 = hardwareMap.get(DcMotorEx.class, "outSlide2");

        outtakeSlide1.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public void outtakeSlides(Gamepad gamepad2){
        if(gamepad2.dpad_up){
            outtakeSlide1.setPower(0.7);
            outtakeSlide2.setPower(0.7);
        } else if(gamepad2.dpad_down) {
            outtakeSlide1.setPower(-0.7);
            outtakeSlide2.setPower(-0.7);
        } else {
            outtakeSlide1.setPower(0);
            outtakeSlide2.setPower(0);
        }
    }
}
