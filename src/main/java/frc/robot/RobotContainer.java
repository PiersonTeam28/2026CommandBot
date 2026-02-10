// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;

import frc.handlers.RobotStates;


import frc.robot.commands.*;

import static frc.robot.Constants.OperatorConstants.*;


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

import frc.robot.subsystems.CANFuelSubsystem;


public class RobotContainer {

  private final CommandXboxController joystick0 = new CommandXboxController(0); //#This Joystick Controls The Driving(Will Also Control Elevator)
  private final CommandXboxController joystick1 = new CommandXboxController(1);//#This Joystick Controls The Intake System

  public RobotContainer() {
        // CameraServer.startAutomaticCapture();
        
        // drivetrain = TunerConstants.createDrivetrain();
        // logger = new Telemetry(Constants.MaxSpeed);
      
        configureBindings();
        configureDefaultCommands();
        //turretUtil.configureTurretMotor(); // Configure the turret motor controller so that we have data from the right encoder
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

  
  }


}