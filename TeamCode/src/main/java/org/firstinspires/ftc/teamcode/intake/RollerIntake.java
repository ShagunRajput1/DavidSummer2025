package org.firstinspires.ftc.teamcode.intake;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RollerIntake {
    private final DcMotorEx roller;

    int SPIN_IN = -1;
    int SPIN_OUT = 1;

    public RollerIntake(HardwareMap hardwareMap ) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");
    }

    public void rollIn(){
        roller.setPower(SPIN_IN);
    }

    public void rollOut(){
        roller.setPower(SPIN_OUT);
    }

    public void stop() {
        roller.setPower(0);
    }
}
