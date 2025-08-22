package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToBucket2 extends Command {
    private final OutSlides outSlides;

    public OuttakeToBucket2(OutSlides outSlides) {
        this.outSlides = outSlides;
    }

    public void init(){
        outSlides.goToPos3();
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
