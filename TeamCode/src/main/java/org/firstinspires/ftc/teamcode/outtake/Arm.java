package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm  {
    private final Servo arm1;
    private final Servo arm2;


    double armUp = .2072;
    double armDown = .8748;

    public Arm(HardwareMap hardwareMap) {
        arm1 = hardwareMap.get(Servo.class, "arm1");
        arm2 = hardwareMap.get(Servo.class, "arm2");

        arm2.setDirection(Servo.Direction.REVERSE);

        arm1.setPosition(armUp);
        arm2.setPosition(armUp);
    }
    public void setArmUp(){
        arm1.setPosition(armUp);
        arm2.setPosition(armUp);
    }

    public void setArmDown(){
        arm1.setPosition(armDown);
        arm2.setPosition(armDown);
    }

    public String telemetry() {
        return "arm1 pos: " + arm1.getPosition();
    }
}