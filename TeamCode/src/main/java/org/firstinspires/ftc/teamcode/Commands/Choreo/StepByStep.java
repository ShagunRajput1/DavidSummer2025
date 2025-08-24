package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmUp;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawClose;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawOpen;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket1;
import org.firstinspires.ftc.teamcode.Commands.Steps.Wait;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToDrop;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToPickUp;
import org.firstinspires.ftc.teamcode.David;

public class StepByStep extends SequentialCommand {
    ButtonReader A;

    public StepByStep(Gamepad gamepad1){
        super(
                new OuttakeToBucket1(David.outtakeSlides)
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