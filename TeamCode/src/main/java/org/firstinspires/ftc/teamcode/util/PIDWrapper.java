package org.firstinspires.ftc.teamcode.util;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;

    public class PIDWrapper {
        private PIDController controller;
        private double P, I, D;
        private double targetPos;

        private DcMotorEx[] motors;
        private final double minOutput = -1.0, maxOutput = 1.0;

        /**
         * @param motors      Motors this PID will control (pass one or more)
         * @param P           Proportional coefficient
         * @param I           Integral coefficient
         * @param D           Derivative coefficient
         */
        public PIDWrapper(DcMotorEx[] motors, double P, double I, double D) {
            this.motors = motors;
            this.P = P;
            this.I = I;
            this.D = D;

            controller = new PIDController(P, I, D);
            controller.setIntegrationBounds(-1000000, 1000000);
        }

        public void setPID(double P, double I, double D) {
            this.P = P;
            this.I = I;
            this.D = D;
            controller.setPID(P, I, D);
        }

        public void setTarget(double targetPos) {
            this.targetPos = targetPos;
        }

        public void update() {
            double currentPos = motors[0].getCurrentPosition();
            double error = targetPos - currentPos;
            double output = controller.calculate(0, error);

            output = Math.max(minOutput, Math.min(maxOutput, output));

            for (DcMotorEx motor : motors) {
                motor.setPower(output);
            }
        }

        public double getError() {
            return targetPos - motors[0].getCurrentPosition();
        }

        public double getTarget() {
            return targetPos;
        }

        public double getCurrentPos() {
            return motors[0].getCurrentPosition();
        }
    }
