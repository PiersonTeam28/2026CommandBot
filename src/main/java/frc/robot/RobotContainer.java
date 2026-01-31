// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.handlers.RobotStates;

import frc.robot.subsystems.IntakeUtil;
import frc.robot.subsystems.TurretUtil;

import frc.robot.commands.*;

import edu.wpi.first.cameraserver.CameraServer;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;

public class RobotContainer {
  private static RobotStates.intakeMotor aIntakeState;
  private static RobotStates.turretMotor aTurretState;

  private final IntakeUtil intakeUtil = new IntakeUtil();
  private final TurretUtil turretUtil = new TurretUtil();

  private final CommandXboxController joystick0 = new CommandXboxController(0); //#This Joystick Controls The Driving(Will Also Control Elevator)
  private final CommandXboxController joystick1 = new CommandXboxController(1);//#This Joystick Controls The Intake System

  public RobotContainer() {
        // CameraServer.startAutomaticCapture();
        
        // drivetrain = TunerConstants.createDrivetrain();
        // logger = new Telemetry(Constants.MaxSpeed);
      
        configureBindings();
        configureDefaultCommands();
        //configureAutonomousModes();
  }

  private void configureDefaultCommands() {
    //intakeUtil.setDefaultCommand(new OperateIntake(intakeUtil, RobotStates.intakeMotor.STOP));
    //turretUtil.setDefaultCommand(new Swivel(turretUtil, 0));
  }

  //drivetrain.setDefaultCommand(
    // drivetain.applyRequest(() -> drivetrain.switchDriveModes(Constants.speed)));

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  private void configureBindings() {
    
    //joystick1.rightBumper().whileTrue(new OperateTurret(turretUtil, aTurretState.RIGHT)).whileFalse(new OperateTurret(turretUtil, aTurretState.STOP));

    //joystick1.leftBumper().whileTrue(new OperateTurret(turretUtil, aTurretState.LEFT)).whileFalse(new OperateTurret(turretUtil, aTurretState.STOP));


    //turretUtil.setTurretMotor(joystick1.getRightX());

   // turretUtil.setDefaultCommand(new Swivel(turretUtil, joystick1.getRightX()));

    joystick1.a().onTrue(new PrintCommand("a pressed!"));
   //joystick1.axisMagnitudeGreaterThan(4,0.03).whileTrue((new PrintCommand("rx = "+ joystick1.getRightX())));
   // turretUtil.setDefaultCommand(new Swivel(turretUtil, -joystick1.getRightX()));

    //new RunCommand(() -> turretUtil.setTurretMotor(joystick1.getRightX()), turretUtil);
    //turretUtil.setDefaultCommand(turretUtil.setTurretMotor(joystick1.getLeftX()));  // Commands.run(() -> turretUtil.setTurretMotor(joystick1.getRightX()), turretUtil);
    

    turretUtil.setDefaultCommand(
      turretUtil.rotateTurret(() -> joystick1.getRightX()));
  }


  public static void setTurretState(RobotStates.turretMotor state){
    aTurretState = state;
  }

  public static RobotStates.turretMotor getTurretState() {
    return aTurretState;
  }

  public static void setIntakeState(RobotStates.intakeMotor state){
    aIntakeState = state;
  }

  public static RobotStates.intakeMotor getIntakeState() {
    return aIntakeState;
  }
}