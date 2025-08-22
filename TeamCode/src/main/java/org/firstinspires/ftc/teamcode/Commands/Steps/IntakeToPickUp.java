package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.intake.InSlides;

public class IntakeToPickUp extends Command {
    private final InSlides inSlides;
    private final int PICK_UP = 0;

    public IntakeToPickUp(InSlides inSlides) {
        this.inSlides = inSlides;
    }

    public void init(){
        inSlides.setTargetPos(PICK_UP);
        inSlides.update();
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
