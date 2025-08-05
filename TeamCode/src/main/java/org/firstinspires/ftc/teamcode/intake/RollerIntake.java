package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RollerIntake {
    private final DcMotorEx roller;
    private Gamepad gamepad1;

    public RollerIntake(HardwareMap hardwareMap, Gamepad gamepad1) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");
       this.gamepad1 = gamepad1;
    }

    public void roller(){
        if(gamepad1.right_bumper){
            roller.setPower(-1);
        } else if(gamepad1.left_bumper){
            roller.setPower(1);
        }else {
            roller.setPower(0);
        }
    }
}
