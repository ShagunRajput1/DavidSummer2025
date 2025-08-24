package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;

public class ClawClose extends Command {
    private final Claw claw;

    public ClawClose(Claw claw) {
        this.claw = claw;
    }

    public void init(){
        claw.closeClaw();
    }

    @Override
    public void update() {
    }

    @Override
    public boolean isFinished() {
       return true;
    }

    @Override
    public void stop() {
    }
}
