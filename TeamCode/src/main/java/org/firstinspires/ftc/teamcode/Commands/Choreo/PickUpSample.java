package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawClose;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos0;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.Commands.Steps.Wait;
import org.firstinspires.ftc.teamcode.David;

public class PickUpSample extends SequentialCommand {
    ButtonReader pickUpSampleButton;

    public PickUpSample(Gamepad gamepad1) {
        super(
                new OuttakeToPos0(David.outtakeSlides, David.outtakeSlides.controller),
                new ClawClose(David.claw),
                new Wait(500),
                new OuttakeToPos1(David.outtakeSlides, David.outtakeSlides.controller)
        );
        pickUpSampleButton = new ButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.B);
    }

    public void runRoutine() {

        pickUpSampleButton.readValue();

        if (pickUpSampleButton.wasJustReleased()){
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
