package org.firstinspires.ftc.teamcode.Commands.Individual;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.intake.Chamber;

public class chamberDrop extends Command {
        private Chamber chamber;

        public chamberDrop(Chamber chamber) {
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
            return true; // instant finish
        }

    @Override
    public void stop() {

    }
}
