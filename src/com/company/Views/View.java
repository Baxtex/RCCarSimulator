package com.company.Views;

/**
 * View of the simulation.
 */
public class View {

    //TODO make prettier print.
    public void printCarDetails(int[] boardSize, int[] startCoordinates, char startHeading, char[] simulationSequence) {
        System.out.println("Details");
        System.out.println(boardSize);
        System.out.println(startCoordinates);
        System.out.println(startHeading);
        System.out.println(simulationSequence);
        System.out.println("---");
    }

    public void printResults() {
        System.out.println("ToDo");
    }
}
