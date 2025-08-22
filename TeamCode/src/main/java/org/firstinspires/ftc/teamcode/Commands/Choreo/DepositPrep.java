package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmUp;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToDrop;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;

public class DepositPrep extends SequentialCommand {
    ToggleButtonReader DepositPrepButton;

    public DepositPrep(Arm arm, Wrist wrist, Gamepad gamepad1){
        super(
                new ArmUp(arm),
                new WristToDrop(wrist)
        );
        DepositPrepButton = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.A);
    }

    public void runRoutine(){

        DepositPrepButton.readValue();

        if (DepositPrepButton.wasJustReleased()){
            this.init();
        }

        if (!this.isFinished()){
            this.update();
        }
    }

    public boolean isRunning(){ return !this.isFinished();}
}
