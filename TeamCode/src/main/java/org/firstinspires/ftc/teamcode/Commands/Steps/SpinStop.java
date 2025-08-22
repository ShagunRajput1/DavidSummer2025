package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.intake.RollerIntake;

public class SpinStop extends Command {
    RollerIntake roller;

    public SpinStop(RollerIntake roller) {
        this.roller = roller;

    }

    public void init() {
        roller.stop();
    }

    @Override
    public void update() {}

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void stop() {
        roller.stop();
    }
}
