package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Chamber {
    private final Servo chamber;
//    private boolean isLifted = false;
//    private boolean lastAState = false;
    public Chamber(HardwareMap hardwareMap){
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(0.1);
    }
    public void liftChamber(Gamepad gamepad1){
        if (gamepad1.a){
            if (chamber.getPosition() == 0.1){
                chamber.setPosition(0.5);
            } else{
                chamber.setPosition(0.1);
            }
        }
//        boolean currentAState = gamepad1.a;
//
//        if (currentAState && !lastAState) {
//            isLifted = !isLifted;
//            chamber.setPosition(isLifted ? 0.1 : 0.5);
//        }
//
//        lastAState = currentAState; // Store the current state for the next loop

      /*
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
    }

}
