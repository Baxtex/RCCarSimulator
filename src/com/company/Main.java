package com.company;

import com.company.Controllers.Controller;
import com.company.Models.SimulationModel;
import com.company.Views.View;

/**
 * Class that starts this application
 */
public class Main {
    public static void main(String[] args) {
        View view = new View();
        SimulationModel simulationModel = new SimulationModel();
        Controller controller = new Controller(view, simulationModel);
        controller.start();
    }
}
