package com.company.Logic;

import com.company.Models.SimulationModel;

public class Simulation {

    private final SimulationModel simulationModel;
    private int[][] board;
    private int x, y;
    private char heading = 0;
    private String errorMessage = "";

    public Simulation(SimulationModel simulationModel) {
        this.simulationModel = simulationModel;
    }

    public void run() {
        board = createBoard(simulationModel.getBoardSize()[0], simulationModel.getBoardSize()[1]);
        runSimulation(simulationModel.getCoordinates(), simulationModel.getHeading(), simulationModel.getSimulationSequence());
    }

    private void runSimulation(int[] startCoordinates, char startHeading, char[] simulationSequence) {
        x = startCoordinates[0];
        y = startCoordinates[1];
        heading = startHeading;
        boolean successful = true;

        for (char step : simulationSequence) {
            switch (step) {
                case 'F':
                    successful = moveForward();
                    break;
                case 'B':
                    successful = moveBackwards();
                    break;
                case 'L':
                    rotateLeft();
                    break;
                case 'R':
                    rotateRight();
                    break;
            }
            if (!successful)
                break;
        }
        updateModel(successful);
    }

    private void updateModel(boolean successful) {
        simulationModel.setSuccessful(successful);
        simulationModel.setCoordinates(new int[]{x, y});
        simulationModel.setHeading(heading);
        simulationModel.setLastMoveInfo(errorMessage);
    }

    private boolean moveForward() {
        boolean successful = true;
        switch (heading) {
            case 'N':
                x--;
                if (x < 0) {
                    errorMessage = "Can't go North.";
                    successful = false;
                }
                break;
            case 'S':
                x++;
                if (x > board.length) {
                    errorMessage = "Can't go South.";
                    successful = false;
                }
                break;
            case 'W':
                y--;
                if (y < 0) {
                    errorMessage = "Can't go West.";
                    successful = false;
                }
                break;
            case 'E':
                y++;
                    if (y > board[x].length) {
                    errorMessage = "Can't go East.";
                    successful = false;
                }
                break;
        }
        return successful;
    }

    private boolean moveBackwards() {
        boolean successful = true;
        switch (heading) {
            case 'N':
                x++;
                if (x > board.length) {
                    errorMessage = "Can't go South.";
                    successful = false;
                }
                break;
            case 'S':
                x--;
                if (x < 0) {
                    errorMessage = "Can't go North.";
                    successful = false;
                }
                break;
            case 'W':
                y++;

                if (y > board[x].length) {
                    errorMessage = "Can't go East.";
                    successful = false;
                }
                break;
            case 'E':
                y--;
                if (y < 0) {
                    errorMessage = "Can't go West.";
                    successful = false;
                }
                break;
        }
        return successful;
    }

    private void rotateLeft() {
        switch (heading) {
            case 'N':
                heading = 'W';
                break;
            case 'S':
                heading = 'E';
                break;
            case 'W':
                heading = 'S';
                break;
            case 'E':
                heading = 'N';
                break;
        }
    }

    private void rotateRight() {
        switch (heading) {
            case 'N':
                heading = 'E';
                break;
            case 'S':
                heading = 'W';
                break;
            case 'W':
                heading = 'N';
                break;
            case 'E':
                heading = 'S';
                break;
        }
    }

    private int[][] createBoard(int x, int y) {
        int[][] array = new int[x][y];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = j;
            }
        }
        return array;
    }
}