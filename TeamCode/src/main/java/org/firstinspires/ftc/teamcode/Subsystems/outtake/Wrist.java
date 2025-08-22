package org.firstinspires.ftc.teamcode.Subsystems.outtake;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Wrist {
    private final Servo wrist;
    double PICK_UP = .3838;
    double DROP_OFF = .6417;

    boolean isWristAtPickUp = false;

    ToggleButtonReader wristButton;


    public Wrist(HardwareMap hardwareMap, Gamepad gamepad) {

        wrist = hardwareMap.get(Servo.class, "wrist");
        wristButton = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.X);

        wrist.setPosition(DROP_OFF);
    }

    public void control() {

        wristButton.readValue();

        if (wristButton.wasJustReleased()) {
            if (isWristAtPickUp) {
                wrist.setPosition(DROP_OFF);
            } else {
                wrist.setPosition(PICK_UP);
            }
            isWristAtPickUp = !isWristAtPickUp;
        }
    }

    public void toPickUp(){
        wrist.setPosition(PICK_UP);
        isWristAtPickUp = true;
    }

    public void toDropOff(){
        wrist.setPosition(DROP_OFF);
        isWristAtPickUp = false;
    }

    public String telemetry(){
        return "wrist pos: " + wrist.getPosition();
    }
}
