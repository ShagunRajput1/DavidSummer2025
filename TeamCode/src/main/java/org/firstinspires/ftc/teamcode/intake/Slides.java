package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Slides {
    private DcMotorEx intakeSlides;
    private Servo chamber;

    public Slides(HardwareMap hardwareMap){
        intakeSlides = hardwareMap.get(DcMotorEx.class, "inSlides");
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(-0.7);
    }

    public void intakeSlides(Gamepad gamepad1){
        if(gamepad1.right_trigger > 0){
            intakeSlides.setPower(gamepad1.right_trigger);
        } else if(gamepad1.left_trigger > 0) {
            intakeSlides.setPower(-gamepad1.left_trigger);
        } else {
            intakeSlides.setPower(0);
        }
    }

    public void chamber(Gamepad gamepad1, Telemetry telemetry){
        //getpostion
        if((chamber.getPosition()== -0.7) && (gamepad1.a) ) {
            chamber.setPosition(-0.9);
        } else if ((chamber.getPosition()==-0.9) && (gamepad1.a)){
            chamber.setPosition(-0.7);
        }

        telemetry.addData("Servo Position", chamber.getPosition());
        telemetry.update();
    }

}

