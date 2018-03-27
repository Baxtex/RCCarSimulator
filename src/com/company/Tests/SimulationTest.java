package com.company.Tests;

import com.company.Logic.Simulation;
import com.company.Models.CarSimulationModel;
import com.company.Shared.Heading;
import com.company.Shared.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the simulation.
 */
class SimulationTest {

    @Test
    void runSimulationValid1() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{1, 1});
        carSimulationModel.setCoordinates(new int[]{0, 0});
        carSimulationModel.setHeading(Heading.SOUTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.ROTATE_LEFT, Move.ROTATE_RIGHT, Move.ROTATE_LEFT, Move.ROTATE_RIGHT, Move.ROTATE_RIGHT, Move.ROTATE_LEFT});
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationValid2() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{100, 100});
        carSimulationModel.setCoordinates(new int[]{0, 0});
        carSimulationModel.setHeading(Heading.SOUTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.ROTATE_RIGHT, Move.ROTATE_RIGHT,
                Move.FORWARD, Move.ROTATE_RIGHT, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.ROTATE_RIGHT, Move.FORWARD, Move.BACKWARD, Move.ROTATE_LEFT,
                Move.FORWARD, Move.FORWARD, Move.FORWARD});
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationValid3() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{10000, 10000});
        carSimulationModel.setCoordinates(new int[]{0, 0});
        carSimulationModel.setHeading(Heading.SOUTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.ROTATE_RIGHT, Move.ROTATE_RIGHT, Move.FORWARD,
                Move.ROTATE_RIGHT, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.ROTATE_RIGHT, Move.FORWARD, Move.BACKWARD, Move.ROTATE_LEFT, Move.FORWARD, Move.FORWARD,
                Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD,
                Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD
        });
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationValid4() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{100, 100});
        carSimulationModel.setCoordinates(new int[]{50, 50});
        carSimulationModel.setHeading(Heading.SOUTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.ROTATE_RIGHT, Move.ROTATE_RIGHT,
                Move.FORWARD, Move.ROTATE_RIGHT, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.ROTATE_RIGHT, Move.FORWARD, Move.BACKWARD, Move.ROTATE_LEFT,
                Move.FORWARD, Move.FORWARD, Move.FORWARD});
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationInvalid1() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{0, 0});
        carSimulationModel.setCoordinates(new int[]{0, 0});
        carSimulationModel.setHeading(Heading.NORTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.FORWARD, Move.BACKWARD, Move.ROTATE_LEFT, Move.ROTATE_RIGHT});
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationInvalid2() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{5, 1});
        carSimulationModel.setCoordinates(new int[]{0, 0});
        carSimulationModel.setHeading(Heading.SOUTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD});
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void runSimulationInvalid3() {
        CarSimulationModel carSimulationModel = new CarSimulationModel();
        carSimulationModel.setBoardSize(new int[]{1, 1});
        carSimulationModel.setCoordinates(new int[]{0, 0});
        carSimulationModel.setHeading(Heading.SOUTH);
        carSimulationModel.setMoveSequence(new Move[]{Move.ROTATE_LEFT, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.FORWARD});
        Simulation simulation = new Simulation();
        simulation.run(carSimulationModel);

        boolean actual = carSimulationModel.isSuccessful();
        boolean expected = false;
        assertEquals(expected, actual);
    }
}