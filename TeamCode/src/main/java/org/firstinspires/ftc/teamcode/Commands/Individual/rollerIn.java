package org.firstinspires.ftc.teamcode.Commands.Individual;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.intake.RollerIntake;

public class rollerIn extends Command {

    RollerIntake roller;
    int durationMs;
    long startTime;

    public rollerIn(RollerIntake roller, int durationMs) {
        this.roller = roller;
        this.durationMs = durationMs;
    }

    public void init() {
        roller.rollIn(); // start spinning
        startTime = System.currentTimeMillis();
    }

    @Override
    public void update() {}

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - startTime >= durationMs;
    }

    @Override
    public void stop() {
        roller.stop();
    }
}
