package com.company.Models;

import com.company.Shared.Heading;
import com.company.Shared.Move;

/**
 * Model for a car simulation.
 */
public class CarSimulationModel {
    private int[] boardSize, coordinates;
    private boolean successful;
    private String lastMove = "";
    private Heading heading;
    private Move[] moveSequence;


    public String getLastMove() {
        return lastMove;
    }

    public void setLastMove(String lastMove) {
        this.lastMove = lastMove;
    }

    public int[] getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public Move[] getMoveSequence() {
        return moveSequence;
    }

    public void setMoveSequence(Move[] moveSequence) {
        this.moveSequence = moveSequence;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
