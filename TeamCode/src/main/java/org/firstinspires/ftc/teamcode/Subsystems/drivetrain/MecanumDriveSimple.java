package org.firstinspires.ftc.teamcode.Subsystems.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDriveSimple {

    private final DcMotorEx frontLeft;
    private final DcMotorEx frontRight;
    private final DcMotorEx backLeft;
    private final DcMotorEx backRight;

    private double speed, turn, strafe;

    public MecanumDriveSimple(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotorEx.class, "fl");
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontRight = hardwareMap.get(DcMotorEx.class, "fr");
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backLeft = hardwareMap.get(DcMotorEx.class, "bl");
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRight = hardwareMap.get(DcMotorEx.class, "br");
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        backLeft.setDirection(DcMotorEx.Direction.REVERSE);
        frontRight.setDirection(DcMotorEx.Direction.FORWARD);
        backRight.setDirection(DcMotorEx.Direction.FORWARD);
    }
    public void drive(Gamepad gamepad1, Telemetry telemetry){

        speed = -gamepad1.left_stick_y;
        turn = gamepad1.left_stick_x;
        strafe = gamepad1.right_stick_x;

        frontLeft.setPower(speed + turn + strafe);
        frontRight.setPower(speed - turn - strafe);
        backLeft.setPower(speed + turn - strafe);
        backRight.setPower(speed - turn + strafe);

        telemetry.addData("Front left Power", frontLeft.getPower());
        telemetry.addData("Front right Power", frontRight.getPower());
        telemetry.addData("Back left Power", backLeft.getPower());
        telemetry.addData("Back right Power", backRight.getPower());
        telemetry.update();
    }
}