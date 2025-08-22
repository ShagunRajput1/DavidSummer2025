package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.Wrist;

public class WristToDrop extends Command {
    private final Wrist wrist;

    public WristToDrop(Wrist wrist) {
        this.wrist = wrist;
    }

    public void init(){
        wrist.toDropOff();
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
