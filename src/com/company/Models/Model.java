package com.company.Models;

/**
 * Model that is a start of the simulation.
 */
public class Model {
    //Should contain the settings for the start.

    private int[] boardSize;
    private int[] coordinates;
    private char heading;
    private char[] simulationSequence;
    private boolean successful;


    public int[] getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }

    public int[] getStartCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public char getHeading() {
        return heading;
    }

    public void setHeading(char heading) {
        this.heading = heading;
    }

    public char[] getSimulationSequence() {
        return simulationSequence;
    }

    public void setSimulationSequence(char[] simulationSequence) {
        this.simulationSequence = simulationSequence;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
