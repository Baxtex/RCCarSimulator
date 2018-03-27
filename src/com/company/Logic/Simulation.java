package com.company.Logic;

import com.company.Models.CarSimulationModel;
import com.company.Shared.Heading;
import com.company.Shared.Move;

/**
 * Performs the simulation by moving the car around according to simulation sequence.
 */
public class Simulation {

    private CarSimulationModel carSimulationModel;
    private String lastMove = "";
    private int[][] board;
    private int x, y;
    private Heading heading;
    private boolean successful = true;

    /**
     * Starts the simulation with the provided simulation model.
     *
     * @param carSimulationModel - the model to run the simulation on.
     */
    public void run(CarSimulationModel carSimulationModel) {
        this.carSimulationModel = carSimulationModel;
        board = createBoard(carSimulationModel.getBoardSize()[0], carSimulationModel.getBoardSize()[1]);
        runSimulation(carSimulationModel.getCoordinates(), carSimulationModel.getHeading(), carSimulationModel.getMoveSequence());
    }

    /**
     * Iterates the simulation sequence to try and move the car around. When simulation is done, the model is updated.
     *
     * @param startCoordinates - starting location in the 2D array. 0,0 is the top left corner.
     * @param startHeading     - starting direction for the model.
     * @param moveSequence     - the sequence of steps that the model should perform.
     */
    private void runSimulation(int[] startCoordinates, Heading startHeading, Move[] moveSequence) {
        x = startCoordinates[0];
        y = startCoordinates[1];
        heading = startHeading;

        for (Move move : moveSequence) {
            switch (move) {
                case FORWARD:
                    moveForward();
                    break;
                case BACKWARD:
                    moveBackwards();
                    break;
                case ROTATE_LEFT:
                    rotateLeft();
                    break;
                case ROTATE_RIGHT:
                    rotateRight();
                    break;
            }
            if (!successful)
                break;
        }
        updateModel();
    }

    private void updateModel() {
        carSimulationModel.setSuccessful(successful);
        carSimulationModel.setCoordinates(new int[]{x, y});
        carSimulationModel.setHeading(heading);
        carSimulationModel.setLastMove(lastMove);
    }

    private void moveForward() {
        switch (heading) {
            case NORTH:
                x--;
                if (x < 0) {
                    lastMove = "Can't go North.";
                    successful = false;
                }
                break;
            case SOUTH:
                x++;
                if (x > board.length) {
                    lastMove = "Can't go South.";
                    successful = false;
                }
                break;
            case WEST:
                y--;
                if (y < 0) {
                    lastMove = "Can't go West.";
                    successful = false;
                }
                break;
            case EAST:
                y++;
                if (y > board[x].length) {
                    lastMove = "Can't go East.";
                    successful = false;
                }
                break;
        }
    }

    private void moveBackwards() {
        switch (heading) {
            case NORTH:
                x++;
                if (x > board.length) {
                    lastMove = "Can't go South.";
                    successful = false;
                }
                break;
            case SOUTH:
                x--;
                if (x < 0) {
                    lastMove = "Can't go North.";
                    successful = false;
                }
                break;
            case WEST:
                y++;

                if (y > board[x].length) {
                    lastMove = "Can't go East.";
                    successful = false;
                }
                break;
            case EAST:
                y--;
                if (y < 0) {
                    lastMove = "Can't go West.";
                    successful = false;
                }
                break;
        }
    }

    private void rotateLeft() {
        switch (heading) {
            case NORTH:
                heading = Heading.WEST;
                break;
            case SOUTH:
                heading = Heading.EAST;
                break;
            case WEST:
                heading = Heading.SOUTH;
                break;
            case EAST:
                heading = Heading.NORTH;
                break;
        }
    }

    private void rotateRight() {
        switch (heading) {
            case NORTH:
                heading = Heading.EAST;
                break;
            case SOUTH:
                heading = Heading.WEST;
                break;
            case WEST:
                heading = Heading.NORTH;
                break;
            case EAST:
                heading = Heading.SOUTH;
                break;
        }
    }

    /**
     * Initialises the board for the simulation by creating a 2D array.
     *
     * @param x - Nbr rows.
     * @param y - Nbr columns.
     * @return - 2D array.
     */
    private int[][] createBoard(int x, int y) {
        int[][] board = new int[x][y];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = j;
            }
        }
        return board;
    }
}