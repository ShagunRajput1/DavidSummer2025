## CHAMBER CODE

public class Chamber {
Servo chamber;
double chamberUp = 0.1;
double chamberDown = 0.5;

    boolean isChamberUp = true;
    ToggleButtonReader chamberButton;

    public Chamber(HardwareMap hardwareMap) {
        chamber = hardwareMap.get(Servo.class, "chamber");
        chamber.setPosition(chamberUp);
        chamberButton = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.A);
}

    public void lift() {

        if (chamberButton.wasJustReleased()) {
            if (isChamberUp) {
                chamber.setPosition(chamberDown);
            } else {
                chamber.setPosition(chamberUp);
            }
            isChamberUp = !isChamberUp;
        }
        chamberButton.readValue();
    }
## ROLLER CODE

public class RollerIntake {
private final DcMotorEx roller;
    private final Gamepad gamepad1;


    int SPIN_IN = -1;
    int SPIN_OUT = 1;

    public RollerIntake(HardwareMap hardwareMap ) {
       roller  = hardwareMap.get(DcMotorEx.class, "roller");

       this.gamepad1 = gamepad1;
}

    public void spin(){
        if(gamepad1.right_bumper){
            roller.setPower(SPIN_IN);
        } else if(gamepad1.left_bumper){
            roller.setPower(SPIN_OUT);
        }else {
            roller.setPower(0);
        }
    }
## ARM CODE
public class Arm  {
private final Servo arm1;
private final Servo arm2;


    double armUp = .2072;
    double armDown = .8748;
    boolean isArmUp = true;

    ToggleButtonReader armButton;

    public Arm(HardwareMap hardwareMap) {
        arm1 = hardwareMap.get(Servo.class, "arm1");
        arm2 = hardwareMap.get(Servo.class, "arm2");

        arm2.setDirection(Servo.Direction.REVERSE);

        arm1.setPosition(armUp);
        arm2.setPosition(armUp);

        armButton = new ToggleButtonReader(
                new GamepadEx(gamepad2), GamepadKeys.Button.A);
}


    public void move() {
        if (armButton.wasJustReleased()) {
            if (isArmUp) {
                arm1.setPosition(armDown);
                arm2.setPosition(armDown);
            } else {
                arm1.setPosition(armUp);
                arm2.setPosition(armUp);
            }
            isArmUp = !isArmUp;
        }
        armButton.readValue();
    }
## CLAW CODE
public class Claw {
private final Servo claw;


    double clawOpen = 0;
    double clawClose = 1;
    boolean isClawOpen = true;
    
    ToggleButtonReader clawButton;

    public Claw(HardwareMap hardwareMap) {
        claw = hardwareMap.get(Servo.class, "claw");
        claw.setPosition(clawOpen);

        clawButton = new ToggleButtonReader(
                new GamepadEx(gamepad1), GamepadKeys.Button.B);
    }

    public void move() {
        if (clawButton.wasJustReleased()) {
            if (isClawOpen) {
                claw.setPosition(clawClose);
            } else {
                claw.setPosition(clawOpen);
            }
            isClawOpen = !isClawOpen;
        }
        clawButton.readValue();
    }
## WRIST CODE
public class Wrist {
private final Servo wrist;
Gamepad gamepad2;

    double PICK_UP = 0.73;
    double DROP_OFF = 0.1589;
    public Wrist(HardwareMap hardwareMap) {
        wrist = hardwareMap.get(Servo.class, "wrist");

        this.gamepad2 = gamepad2;
    }
    public void move(){
        if(gamepad2.dpad_left){
            wrist.setPosition(0.1589);
        } else if(gamepad2.dpad_right) {
            wrist.setPosition(0.73);
        }
    }

public class 