package com.company.Views;

import java.util.Arrays;

/**
 * View of the simulation.
 */
public class View {

    //TODO make prettier print.
    public void printCarDetails(int[] boardSize, int[] coordinates, char heading, char[] simulationSequence) {
        System.out.println("Details");
        System.out.println("Board size: " + boardSize[0] + ", " + boardSize[1]);
        System.out.println("Current position: " + coordinates[0] + ", " + coordinates[1]);
        System.out.println("Current heading " + heading);
        System.out.println("Simulation Sequence to perform: " + Arrays.toString(simulationSequence));
        System.out.println("---");
    }

    public void printSuccessful(int[] coordinates, char heading) {
        System.out.println("Success!");
        System.out.println("Current position: " + coordinates[0] + ", " + coordinates[1]);
        System.out.println("Current heading " + heading);
    }

    public void printError(String lastMoveInfo) {
        System.out.println("Failure!");
        System.out.println("Error message: " + lastMoveInfo);
    }
}
