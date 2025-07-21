package org.firstinspires.ftc.teamcode.drivetrain;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class MecanumDriveEx {

    private final DcMotorEx frontLeft;
    private final DcMotorEx frontRight;
    private final DcMotorEx backLeft;
    private final DcMotorEx backRight;

    private double y, turn, x;
    private double power, sin, cos, max;
    private double theta;

    public MecanumDriveEx(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotorEx.class, "fl");
        frontRight = hardwareMap.get(DcMotorEx.class, "fr");
        backLeft = hardwareMap.get(DcMotorEx.class, "bl");
        backRight = hardwareMap.get(DcMotorEx.class, "br");

        frontRight.setDirection(DcMotorEx.Direction.REVERSE);
        backLeft.setDirection(DcMotorEx.Direction.REVERSE);
    }
    public void drive(Gamepad gamepad1){

        // speed and strafe on left stick; turn on right stick; it got weird sorry
        x = -gamepad1.right_stick_x;
        y = gamepad1.left_stick_y;
        turn = -gamepad1.left_stick_x;

        theta = Math.atan2(y,x);
        power = Math.hypot(x,y);

        sin = Math.sin(theta - Math.PI/4);
        cos = Math.cos(theta - Math.PI/4);
        max = Math.max(Math.abs(sin), Math.abs(cos));  // scales power

       double frontLeftPower = power * cos/max + turn;
       double frontRightPower = power * sin/max - turn;
       double backLeftPower = power * sin/max + turn;
        double backRightPower = power * sin/max - turn;

        if(power + Math.abs(turn) > 1) {
            frontLeftPower /= power + turn;
            frontRightPower /= power + turn;
            backLeftPower /= power + turn;
            backRightPower /= power + turn;
        }


        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);

       /**
        telemetry.addData("Front left Power", frontLeft.getPower());
        telemetry.addData("Front right Power", frontRight.getPower());
        telemetry.addData("Back left Power", backLeft.getPower());
        telemetry.addData("Back right Power", backRight.getPower());
        telemetry.update();

        */
    }
}
