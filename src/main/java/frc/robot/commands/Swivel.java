package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.handlers.RobotStates;
import frc.robot.Constants;
import frc.robot.subsystems.TurretUtil;

public class Swivel extends Command{
    
    private final TurretUtil m_turret;
    private final double m_speed;
   // private final RobotStates.turretMotor m_turretState;

    public Swivel(TurretUtil turret, double speed){
        
        m_turret = turret;
        m_speed = speed;
       // m_turretState = turretState;

        
        addRequirements(m_turret);

    }

    
     // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    @Override
    public void execute() {
        // switch (m_turretState) {
        //     case RIGHT:
        //         m_turret.setTurretMotor(-1*Constants.SLOW, m_turretState);
        //         break;
        //     case LEFT:
        //         m_turret.setTurretMotor(1*Constants.SLOW, m_turretState);
        //         break;
        //     case STOP:
        //         m_turret.setTurretMotor(0, m_turretState);
        
        //     default:
        //         m_turret.setTurretMotor(0, m_turretState);
        //         break;
        // }

        m_turret.setTurretMotor(m_speed);
       // new PrintCommand("Turret Speed: " + m_speed);
    
    }

      // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

  // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
         }


   
    
}
