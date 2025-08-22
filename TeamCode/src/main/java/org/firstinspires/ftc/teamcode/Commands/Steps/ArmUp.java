package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Arm;

public class ArmUp extends Command {
    private final Arm arm;

    public ArmUp(Arm arm) {
        this.arm = arm;
    }

    public void init(){
        arm.setArmDown();
    }

    @Override
    public void update() {}

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void stop() {

    }
}
