package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ChamberDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ChamberUp;
import org.firstinspires.ftc.teamcode.Commands.Steps.SpinIntake;
import org.firstinspires.ftc.teamcode.Commands.Steps.SpinStop;
import org.firstinspires.ftc.teamcode.Subsystems.intake.Chamber;
import org.firstinspires.ftc.teamcode.Subsystems.intake.RollerIntake;

public class IntakeSample extends SequentialCommand {

    ToggleButtonReader IntakeSampleButton;

    public IntakeSample(Chamber chamber, RollerIntake roller, Gamepad gamepad1) {
        super(
                new ChamberDown(chamber),
                new SpinIntake(roller, 500),
                new SpinStop(roller),
                new ChamberUp(chamber)
        );
        IntakeSampleButton = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.Y);
    }

    public void runRoutine() {

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
