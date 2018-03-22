package com.company.Tests;

import com.company.Logic.Simulation;
import com.company.Models.SimulationModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulationTest {

    @Test
    void runSimulationValid1() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{100, 100});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'F', 'B', 'L', 'R'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationInvalid1() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{0, 0});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'F', 'B', 'L', 'R'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }
}