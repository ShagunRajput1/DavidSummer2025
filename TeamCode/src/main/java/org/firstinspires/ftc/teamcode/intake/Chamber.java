package org.firstinspires.ftc.teamcode.intake;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Chamber {
    private final Servo chamber;

    public Chamber(HardwareMap hardwareMap){
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(0);
    }

    public void liftChamber(Gamepad gamepad1){
        //get position
        //telemetry.addData("Initial Servo Position", chamber.getPosition());

        if(gamepad1.a) {
            if(chamber.getPosition() == 0) {
                chamber.setPosition(0.5);
            } else {
                chamber.setPosition(0);
            }
           // telemetry.addData("Servo position", "Pressed A");
        }
        /*
        else if(gamepad1.b) {
            chamber.setPosition(0.2);
            telemetry.addData("Servo position", "B");
        }
       else if(gamepad1.x) {
            chamber.setPosition(0.5);
            telemetry.addData("Servo position", "X");
        }*/

       /* telemetry.addData("Final Servo Position", chamber.getPosition());
        telemetry.update();  */

        sleep(50);
    }

}
