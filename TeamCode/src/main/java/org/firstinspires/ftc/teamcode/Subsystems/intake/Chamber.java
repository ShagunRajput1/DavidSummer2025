package org.firstinspires.ftc.teamcode.Subsystems.intake;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Chamber {
    Servo chamber;
    double chamberUp = 0;
    double chamberDown = .27;
    boolean isChamberUp = true;
    ToggleButtonReader chamberButton;

    public Chamber(HardwareMap hardwareMap, Gamepad gamepad) {
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(chamberUp);

        chamberButton = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.A);
    }

    public void control(){

        chamberButton.readValue();

        if (chamberButton.wasJustReleased()) {
            if (isChamberUp) {
                chamber.setPosition(chamberDown);
            } else {
                chamber.setPosition(chamberUp);
            }
            isChamberUp = !isChamberUp;
        }
    }

    public void setChamberUp(){
        chamber.setPosition(chamberUp);
        isChamberUp = true;
    }

    public void setChamberDown(){
        chamber.setPosition(chamberDown);
        isChamberUp = false;
    }

    public double getCurrentPosition(){
        return chamber.getPosition();
    }

    public String telemetry() {
        return "chamber pos: " + chamber.getPosition();
    }
}