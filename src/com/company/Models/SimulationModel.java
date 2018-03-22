package com.company.Models;

/**
 * SimulationModel that is a start of the simulation.
 */
public class SimulationModel {
    //Should contain the settings for the start.

    private int[] boardSize;
    private int[] coordinates;
    private char heading;
    private char[] simulationSequence;
    private boolean successful;
    private String lastMoveInfo = "";



    public String getLastMoveInfo() {
        return lastMoveInfo;
    }

    public void setLastMoveInfo(String lastMoveInfo) {
        this.lastMoveInfo = lastMoveInfo;
    }

    public int[] getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }

    public int[] getCoordinates() { return coordinates; }

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
