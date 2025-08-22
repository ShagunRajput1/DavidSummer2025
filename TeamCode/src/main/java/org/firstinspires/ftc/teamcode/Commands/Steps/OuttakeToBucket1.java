package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToBucket1 extends Command {
    private final OutSlides outSlides;

    public OuttakeToBucket1(OutSlides outSlides) {
        this.outSlides = outSlides;
    }

    public void init(){
        outSlides.goToPos2();
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
