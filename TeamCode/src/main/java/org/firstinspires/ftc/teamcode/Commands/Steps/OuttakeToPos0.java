package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToPos0 extends Command {
    private final OutSlides outSlides;

    public OuttakeToPos0(OutSlides outSlides) {
        this.outSlides = outSlides;
    }

    public void init(){
        outSlides.goToPos0();
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
