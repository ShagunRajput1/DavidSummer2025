package org.firstinspires.ftc.teamcode.Subsystems.outtake;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private final Servo arm1;
    private final Servo arm2;


    double arm1Up = 0.0561;
    double arm2Up = .9433;
    double arm1Down = .8889;
    double arm2Down = .1106;

    ToggleButtonReader armButton;

    boolean isArmUp = true;

    public Arm(HardwareMap hardwareMap, Gamepad gamepad) {
        arm1 = hardwareMap.get(Servo.class, "arm1");
        arm2 = hardwareMap.get(Servo.class, "arm2");

        arm1.setPosition(arm1Up);
        arm2.setPosition(arm2Up);

        armButton = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.A);
    }

    public void control() {

        armButton.readValue();

        if (armButton.wasJustReleased()) {
            if (isArmUp) {
                arm1.setPosition(arm1Down);
                arm2.setPosition(arm2Down);
            } else {
                arm1.setPosition(arm1Up);
                arm2.setPosition(arm2Up);
            }
            isArmUp = !isArmUp;
        }
    }


    public void setArmUp() {
        arm1.setPosition(arm1Up);
        arm2.setPosition(arm2Up);
        isArmUp = true;
    }

    public void setArmDown() {
        arm1.setPosition(arm1Down);
        arm2.setPosition(arm2Down);
        isArmUp = false;
    }

    public String telemetry() {
        return "arm1 pos: " + arm1.getPosition() +
                "\narm2 pos: " + arm2.getPosition();
    }
}