package com.company.Controllers;

import com.company.Logic.Simulation;
import com.company.Models.SimulationModel;
import com.company.Utilities.Input;
import com.company.Views.View;

public class Controller {


    private final View view;
    private final SimulationModel simulationModel;
    private final Input input = new Input();

    /**
     * Constructor that setups objects.
     *
     * @param view
     * @param simulationModel
     */
    public Controller(View view, SimulationModel simulationModel) {
        this.view = view;
        this.simulationModel = simulationModel;
    }

    public void start() {
        getInput();
        updateView();
        Simulation simulation = new Simulation(simulationModel);
        simulation.run();
        if (simulationModel.isSuccessful()) {
            updateSuccessfulView();
        } else {
            updateErrorView();
        }
    }

    private void getInput() {
        System.out.println("Welcome to the RCCarSimulator! Please enter size as rows and columns:");
        simulationModel.setBoardSize(input.inputTwoNumbers());
        System.out.println("Enter the starting coordinates");
        simulationModel.setCoordinates(input.inputTwoNumbers());
        System.out.println("Enter the starting startHeading, choose from N, S, W or E");
        simulationModel.setHeading(input.inputHeading());
        System.out.println("Enter the sequence to simulate, choose multiple from F, B, L or R");
        simulationModel.setSimulationSequence(input.inputSimulationSequence());
        System.out.println("Thanks for your configuration, starting simulation...\n");
    }

    private void updateView() {
        view.printCarDetails(simulationModel.getBoardSize(), simulationModel.getCoordinates(), simulationModel.getHeading(), simulationModel.getSimulationSequence());
    }

    private void updateSuccessfulView() {
        view.printSuccessful(simulationModel.getCoordinates(), simulationModel.getHeading());
    }

    private void updateErrorView() {
        view.printError(simulationModel.getLastMoveInfo());
    }
}