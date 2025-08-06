package org.firstinspires.ftc.teamcode.intake;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Chamber {
    Servo chamber;

    double chamberUp = 0.1;
    double chamberDown = 0.5;
    boolean isChamberUp = true;

    ToggleButtonReader chamberButton;

    public Chamber(HardwareMap hardwareMap, Gamepad gamepad) {
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(chamberUp);


        chamberButton = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.A);
    }

    public void lift() {

        if (chamberButton.wasJustReleased()) {
            if (isChamberUp) {
                chamber.setPosition(chamberDown);
            } else {
                chamber.setPosition(chamberUp);
            }
            isChamberUp = !isChamberUp;
        }
        chamberButton.readValue();
    }
    public String telemetry() {
        return "chamber pos: " + chamber.getPosition();
    }
}