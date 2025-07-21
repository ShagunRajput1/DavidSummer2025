package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.drivetrain.MecanumDriveEx;
import org.firstinspires.ftc.teamcode.intake.Chamber;
import org.firstinspires.ftc.teamcode.intake.RollerIntake;
import org.firstinspires.ftc.teamcode.intake.Slides;
import org.firstinspires.ftc.teamcode.outtake.Arm;
import org.firstinspires.ftc.teamcode.outtake.Claw;
import org.firstinspires.ftc.teamcode.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.outtake.Wrist;

@TeleOp
public class Main extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDriveEx mecanumDrive = new MecanumDriveEx(hardwareMap);
        RollerIntake rollerIntake = new RollerIntake(hardwareMap);
        Slides slidesIntake = new Slides(hardwareMap);
        Chamber chamberLift = new Chamber(hardwareMap);
        OutSlides slidesOuttake = new OutSlides(hardwareMap);
        Arm armMovement = new Arm(hardwareMap);
        Claw clawMovement = new Claw(hardwareMap);
        Wrist wristMovement = new Wrist(hardwareMap);

        waitForStart();

        // initialising code will be entered before; if nothing then have to start to start code


        while(opModeIsActive()){
            mecanumDrive.drive(gamepad1);
            rollerIntake.roller(gamepad1);
            slidesIntake.intakeSlides(gamepad1);
            chamberLift.liftChamber(gamepad1);
            slidesOuttake.outtakeSlides(gamepad1);
            armMovement.moveArm(gamepad2, telemetry);
            clawMovement.clawMovement(gamepad1);
            wristMovement.wristMovement(gamepad1);
        }
    }
}
