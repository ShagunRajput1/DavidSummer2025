package org.firstinspires.ftc.teamcode.Subsystems.outtake;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private final Servo claw;

    double clawOpen = 0.25;
    double clawClose = 0;
    boolean isClawOpen = false;
    ToggleButtonReader clawButton;

    public Claw(HardwareMap hardwareMap, Gamepad gamepad) {
        claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(clawClose);

        clawButton = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.B);
    }

    public void control() {

        clawButton.readValue();

        if (clawButton.wasJustReleased()) {
            if (isClawOpen) {
                claw.setPosition(clawClose);
            } else {
                claw.setPosition(clawOpen);
            }
            isClawOpen = !isClawOpen;
        }
    }
        public void openClaw () {
            claw.setPosition(clawOpen);
        }

        public void closeClaw () {
            claw.setPosition(clawClose);
        }

        public String telemetry () {
            return "claw pos: " + claw.getPosition();
        }
    }
