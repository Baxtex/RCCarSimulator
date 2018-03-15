package com.company.Models;

/**
 * Model that is a start of the simulation.
 */
public class Model {
    //Should contain the settings for the start.

    private int[] boardSize;
    private int[] startCoordinates;
    private char startHeading;
    private char[] simulationSequence;

    public int[] getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }

    public int[] getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(int[] startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public char getStartHeading() {
        return startHeading;
    }

    public void setStartHeading(char startHeading) {
        this.startHeading = startHeading;
    }

    public char[] getSimulationSequence() {
        return simulationSequence;
    }

    public void setSimulationSequence(char[] simulationSequence) {
        this.simulationSequence = simulationSequence;
    }
}
