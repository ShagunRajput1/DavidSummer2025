package org.firstinspires.ftc.teamcode.Commands.Individual;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.intake.Chamber;

public class chamberLift extends Command {
    private Chamber chamber;

    public chamberLift(Chamber chamber) {
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
