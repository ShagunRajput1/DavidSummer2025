package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ChamberDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ChamberUp;
import org.firstinspires.ftc.teamcode.Commands.Steps.SpinIntake;
import org.firstinspires.ftc.teamcode.Commands.Steps.SpinStop;
import org.firstinspires.ftc.teamcode.David;

public class ChamberIntake extends SequentialCommand {

    ButtonReader IntakeSampleButton;

    public ChamberIntake(Gamepad gamepad1) {
        super(
                new ChamberDown(David.chamber),
                new SpinIntake(David.roller, 500),
                new SpinStop(David.roller),
                new ChamberUp(David.chamber)
        );
        IntakeSampleButton = new ButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.A);
    }

    public void runRoutine() {

        IntakeSampleButton.readValue();

        if (IntakeSampleButton.wasJustReleased()) {
            this.init();
        }

        if (!this.isFinished()) {
            this.update(); // progress through drop -> roller -> lift
        }
    }

    public boolean isRunning() {
        return !this.isFinished();
    }
}
