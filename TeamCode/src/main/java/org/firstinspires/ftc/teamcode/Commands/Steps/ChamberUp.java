package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.intake.Chamber;

public class ChamberUp extends Command {
    private final Chamber chamber;

    public ChamberUp(Chamber chamber) {
        this.chamber = chamber;
    }

    @Override
    public void init() {
        chamber.setChamberUp();
    }

    @Override
    public void update() { }

    @Override
    public boolean isFinished() {
       return true;
    }

    @Override
    public void stop() { }
}
