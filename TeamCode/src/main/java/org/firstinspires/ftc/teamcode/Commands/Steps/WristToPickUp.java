package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;

public class WristToPickUp extends Command {
    private final Wrist wrist;

    public WristToPickUp(Wrist wrist) {
        this.wrist = wrist;
    }

    public void init(){
        wrist.toPickUp();
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
