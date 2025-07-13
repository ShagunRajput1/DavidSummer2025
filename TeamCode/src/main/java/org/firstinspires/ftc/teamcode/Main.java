package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDriveSimple mecanumDrive = new MecanumDriveSimple(hardwareMap);

        waitForStart(); // initialising code will be entered before; if nothing then have to start to start code
        while(opModeIsActive()){
            mecanumDrive.drive(gamepad1, telemetry);
        }
    }


}
