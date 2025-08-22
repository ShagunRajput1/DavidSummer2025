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

public class DropToBucket2 extends SequentialCommand {
    ToggleButtonReader DropToBucket2Button;
    public DropToBucket2(OutSlides outtake, Claw claw, Wrist wrist, Arm arm, Gamepad gamepad1){
        super(
                new OuttakeToBucket1(outtake),
                new ClawOpen(claw),
                new WristToPickUp(wrist),
                new ArmDown(arm),
                new OuttakeToPos1(outtake)
        );
        DropToBucket2Button = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.X);
    }

    public void runRoutine(){

        DropToBucket2Button.readValue();

        if(DropToBucket2Button.wasJustReleased()){
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
