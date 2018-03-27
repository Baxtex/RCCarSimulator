package com.company.Views;

import com.company.Shared.Heading;
import com.company.Shared.Move;

import java.util.Arrays;

/**
 * View of the carSimulationModel. Prints the values of the car model.
 */
public class CarSimulationView {

    public void printCarDetails(int[] boardSize, int[] coordinates, Heading heading, Move[] simulationSequence) {
        System.out.println("Details");
        System.out.printf("Board size: %d, %d\n", boardSize[0], boardSize[1]);
        System.out.printf("Current position: %d, %d\n", coordinates[0], coordinates[1]);
        System.out.printf("Current heading: %s\n", heading.name());
        System.out.printf("Simulation Sequence: %s\n", Arrays.toString(simulationSequence));
    }

    public void printSuccessful(int[] coordinates, Heading heading) {
        System.out.println("Success!");
        System.out.printf("Current position: %d, %d\n", coordinates[0], coordinates[1]);
        System.out.printf("Current heading: %s\n\n", heading.name());
    }

    public void printError(String lastMoveInfo) {
        System.out.println("Failure!");
        System.out.printf("Error message: %s\n\n", lastMoveInfo);
    }
}
