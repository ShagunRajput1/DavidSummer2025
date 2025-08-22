package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Claw;

public class ClawOpen extends Command {
    private final Claw claw;

    public ClawOpen(Claw claw) {
        this.claw = claw;
    }

    public void init(){
        claw.openClaw();
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
