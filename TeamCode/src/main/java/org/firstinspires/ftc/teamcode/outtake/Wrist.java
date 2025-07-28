package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Wrist {
    private Servo wrist;

    public Wrist(HardwareMap hardwareMap) {
        wrist = hardwareMap.get(Servo.class, "wrist");
    }
    public void wristMovement(Gamepad gamepad2, Telemetry telemetry){
        if(gamepad2.dpad_left){
            wrist.setPosition(0.1589);
        } else if(gamepad2.dpad_right) {
            wrist.setPosition(0.73);
        }

        telemetry.addData("wrist pos: ", wrist.getPosition());
        telemetry.update();
    }


}
