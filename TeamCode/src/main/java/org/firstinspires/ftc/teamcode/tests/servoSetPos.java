package org.firstinspires.ftc.teamcode.tests;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Subsystems.intake.Chamber;
import org.firstinspires.ftc.teamcode.Subsystems.intake.InSlides;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

@Config
@TeleOp(name = "Setting Position" )
public class servoSetPos extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        Servo chamber = hardwareMap.get(Servo.class, "chamber");
        Servo arm1 = hardwareMap.get(Servo.class, "arm1");
        Servo arm2 = hardwareMap.get(Servo.class, "arm2");
        Servo wrist = hardwareMap.get(Servo.class, "wrist");
        Servo claw  = hardwareMap.get(Servo.class, "claw");
        InSlides intake = new InSlides(hardwareMap, gamepad1);
        OutSlides outtake = new OutSlides(hardwareMap, gamepad1);

        chamber.setPosition(0);
        arm1.setPosition(1);
        arm2.setPosition(0);
        wrist.setPosition(0);
        claw.setPosition(0);

        waitForStart();

        while(opModeIsActive()) {

            if(gamepad1.a){ // chamber
                if (gamepad1.dpad_up){
                    chamber.setPosition(chamber.getPosition() + 0.001);
                } else if (gamepad1.dpad_down){
                    chamber.setPosition((chamber.getPosition()) + 0.001);
                }
            }else if(gamepad1.b){ // arms
                if (gamepad1.dpad_up){
                    arm2.setPosition((arm2.getPosition()) + 0.001);
                    arm1.setPosition(1 - arm2.getPosition());
                } else if(gamepad1.dpad_down){
                    arm2.setPosition((arm2.getPosition()) - 0.001);
                    arm1.setPosition(1 - arm2.getPosition());
                }
            } else if(gamepad1.x){ // wrist
                if (gamepad1.dpad_up){
                    wrist.setPosition(wrist.getPosition() + 0.001);
                } else if (gamepad1.dpad_down){
                    wrist.setPosition(wrist.getPosition() - 0.001);
                }
            } else if(gamepad1.y){ // claw
                if (gamepad1.dpad_up){
                    claw.setPosition(claw.getPosition() + 0.001);
                } else if(gamepad1.dpad_down){
                    claw.setPosition(claw.getPosition() - 0.001);
                }
            }

            telemetry.addData("chamber position", chamber.getPosition());
            telemetry.addData("arm1 position", arm1.getPosition());
            telemetry.addData("arm2 position", arm2.getPosition());
            telemetry.addData("wrist position", wrist.getPosition());
            telemetry.addData("claw position", claw.getPosition());
            telemetry.addData("intake slides position: ", intake.telemetry());
            telemetry.addData("outtake slides position", outtake.telemetry());
            telemetry.update();

        }
    }
}
