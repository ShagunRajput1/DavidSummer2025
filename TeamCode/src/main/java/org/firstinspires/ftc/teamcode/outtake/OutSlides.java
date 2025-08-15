package org.firstinspires.ftc.teamcode.outtake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.PIDWrapper;

public class OutSlides {
    private final DcMotorEx outtakeSlide1;
    private final DcMotorEx outtakeSlide2;

   PIDWrapper pid;
    Gamepad gamepad2;

    public OutSlides(HardwareMap hardwareMap, Gamepad gamepad2){
        outtakeSlide1 = hardwareMap.get(DcMotorEx.class, "outSlide1");
        outtakeSlide2 = hardwareMap.get(DcMotorEx.class, "outSlide2");

        outtakeSlide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakeSlide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        outtakeSlide1.setDirection(DcMotorEx.Direction.REVERSE);

        pid = new PIDWrapper(new DcMotorEx[]{outtakeSlide1, outtakeSlide2}, 0.009, 0.0003, 0);

        this.gamepad2 = gamepad2;
    }

    public void extend(){
        if(gamepad2.dpad_up){
            outtakeSlide1.setPower(0.7);
            outtakeSlide2.setPower(0.7);
        } else if(gamepad2.dpad_down) {
            outtakeSlide1.setPower(-0.7);
            outtakeSlide2.setPower(-0.7);
        } else {
            outtakeSlide1.setPower(0);
            outtakeSlide2.setPower(0);
        }
    }

    public void setPID(double P, double I, double D) {
        pid.setPID(P, I, D);
    }

    public void setTargetPos(double pos) {
        pid.setTarget(pos);
    }

    public void update() {
        pid.update();
    }

    public String telemetry(){
        return "outtake slide pos: " + outtakeSlide1.getCurrentPosition();
    }
}