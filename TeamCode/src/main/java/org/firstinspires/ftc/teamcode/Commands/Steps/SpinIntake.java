package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.intake.RollerIntake;

public class SpinIntake extends Command {

    RollerIntake roller;
    int durationMs;
    long startTime;

    public SpinIntake(RollerIntake roller, int durationMs) {
        this.roller = roller;
        this.durationMs = durationMs;
    }

    public void init() {
        roller.rollIn();
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
