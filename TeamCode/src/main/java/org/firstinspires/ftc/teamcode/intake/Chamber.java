package org.firstinspires.ftc.teamcode.intake;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Chamber {
    Servo chamber;
    double chamberUp = 0.1;
    double chamberDown = 0.5;

    public Chamber(HardwareMap hardwareMap) {
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(chamberUp);
    }

    public String telemetry() {
        return "chamber pos: " + chamber.getPosition();
    }

    public void setChamberDown() {
        chamber.setPosition(chamberDown);
    }

    public void setChamberUp() {
        chamber.setPosition(chamberUp);
    }
}