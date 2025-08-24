package org.firstinspires.ftc.teamcode.Commands.Steps;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToBucket1 extends Command {
    private final OutSlides outSlides;

    public OuttakeToBucket1(OutSlides outSlides) {
        this.outSlides = outSlides;
    }

    public void init(){
        outSlides.setTargetPos(845);
    }

    @Override
    public void update() {
        outSlides.update();
    }

    @Override
    public boolean isFinished() {
        double targetPos = 845;
        double tolerance = 20;
        double velocity = outSlides.getVelocity(); // You’ll need to expose this in OutSlides
        return Math.abs(outSlides.getCurrentPosition() - targetPos) < tolerance
                && Math.abs(velocity) < 10;
    }

    @Override
    public void stop() {

    }
}
