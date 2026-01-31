package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.handlers.RobotStates;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TurretUtil extends SubsystemBase {
    
    private TalonSRX turretMotor;

    public TurretUtil(){
        turretMotor = new TalonSRX(Constants.TURRET);
    }

    @Override
    public void periodic(){

    }

    public void setTurretMotor(double speed, RobotStates.turretMotor state){
        RobotContainer.setTurretState(state);
        switch (state) {
            case RIGHT:
                turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
                break;

            case LEFT:
                turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
                break;
            
            case STOP:
                turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
        
            default:
                turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
                break;
        }
        
        //turretMotor.set(TalonSRXControlMode.PercentOutput, speed);
    }
}
