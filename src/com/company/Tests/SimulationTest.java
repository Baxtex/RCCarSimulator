package com.company.Tests;

import com.company.Logic.Simulation;
import com.company.Models.SimulationModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulationTest {

    @Test
    void runSimulationValid1() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{0, 0});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'L', 'R', 'L', 'R', 'R', 'L'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationValid2() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{100, 100});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'F', 'F', 'F', 'F', 'R', 'R', 'F', 'R', 'F', 'F', 'F', 'R', 'F', 'B', 'L', 'F', 'F', 'F', 'F'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationValid3() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{10000, 10000});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'F', 'F', 'F', 'F', 'R', 'R', 'F', 'R', 'F', 'F', 'F', 'R', 'F', 'B', 'L', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F'});

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
        simulationModel.setHeading('N');
        simulationModel.setSimulationSequence(new char[]{'F', 'B', 'L', 'R'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationInvalid2() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{5, 1});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'F', 'F', 'F', 'F', 'F', 'F'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationInvalid3() {
        SimulationModel simulationModel = new SimulationModel();
        simulationModel.setBoardSize(new int[]{1, 1});
        simulationModel.setCoordinates(new int[]{0, 0});
        simulationModel.setHeading('S');
        simulationModel.setSimulationSequence(new char[]{'L', 'F', 'F', 'F', 'F', 'F', 'F'});

        Simulation simulation = new Simulation(simulationModel);
        simulation.run();

        boolean actual = simulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }
}