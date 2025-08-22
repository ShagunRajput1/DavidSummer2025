package org.firstinspires.ftc.teamcode.tests;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

@Config
@TeleOp
public class SlidesTuning extends LinearOpMode{

    public static double p, i, d;
    public static int target;

    @Override
    public void runOpMode() throws InterruptedException{
        OutSlides slides = new OutSlides(hardwareMap, gamepad1);
        waitForStart();
        while(opModeIsActive()){
            slides.setPID(p, i, d);
            slides.setTargetPos(target);
            slides.update();
            telemetry.addData("", slides.telemetry());
            telemetry.update();
        }
    }
}