package com.company.Controllers;

import com.company.Logic.Simulation;
import com.company.Models.CarSimulationModel;
import com.company.Shared.DataWrapper;
import com.company.Utilities.Input;
import com.company.Views.CarSimulationView;

/**
 * Controller that acts between the view and the model.
 */
public class Controller {

    private final CarSimulationView carSimulationView;
    private CarSimulationModel carSimulationModel;
    private final Input input = new Input();

    /**
     * Constructor for Controller.
     *
     * @param carSimulationView - View for the Model.
     */
    public Controller(CarSimulationView carSimulationView) {
        this.carSimulationView = carSimulationView;
    }

    /**
     * Infinite loop keeps the game running until force closed.
     */
    public void start() {
        while (true) {
            carSimulationModel = new CarSimulationModel();
            setupModel();
            Simulation simulation = new Simulation();
            simulation.run(carSimulationModel);
            if (carSimulationModel.isSuccessful()) {
                updateSuccessfulView();
            } else {
                updateErrorView();
            }
        }
    }

    /**
     * Takes input from the console and setup the model with it.
     */
    private void setupModel() {
        System.out.println("Please enter size as rows and columns:");
        carSimulationModel.setBoardSize(input.inputBoardSize());
        System.out.println("Enter the starting coordinates and start Heading, choose from N, S, W or E");
        DataWrapper dw = input.inputStartPosition();
        carSimulationModel.setCoordinates(dw.coordinates);
        carSimulationModel.setHeading(dw.heading);
        System.out.println("Enter the sequence of steps to simulate, choose one or more from F, B, L or R");
        carSimulationModel.setMoveSequence(input.inputStepSequence());
        System.out.println("Thanks for your configuration, these are your settings:");
        updateView();
        System.out.println("Starting simulation now...\n");
    }

    private void updateView() {
        carSimulationView.printCarDetails(carSimulationModel.getBoardSize(), carSimulationModel.getCoordinates(), carSimulationModel.getHeading(), carSimulationModel.getMoveSequence());
    }

    private void updateSuccessfulView() {
        carSimulationView.printSuccessful(carSimulationModel.getCoordinates(), carSimulationModel.getHeading());
    }

    private void updateErrorView() {
        carSimulationView.printError(carSimulationModel.getLastMove());
    }
}