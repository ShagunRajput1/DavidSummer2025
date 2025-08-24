package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToPos0 extends Command {
    private final OutSlides outSlides;

    public OuttakeToPos0(OutSlides outSlides) {
        this.outSlides = outSlides;
    }

    public void init(){
        outSlides.setTargetPos(148);
    }

    @Override
    public void update() {
        outSlides.update();
    }

    @Override
    public boolean isFinished() {
        double targetPos = 148;
        double tolerance = 30;
        double velocity = outSlides.getVelocity(); // You’ll need to expose this in OutSlides
        return Math.abs(outSlides.getCurrentPosition() - targetPos) < tolerance
                && Math.abs(velocity) < 10;
    }

    @Override
    public void stop() {

    }
}
