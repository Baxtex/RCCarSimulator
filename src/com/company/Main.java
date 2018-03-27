package com.company;

import com.company.Controllers.Controller;
import com.company.Views.CarSimulationView;

/**
 * Main entry point for this application. Starts
 */
public class Main {
    public static void main(String[] args) {
        CarSimulationView simulationModelView = new CarSimulationView();
        Controller controller = new Controller(simulationModelView);
        controller.start();
    }
}
