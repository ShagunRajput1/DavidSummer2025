package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.MecanumDriveFC;

@TeleOp(name = "Field Centric")
public class DriveTest extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException{
        MecanumDriveFC mecanumDriveFC = new MecanumDriveFC(hardwareMap);

        waitForStart();
        if (isStopRequested()){ return;}

        while(opModeIsActive()){
            mecanumDriveFC.driveFC(gamepad1);
        }
    }
}
