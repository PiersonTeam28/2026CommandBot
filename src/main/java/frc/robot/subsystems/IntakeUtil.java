package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;



import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.handlers.RobotStates;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeUtil extends SubsystemBase {
    //private TalonSRX intakeMotor;

    public IntakeUtil() {
        //intakeMotor = new TalonSRX(15);
    }

    @Override
    public void periodic() {
        //SmartDashboard.putString("Intake Motor State :: ", RobotContainer.getIntakeMotorState().toString());
    }

    public void setIntakeMotor(double motorspeed, RobotStates.intakeMotor state) {
    //     RobotContainer.setIntakeMotorState(state);
    //     switch (state) {
    //         case INTAKING:
    //             intakeMotor.set()
    //     }
    }
}
