package org.firstinspires.ftc.teamcode.opmode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Group.ChamberRoutine;
import org.firstinspires.ftc.teamcode.drivetrain.MecanumDriveEx;
import org.firstinspires.ftc.teamcode.intake.Chamber;
import org.firstinspires.ftc.teamcode.intake.RollerIntake;

@TeleOp
public class seqChamber extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDriveEx mecanumDrive = new MecanumDriveEx(hardwareMap, gamepad1);
        RollerIntake roller = new RollerIntake(hardwareMap);
        Chamber chamber = new Chamber(hardwareMap);

        ChamberRoutine chamberRoutine = new ChamberRoutine(chamber, roller, gamepad1);

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
            mecanumDrive.drive();
            chamberRoutine.runRoutine();

        }
    }
}
