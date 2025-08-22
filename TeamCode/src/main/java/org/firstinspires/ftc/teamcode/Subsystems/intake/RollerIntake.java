package org.firstinspires.ftc.teamcode.Subsystems.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RollerIntake {
    private final DcMotorEx roller;

    int SPIN_IN = -1;
    int SPIN_OUT = 1;

    Gamepad gamepad;

    public RollerIntake(HardwareMap hardwareMap, Gamepad gamepad) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");
       this.gamepad = gamepad;
    }

    public void control(){
        if(gamepad.right_bumper){
            roller.setPower(SPIN_IN);
        } else if(gamepad.left_bumper){
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

    public void stop() {
        roller.setPower(0);
    }
}
