package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.ToggleButtonReader;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawOpen;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket1;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToPickUp;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;

public class DropToBucket1 extends SequentialCommand {
    ToggleButtonReader DropToBucket1Button;

    public DropToBucket1(OutSlides outtake, Claw claw, Wrist wrist, Arm arm, Gamepad gamepad1){
        super(
                new OuttakeToBucket1(outtake),
                new ClawOpen(claw),
                new WristToPickUp(wrist),
                new ArmDown(arm),
                new OuttakeToPos1(outtake)
        );
        DropToBucket1Button = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.B);
    }

    public void runRoutine(){
        DropToBucket1Button.readValue();

        if(DropToBucket1Button.wasJustReleased()){
            this.init();
        }

        if(!this.isFinished()){
            this.update();
        }
    }

    public boolean isRunning(){
        return !this.isFinished();
    }
}
