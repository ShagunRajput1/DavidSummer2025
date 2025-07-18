package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private Servo wrist;

    public Wrist(HardwareMap hardwareMap) {
        wrist = hardwareMap.get(Servo.class, "wrist");
    }
    public void wristMovement(Gamepad gamepad1){
        if(gamepad1.dpad_left){
            wrist.setPosition(1);
        } else if(gamepad1.dpad_right) {
            wrist.setPosition(0);
        }
    }
}
