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
        MecanumDriveEx mecanumDrive = new MecanumDriveEx(hardwareMap, gamepad1);
        RollerIntake rollerIntake = new RollerIntake(hardwareMap, gamepad1);
        Slides slidesIntake = new Slides(hardwareMap, gamepad1);
        Chamber chamberLift = new Chamber(hardwareMap, gamepad1);
        OutSlides slidesOuttake = new OutSlides(hardwareMap, gamepad2);
        Arm armMovement = new Arm(hardwareMap, gamepad2);
        Claw clawMovement = new Claw(hardwareMap, gamepad2);
        Wrist wristMovement = new Wrist(hardwareMap, gamepad2);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()){
            mecanumDrive.drive();
            rollerIntake.roller();
            slidesIntake.intakeSlides();
            slidesOuttake.outtakeSlides();
            chamberLift.liftChamber();
            armMovement.moveArm();
            clawMovement.clawMovement();
            wristMovement.wristMovement();


            telemetry.addData("", slidesIntake.telemetry());
            telemetry.addData("", slidesOuttake.telemetry());
            telemetry.addData("", chamberLift.telemetry());
            telemetry.addData("", armMovement.telemetry());
            telemetry.addData("", clawMovement.telemetry());
            telemetry.addData("", wristMovement.telemetry());
            telemetry.update();
        }
    }
}
