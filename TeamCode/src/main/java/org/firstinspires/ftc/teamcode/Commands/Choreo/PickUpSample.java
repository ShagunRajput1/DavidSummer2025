package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawClose;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos0;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToPickUp;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;
import org.firstinspires.ftc.teamcode.util.Logger;

public class PickUpSample extends SequentialCommand {
    ToggleButtonReader PickUpSampleButton;

    Telemetry telemetry;

    public PickUpSample(OutSlides outtake, Arm arm, Wrist wrist, Claw claw, Gamepad gamepad1, Telemetry telemetry) {
        super(
                new OuttakeToPos1(outtake),
                new ArmDown(arm),
                new WristToPickUp(wrist),
                new OuttakeToPos0(outtake),
                new ClawClose(claw),
                new OuttakeToPos1(outtake)
        );
        PickUpSampleButton = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.Y);
    }

    public void runRoutine() {

        PickUpSampleButton.readValue();

        if (PickUpSampleButton.wasJustReleased()) {
            Logger.log("PickUpSample PickUpSampleButton.wasJustReleased()");
            this.init(telemetry);
            //telemetry.update();;
        }

        if (!this.isFinished()) {
            this.update();
        }
    }

    public boolean isRunning() {
        return !this.isFinished();
    }

}
