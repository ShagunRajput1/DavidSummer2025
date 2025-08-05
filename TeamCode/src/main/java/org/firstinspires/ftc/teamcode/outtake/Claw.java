package org.firstinspires.ftc.teamcode.outtake;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private final Servo claw;
    double clawOpen = 0;
    double clawClose = 1;
    boolean isClawOpen = true;
    ToggleButtonReader clawButton;

    public Claw(HardwareMap hardwareMap, Gamepad gamepad2) {
        claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(clawOpen);

        clawButton = new ToggleButtonReader(
                new GamepadEx(gamepad2), GamepadKeys.Button.B);
    }

    public void clawMovement() {
        if (clawButton.wasJustReleased()) {
            if (isClawOpen) {
                claw.setPosition(clawClose);
            } else {
                claw.setPosition(clawOpen);
            }
            isClawOpen = !isClawOpen;
        }
        clawButton.readValue();
    }
    public String telemetry(){
        return "claw pos: " + claw.getPosition();
    }
}
