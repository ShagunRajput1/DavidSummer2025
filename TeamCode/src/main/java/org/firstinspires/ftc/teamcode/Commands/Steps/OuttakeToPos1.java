package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToPos1 extends Command{
    private final OutSlides outSlides;

    public OuttakeToPos1(OutSlides outSlides) {
        this.outSlides = outSlides;
    }

    public void init(){
        outSlides.setTargetPos(479);
    }

    @Override
    public void update() {
        outSlides.update();
    }

    @Override
    public boolean isFinished() {
        double targetPos = 479;
        double tolerance = 20;
        double velocity = outSlides.getVelocity(); // You’ll need to expose this in OutSlides
        return Math.abs(outSlides.getCurrentPosition() - targetPos) < tolerance
                && Math.abs(velocity) < 10;
    }

    @Override
    public void stop() {

    }
}
