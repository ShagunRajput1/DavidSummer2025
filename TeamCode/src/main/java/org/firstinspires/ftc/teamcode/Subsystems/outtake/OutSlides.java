package org.firstinspires.ftc.teamcode.Subsystems.outtake;

//import static org.firstinspires.ftc.teamcode.util.Logger.*;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.Logger;

public class OutSlides {
    private final DcMotorEx outtakeSlide1;
    private final DcMotorEx outtakeSlide2;

    public PIDController controller;
    private double P = 0.02, I = 0.02, D = 0;
    Double targetPos;

    double[] slidesPositions = {203, 469, 845, 2007};
    int currentIndex = 0;

    ToggleButtonReader Dpad_Up;
    ToggleButtonReader Dpad_Down;

    public OutSlides(HardwareMap hardwareMap, Gamepad gamepad){
        outtakeSlide1 = hardwareMap.get(DcMotorEx.class, "outSlide1");
        outtakeSlide2 = hardwareMap.get(DcMotorEx.class, "outSlide2");

        outtakeSlide1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outtakeSlide2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        outtakeSlide1.setDirection(DcMotorEx.Direction.REVERSE);

        controller = new PIDController(P, I, D);
        controller.setIntegrationBounds(-1000000, 1000000);

        Dpad_Up = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.DPAD_UP);
        Dpad_Down = new ToggleButtonReader(
                new GamepadEx(gamepad), GamepadKeys.Button.DPAD_DOWN);

        targetPos = slidesPositions[currentIndex];
    }

    public void control(){
        Dpad_Up.readValue();
        Dpad_Down.readValue();

        if (Dpad_Up.wasJustReleased()) {
            if (currentIndex < slidesPositions.length - 1) {
                currentIndex++;
                targetPos = slidesPositions[currentIndex];
            }
        }

        if (Dpad_Down.wasJustReleased()) {
            if (currentIndex > 0) {
                currentIndex--;
                targetPos = slidesPositions[currentIndex];
            }
        }

        update();
    }

    public void setPID(double P, double I, double D) {
        this.P = P;
        this.I = I;
        this.D = D;
        controller.setPID(P, I, D);
//        Logger.log("outtakeSlide setPID P " + P + " I " + I + " D " + D);
    }

    public void setTargetPos(double targetPos) {
        this.targetPos = targetPos;
//        Logger.log("outtakeSlide Set Target  pos " + this.targetPos);
    }
    public void update() {
        double currentPos = outtakeSlide1.getCurrentPosition();
        double error = targetPos - currentPos;
        double power = controller.calculate(0, error);

        power = Math.max(-1, Math.min(1, power));

        outtakeSlide1.setPower(power);
        outtakeSlide2.setPower(power);

//        Logger.log("outtakeSlide : Update: CurrPos " + currentPos + " TargetPos " + targetPos +
//                " Power " + power);
    }
    public String telemetry(){
        //Logger.log("outtakeSlide1  pos " + outtakeSlide1.getCurrentPosition());
        return "outtake slide pos: " + outtakeSlide1.getCurrentPosition();
    }

    public double getCurrentPosition() {
        return outtakeSlide1.getCurrentPosition();
    }

    public double getVelocity() {
        return outtakeSlide1.getVelocity();
    }
}