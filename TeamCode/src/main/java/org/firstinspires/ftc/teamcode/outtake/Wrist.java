package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private final Servo wrist;
    Gamepad gamepad2;

    double PICK_UP = 0.73;
    double DROP_OFF = 0.1589;
    public Wrist(HardwareMap hardwareMap, Gamepad gamepad2) {
        wrist = hardwareMap.get(Servo.class, "wrist");

        this.gamepad2 = gamepad2;
    }
//    public void move(){
//        if(gamepad2.dpad_left){
//            wrist.setPosition(0.1589);
//        } else if(gamepad2.dpad_right) {
//            wrist.setPosition(0.73);
//        }
//    }

    public void toPickUp(){
        wrist.setPosition(PICK_UP);
    }

    public void toDropOff(){
        wrist.setPosition(DROP_OFF);
    }

    public String telemetry(){
        return "wrist pos: " + wrist.getPosition();
    }
}
