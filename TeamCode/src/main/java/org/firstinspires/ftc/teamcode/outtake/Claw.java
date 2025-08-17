package org.firstinspires.ftc.teamcode.outtake;


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

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(clawOpen);
    }

    public void openClaw(){
        claw.setPosition(clawOpen);
    }

    public void closeClaw(){
        claw.setPosition(clawClose);
    }

    public String telemetry(){
        return "claw pos: " + claw.getPosition();
    }
}
