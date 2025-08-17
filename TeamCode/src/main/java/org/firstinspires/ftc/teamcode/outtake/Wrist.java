package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private final Servo wrist;
    double PICK_UP = 0.73;
    double DROP_OFF = 0.1589;
    public Wrist(HardwareMap hardwareMap) {
        wrist = hardwareMap.get(Servo.class, "wrist");
    }

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
