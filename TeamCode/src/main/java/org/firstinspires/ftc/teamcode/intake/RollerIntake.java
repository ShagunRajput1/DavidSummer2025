package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RollerIntake {
    private final DcMotorEx roller;
    private final Gamepad gamepad;

    public RollerIntake(HardwareMap hardwareMap, Gamepad gamepad) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");

       this.gamepad = gamepad;
    }

    public void spin(){
        if(gamepad.right_bumper){
            roller.setPower(-1);
        } else if(gamepad.left_bumper){
            roller.setPower(1);
        }else {
            roller.setPower(0);
        }
    }
}
