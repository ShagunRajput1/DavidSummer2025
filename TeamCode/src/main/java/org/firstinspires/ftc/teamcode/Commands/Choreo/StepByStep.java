package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket1;
import org.firstinspires.ftc.teamcode.David;

public class StepByStep extends SequentialCommand {
    ButtonReader A;

    public StepByStep(Gamepad gamepad1){
        super(
                new OuttakeToBucket1(David.outtakeSlides, David.outtakeSlides.controller)
        );
        A = new ButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.A);
    }

    public void runRoutine() {

        A.readValue();

        if (A.wasJustReleased()) {
            this.init();
        }

        if (!this.isFinished()) {
            this.update();
        }
    }

    public boolean isRunning() {
        return !this.isFinished();
    }
}