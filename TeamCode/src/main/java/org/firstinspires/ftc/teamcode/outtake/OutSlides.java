package org.firstinspires.ftc.teamcode.outtake;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class OutSlides {
    private final DcMotorEx outtakeSlide1;
    private final DcMotorEx outtakeSlide2;

    private double P = .009, I = 0.0003, D = 0;
    private double tarPos;
    private PIDController pidController;
    Gamepad gamepad;

    public OutSlides(HardwareMap hardwareMap, Gamepad gamepad){
        outtakeSlide1 = hardwareMap.get(DcMotorEx.class, "outSlide1");
        outtakeSlide2 = hardwareMap.get(DcMotorEx.class, "outSlide2");

        outtakeSlide1.setDirection(DcMotorEx.Direction.REVERSE);

        pidController = new PIDController(P,I,D);
        pidController.setIntegrationBounds(-1000000, 1000000);

        this.gamepad = gamepad;
    }

    public void extend(){
        if(gamepad.dpad_up){
            outtakeSlide1.setPower(0.7);
            outtakeSlide2.setPower(0.7);
        } else if(gamepad.dpad_down) {
            outtakeSlide1.setPower(-0.7);
            outtakeSlide2.setPower(-0.7);
        } else {
            outtakeSlide1.setPower(0);
            outtakeSlide2.setPower(0);
        }
    }

    public void setPID(double P,double I, double D){
        this.P = P;
        this.I = I;
        this.D = D;

        pidController.setPID(P, I, D);
    }

    public void update(){
        double currPos = outtakeSlide1.getCurrentPosition();
        double error = tarPos - currPos;
        double power = pidController.calculate(0, error);

        if (power > 1){
            power = 1;
        } else if(power < -1){
            power = -1;
        }

        outtakeSlide1.setPower(power);
        outtakeSlide2.setPower(power);
    }

    public void setTarPos(double tarPos){
        this.tarPos = tarPos;
    }

    public String telemetry(){
        return "outtake slide pos: " + outtakeSlide1.getCurrentPosition();
    }
}