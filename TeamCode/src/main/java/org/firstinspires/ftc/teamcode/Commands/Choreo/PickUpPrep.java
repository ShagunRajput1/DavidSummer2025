package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawClose;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos0;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.Commands.Steps.Wait;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToPickUp;
import org.firstinspires.ftc.teamcode.David;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;

public class PickUpPrep extends SequentialCommand {
    ButtonReader pickUpPrepButton;

    public PickUpPrep(Gamepad gamepad1) {
        super(
                new OuttakeToPos1(David.outtakeSlides),
                new ArmDown(David.arm),
                new Wait(500),
                new WristToPickUp(David.wrist),
                new Wait(500)
        );
        pickUpPrepButton = new ButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.Y);
    }

    public void runRoutine() {

        pickUpPrepButton.readValue();

        if (pickUpPrepButton.wasJustReleased()){
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
