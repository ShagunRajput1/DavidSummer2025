package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmUp;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawOpen;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket2;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.Commands.Steps.Wait;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToDrop;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToPickUp;
import org.firstinspires.ftc.teamcode.David;

public class DropToBucket2 extends SequentialCommand {
    ButtonReader DropToBucket2Button;
    public DropToBucket2(Gamepad gamepad1){
        super(
                new OuttakeToBucket2(David.outtakeSlides, David.outtakeSlides.controller),
                new ArmUp(David.arm),
                new Wait(500),
                new WristToDrop(David.wrist),
                new Wait(500),
                new ClawOpen(David.claw),
                new Wait(500),
                new WristToPickUp(David.wrist),
                new Wait(500),
                new ArmDown(David.arm),
                new Wait(500),
                new OuttakeToPos1(David.outtakeSlides, David.outtakeSlides.controller)
        );
        DropToBucket2Button = new ButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_UP);
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
