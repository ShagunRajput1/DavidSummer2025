package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDriveEx {

    private DcMotorEx frontLeft;
    private DcMotorEx frontRight;
    private DcMotorEx backLeft;
    private DcMotorEx backRight;

    private double speed, turn, strafe;

    public MecanumDriveEx(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotorEx.class, "fl");
        frontRight = hardwareMap.get(DcMotorEx.class, "fr");
        backLeft = hardwareMap.get(DcMotorEx.class, "bl");
        backRight = hardwareMap.get(DcMotorEx.class, "br");

        frontRight.setDirection(DcMotorEx.Direction.REVERSE);
    }
    public void drive(Gamepad gamepad1, Telemetry telemetry){

        // speed and strafe on left stick; turn on right stick; it got weird sorry
        speed = gamepad1.left_stick_y;
        turn = -gamepad1.left_stick_x;
        strafe = -gamepad1.right_stick_x;

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
