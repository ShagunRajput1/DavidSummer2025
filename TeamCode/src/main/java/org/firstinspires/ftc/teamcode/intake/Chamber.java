package org.firstinspires.ftc.teamcode.intake;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

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
    ToggleButtonReader chamberButton = new ToggleButtonReader(
            new GamepadEx(gamepad1), GamepadKeys.Button.A);

    public Chamber(HardwareMap hardwareMap) {
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(chamberUp);
    }
        public void liftChamber(){

            if (chamberButton.wasJustReleased()){
                if (isChamberUp){
                    chamber.setPosition(chamberDown);
                    }
                else {
                    chamber.setPosition(chamberUp);
                }
                isChamberUp = !isChamberUp;
                }
            chamberButton.readValue();
        }
    }