package org.firstinspires.ftc.teamcode.outtake;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo claw;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(0);
    }

    public void clawMovement(Gamepad gamepad1) {
        if (gamepad1.b) {
            if (claw.getPosition() == 0) {
                claw.setPosition(1);
            } else {
                claw.setPosition(0);
            }
            sleep(50);
        }
    }
}
