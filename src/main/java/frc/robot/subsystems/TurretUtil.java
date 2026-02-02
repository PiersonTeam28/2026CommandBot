package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.handlers.RobotStates;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TurretUtil extends SubsystemBase {
    
    private TalonSRX turretMotor;

    public TurretUtil() {
        turretMotor = new TalonSRX(Constants.TURRET);
    }

    
    public Command rotateTurret(DoubleSupplier speedSupplier) {
        return run(() -> this.setTurretMotor(speedSupplier.getAsDouble()));
    }

    public Command rotateDegrees(double degrees) {
        return run(() -> {
            double currentPosition = turretMotor.getSensorCollection().getPulseWidthPosition();
            double targetPosition = currentPosition + (degrees/360.0 * 4096); // Assuming 1 unit = 1 degree, adjust as necessary
            
            // Simple proportional control loop
            while (Math.abs(turretMotor.getSensorCollection().getPulseWidthPosition() - targetPosition) > 1) {
                double error = targetPosition - turretMotor.getSensorCollection().getPulseWidthPosition();
                double kP = 0.2; // Proportional gain, adjust as necessary
                double output = kP * error;
                output = Math.max(-0.5, Math.min(0.5, output)); // Limit output to [-0.5, 0.5]
                turretMotor.set(TalonSRXControlMode.PercentOutput, output);
            }
            turretMotor.set(TalonSRXControlMode.PercentOutput, 0); // Stop the motor once target is reached
        });
    }



    public Command readMotor(){
        return run(() ->this.getMotorOutput() );
    }


    @Override
    public void periodic(){
    }

    // public void setTurretMotor(double speed, RobotStates.turretMotor state){
    //     RobotContainer.setTurretState(state);
    //     switch (state) {
    //         case RIGHT:
    //             turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    //             break;

    //         case LEFT:
    //             turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    //             break;
            
    //         case STOP:
    //             turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    //             break;

    //         case MANUAL:
    //             //turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    //             break;
        
    //         default:
    //             turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    //             break;
    //     }
        
    //     //turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    // }

    public void setTurretMotor(double speed){
        //addRequirements();
        turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public double getEncoderPosition(){
        return turretMotor.getSensorCollection().getPulseWidthPosition();
    }

    public double getAnalogPosition(){
        return turretMotor.getSensorCollection().getAnalogInRaw();
    }

    public double getQuadraturePosition(){
        return turretMotor.getSensorCollection().getQuadraturePosition();
    }

    public double getMotorOutput(){
        return turretMotor.getMotorOutputPercent();
    }

   
}
