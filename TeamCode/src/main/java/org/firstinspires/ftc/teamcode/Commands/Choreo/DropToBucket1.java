package org.firstinspires.ftc.teamcode.Commands.Choreo;

import com.arcrobotics.ftclib.gamepad.ButtonReader;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.CommandSystem.SequentialCommand;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmDown;
import org.firstinspires.ftc.teamcode.Commands.Steps.ArmUp;
import org.firstinspires.ftc.teamcode.Commands.Steps.ClawOpen;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToBucket1;
import org.firstinspires.ftc.teamcode.Commands.Steps.OuttakeToPos1;
import org.firstinspires.ftc.teamcode.Commands.Steps.Wait;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToDrop;
import org.firstinspires.ftc.teamcode.Commands.Steps.WristToPickUp;
import org.firstinspires.ftc.teamcode.David;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;

public class DropToBucket1 extends SequentialCommand {
    ButtonReader DropToBucket1Button;

    public DropToBucket1(Gamepad gamepad1){
        super(
                new OuttakeToBucket1(David.outtakeSlides),
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
                new OuttakeToPos1(David.outtakeSlides)
        );
        DropToBucket1Button = new ButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.DPAD_DOWN);
    }

    public void runRoutine(){
        DropToBucket1Button.readValue();

        // Only start sequence on button release
        if(DropToBucket1Button.wasJustReleased()){
            this.init();
        }

        // Always update the sequence if it’s running
        if(!this.isFinished()){
            this.update();
        }
    }

    public boolean isRunning(){
        return !this.isFinished();
    }
}
