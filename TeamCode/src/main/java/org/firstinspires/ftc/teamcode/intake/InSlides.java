package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.PIDWrapper;

public class InSlides {
    public DcMotorEx intakeSlide;
    PIDWrapper pid;
    private final Gamepad gamepad1;

    private int PICK_UP;

    private boolean autoMode = false;

    public InSlides(HardwareMap hardwareMap, Gamepad gamepad1) {
        intakeSlide = hardwareMap.get(DcMotorEx.class, "inSlides");

        intakeSlide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intakeSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE); // Important for holding

        pid = new PIDWrapper(new DcMotorEx[]{intakeSlide}, 0, 0, 0);

        this.gamepad1 = gamepad1;
    }

    public void control() {
        if (autoMode) {
            pid.update();

            if (gamepad1.right_trigger > 0.05 || gamepad1.left_trigger > 0.05) {
                autoMode = false; // cancel auto
            }

        } else {
            // Manual control with triggers
            if (gamepad1.right_trigger > 0.05) {
                intakeSlide.setPower(gamepad1.right_trigger);
            } else if (gamepad1.left_trigger > 0.05) {
                intakeSlide.setPower(-gamepad1.left_trigger);
            } else {
                intakeSlide.setPower(0);
            }

            // Switch into auto mode if B is pressed
            if (gamepad1.b) {
                pid.setTarget(PICK_UP);
                autoMode = true;
            }
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

    public String telemetry() {
        return "Intake slides pos: " + intakeSlide.getCurrentPosition() +
                " target: " + pid.getTarget() +
                " autoMode: " + autoMode;
    }
}