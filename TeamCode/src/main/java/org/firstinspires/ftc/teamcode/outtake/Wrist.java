package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private final Servo wrist;
    Gamepad gamepad;
    public Wrist(HardwareMap hardwareMap, Gamepad gamepad) {
        wrist = hardwareMap.get(Servo.class, "wrist");

        this.gamepad = gamepad;
    }
    public void move(){
        if(gamepad.dpad_left){
            wrist.setPosition(0.1589);
        } else if(gamepad.dpad_right) {
            wrist.setPosition(0.73);
        }
    }
    public String telemetry(){
        return "wrist pos: " + wrist.getPosition();
    }
}
