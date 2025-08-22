package org.firstinspires.ftc.teamcode.Subsystems.intake;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class InSlides {
    public DcMotorEx intakeSlide;
    private final PIDController controller;
    private double P = 0.006, I = 0, D = 0;
    private double targetPos;
    int PICK_UP = 0;

    private boolean pidMode = false;

    Gamepad gamepad;
    public InSlides(HardwareMap hardwareMap, Gamepad gamepad) {
        intakeSlide = hardwareMap.get(DcMotorEx.class, "inSlides");

        intakeSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Important for holding

        controller = new PIDController(P, I, D);
        controller.setIntegrationBounds(-1000000, 1000000);

        this.gamepad = gamepad;
    }

    public void control(){

        if (gamepad.dpad_up) {
            setTargetPos(PICK_UP);
            pidMode = true;
        } else if (gamepad.right_trigger > 0.05 || gamepad.left_trigger > 0.05) {
            pidMode = false;

            if (gamepad.right_trigger > 0.05) {
                intakeSlide.setPower(0.8);
            } else if (gamepad.left_trigger > 0.05) {
                intakeSlide.setPower(-0.8);
            }
        } else if (!pidMode) {
            // idle manual
            intakeSlide.setPower(0);
        }

        // If in PID mode, always update
        if (pidMode) {
            update();
        }
    }


    public void setPID(double P, double I, double D) {
        this.P = P;
        this.I = I;
        this.D = D;
        controller.setPID(P, I, D);
    }

    public void setTargetPos(double targetPos) {
        this.targetPos = targetPos;
    }

    public double getTargetPos() {
        return targetPos;
    }

    public void update() {
        double currentPos = intakeSlide.getCurrentPosition();
        double error = targetPos - currentPos;
        double power = controller.calculate(0, error);

        power = Math.max(-1, Math.min(1, power));

        intakeSlide.setPower(power);
    }

    public String telemetry() {
        return "Intake slides pos: " + intakeSlide.getCurrentPosition();
    }
}