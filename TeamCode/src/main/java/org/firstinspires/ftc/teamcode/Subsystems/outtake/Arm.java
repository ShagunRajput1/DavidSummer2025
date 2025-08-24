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

    double tolerance = 0.002;


    double arm1Up = 0.0561;
    double arm2Up = .9433;
    double arm1Down = .8828;
    double arm2Down = .1167;

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

    public double getFirstPosition() {
        return arm1.getPosition();
    }

    public double getSecondPosition() {
        return arm2.getPosition();
    }

//    public boolean atDownPosition(){
//        boolean firstAtTarget = Math.abs(arm1.getPosition() - arm1Down) < tolerance;
//        boolean secondAtTarget = Math.abs(arm2.getPosition() - arm2Down) < tolerance;
//
//        return firstAtTarget && secondAtTarget;
//    }
//
//    public boolean atUpPosition() {
//        boolean firstAtTarget = Math.abs(arm1.getPosition() - arm1Up) < tolerance;
//        boolean secondAtTarget = Math.abs(arm2.getPosition() - arm2Up) < tolerance;
//
//        return firstAtTarget && secondAtTarget;
//    }
}