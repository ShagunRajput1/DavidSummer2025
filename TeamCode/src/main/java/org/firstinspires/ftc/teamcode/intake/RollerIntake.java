package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RollerIntake {
    private final DcMotorEx roller;
    private final Gamepad gamepad1;

    int SPIN_IN = -1;
    int SPIN_OUT = 1;

    public RollerIntake(HardwareMap hardwareMap, Gamepad gamepad1) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");

       this.gamepad1 = gamepad1;
    }

    public void spin(){
        if(gamepad1.right_bumper){
            roller.setPower(SPIN_IN);
        } else if(gamepad1.left_bumper){
            roller.setPower(SPIN_OUT);
        }else {
            roller.setPower(0);
        }
    }

    public void rollIn(){
        roller.setPower(SPIN_IN);
    }

    public void rollOut(){
        roller.setPower(SPIN_OUT);
    }
}
