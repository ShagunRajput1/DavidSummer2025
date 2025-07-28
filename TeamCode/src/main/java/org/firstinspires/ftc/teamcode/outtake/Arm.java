package org.firstinspires.ftc.teamcode.outtake;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private Servo arm1;
    private Servo arm2;

    public Arm(HardwareMap hardwareMap) {
        arm1 = hardwareMap.get(Servo.class, "arm1");
        arm2 = hardwareMap.get(Servo.class, "arm2");

        arm2.setDirection(Servo.Direction.REVERSE);

        arm1.setPosition(.2072);
        arm1.setPosition(.2072);

    }

    public void moveArm(Gamepad gamepad2) {
        if (gamepad2.a) {
            if(arm1.getPosition() == .2072) {
                arm1.setPosition(.8748);
                arm2.setPosition(.8748);
            }
            else{
                arm1.setPosition(.2072);
                arm2.setPosition(.2072);
            }
        }

        sleep(100);

//        telemetry.addData("ARM1 POSITION: ", arm1.getPosition());
//        telemetry.addData("ARM2 POSITION: ", arm2.getPosition());
//        telemetry.update();
    }
}
