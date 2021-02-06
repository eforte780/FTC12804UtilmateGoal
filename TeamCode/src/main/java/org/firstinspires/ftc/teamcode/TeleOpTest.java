package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class TeleOpTest extends LinearOpMode {

    private DcMotor frontleft;
    private DcMotor frontright;
    private DcMotor backleft;
    private DcMotor backright;
    private DcMotor intake;
    private DcMotor shooter1;
    private DcMotor shooter2;
    private Servo flap;
    boolean shooterbutton;
    boolean shooterreverse;

    @Override
    public void runOpMode () {

        frontleft = hardwareMap.get(DcMotor.class, "frontleft");
        frontright = hardwareMap.get(DcMotor.class,"frontright");
        backleft = hardwareMap.get(DcMotor.class,"backleft");
        backright = hardwareMap.get(DcMotor.class, "backright");
        flap = hardwareMap.get(Servo.class, "flap");
        shooter1 = hardwareMap.get(DcMotor.class,"shooter1");
        shooter2 = hardwareMap.get(DcMotor.class,"shooter2");
        intake = hardwareMap.get(DcMotor.class,"intake");

        shooterbutton = gamepad2.right_bumper;
        shooterreverse = gamepad2.dpad_down;

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

//teleop code goes here
// left bumper intake, right bumper shooter, x flap up, b flap down

        double tgtPower = 0;
        while (opModeIsActive()) {

            //shooter code
//[motor name].setPower([number between 0 and 1 to signify how fast you want to move]);

//if (button shorthand) {
//}

            if (shooterbutton) {
                shooter1.setPower(1);
                shooter2.setPower(1);
            }

            if (shooterreverse) {
                shooter1.setPower(-1);
                shooter2.setPower(-1);
            }
            //basic movement code (rollllll credits!)

            else if (gamepad1.right_bumper) {
                frontleft.setPower(-.5);
                frontright.setPower(-.5);
                backleft.setPower(.5);
                backright.setPower(.5);
            }
            else if (gamepad1.left_bumper) {

                frontleft.setPower(.5);
                frontright.setPower(.5);
                backleft.setPower(-.5);
                backright.setPower(-.5);
            }
            else {
                frontright.setPower(gamepad1.right_stick_y);
                //telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", frontright.getPower());
                telemetry.addData("Status", "Running");

                telemetry.update();

                backright.setPower(gamepad1.right_stick_y);
                //telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", backright.getPower());
                telemetry.addData("Status", "Running");
                telemetry.update();

                frontleft.setPower(-gamepad1.left_stick_y);
                //telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", frontleft.getPower());
                telemetry.addData("Status", "Running");
                telemetry.update();

                backleft.setPower(-gamepad1.left_stick_y);
                //telemetry.addData("Target Power", tgtPower);
                telemetry.addData("Motor Power", backleft.getPower());
                telemetry.addData("Status", "Running");
                telemetry.update();
            }
        }
    }
}
