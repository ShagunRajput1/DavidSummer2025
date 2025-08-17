package org.firstinspires.ftc.teamcode.Commands.Group;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Individual.chamberDrop;
import org.firstinspires.ftc.teamcode.Commands.Individual.chamberLift;
import org.firstinspires.ftc.teamcode.Commands.Individual.rollerIn;
import org.firstinspires.ftc.teamcode.intake.Chamber;
import org.firstinspires.ftc.teamcode.intake.RollerIntake;

public class ChamberRoutine extends SequentialCommand {
    ToggleButtonReader chamberButton;

    public ChamberRoutine(Chamber chamber, RollerIntake roller, Gamepad gamepad) {
        super(
                new chamberDrop(chamber),
                new rollerIn(roller, 3000),
                new chamberLift(chamber)
        );
        chamberButton = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.A);
    }

    public void runRoutine() {

        if (chamberButton.wasJustReleased()) {
            this.init(); // restart routine on button press
        }

        if (!this.isFinished()) {
            this.update(); // progress through drop -> roller -> lift
        }
        chamberButton.readValue();
    }

    public boolean isRunning() {
        return !this.isFinished();
    }
}
