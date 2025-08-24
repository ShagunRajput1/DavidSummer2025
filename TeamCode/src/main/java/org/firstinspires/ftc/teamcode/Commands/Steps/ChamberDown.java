package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.intake.Chamber;

public class ChamberDown extends Command {
    private final Chamber chamber;

    public ChamberDown(Chamber chamber) {
            this.chamber = chamber;
        }

    @Override
    public void init() {
            chamber.setChamberDown();
        }

    @Override
    public void update() { }

    @Override
    public boolean isFinished() {
        return true;
        }

    @Override
    public void stop() {

    }
}
