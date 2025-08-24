package org.firstinspires.ftc.teamcode.Commands.Steps;

import com.arcrobotics.ftclib.controller.PIDController;

import org.firstinspires.ftc.teamcode.CommandSystem.Command;
import org.firstinspires.ftc.teamcode.Subsystems.outtake.OutSlides;

public class OuttakeToBucket2 extends Command {
    private final OutSlides outSlides;
    PIDController controller;

    double targetPos = 2007;

    public OuttakeToBucket2(OutSlides outSlides, PIDController controller) {
        this.outSlides = outSlides;
        this.controller = controller;
    }

    public void init(){
        outSlides.setIndex(3);

    }

    @Override
    public void update() {
        outSlides.update();
    }

    @Override
    public boolean isFinished() {
        double tolerance = 20;
        double velocity = outSlides.getVelocity(); // You’ll need to expose this in OutSlides
        if (Math.abs(outSlides.getCurrentPosition() - targetPos) < tolerance
                && Math.abs(velocity) < 10) {
            outSlides.zeroPower();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void stop() {

    }
}
