package org.firstinspires.ftc.teamcode.pidTuning;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.outtake.OutSlides;

@Config
@TeleOp
public class SlidesTuning extends LinearOpMode{

    public static double p, i, d;
    public static int targetpos;

    @Override
    public void runOpMode() throws InterruptedException{
        OutSlides outSlides = new OutSlides(hardwareMap, gamepad2);
        waitForStart();
        while(opModeIsActive()){
            outSlides.setPID(p, i, d);
            outSlides.setTarPos(targetpos);
            outSlides.update();
        }

    }

}