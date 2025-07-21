package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RollerIntake {
    private DcMotorEx roller;

    public RollerIntake(HardwareMap hardwareMap) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");
    }

    public void roller(Gamepad gamepad1){
        if(gamepad1.right_bumper){
            roller.setPower(1);
        } else {
            roller.setPower(0);
        }
    }
}
