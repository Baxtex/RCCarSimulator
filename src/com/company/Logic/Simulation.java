package com.company.Logic;


import com.company.Models.SimulationModel;


public class Simulation {

    private final SimulationModel simulationModel;
    private int[][] board;
    private int currentX, currentY;
    private char currentHeading = 0;
    private String lastMoveInfo = "";

    public Simulation(SimulationModel simulationModel) {
        this.simulationModel = simulationModel;
    }

    //Logic for running the simulation
    public void run() {
        board = createBoard(simulationModel.getBoardSize()[0], simulationModel.getBoardSize()[1]);
        runSimulation(simulationModel.getStartCoordinates(), simulationModel.getHeading(), simulationModel.getSimulationSequence());

    }

    private void runSimulation(int[] startCoordinates, char startHeading, char[] simulationSequence) {
        currentX = startCoordinates[0];
        currentY = startCoordinates[1];
        currentHeading = startHeading;
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
        simulationModel.setCoordinates(new int[]{currentX, currentY});
        simulationModel.setHeading(currentHeading);
        simulationModel.setLastMoveInfo(lastMoveInfo);
    }


    private boolean moveForward() {
        boolean successful = true;
        switch (currentHeading) {
            case 'N':
                currentX--;
                if (currentX < 0) {
                    lastMoveInfo = "Can't go North.";
                    successful = false;
                }
                break;
            case 'S':
                currentX++;
                if (currentX > board.length) {
                    lastMoveInfo = "Can't go South.";
                    successful = false;
                }
                break;
            case 'W':
                currentY--;
                if (currentY < 0) {
                    lastMoveInfo = "Can't go West.";
                    successful = false;
                }
                break;
            case 'E':
                currentY++;

                if (currentY > board[currentX].length) {
                    lastMoveInfo = "Can't go East.";
                    successful = false;
                }
                break;
        }
        return successful;
    }

    private boolean moveBackwards() {
        boolean successful = true;
        switch (currentHeading) {
            case 'N':
                currentX++;
                if (currentX > board.length) {
                    lastMoveInfo = "Can't go South.";
                    successful = false;
                }
                break;
            case 'S':
                currentX--;
                if (currentX < 0) {
                    lastMoveInfo = "Can't go North.";
                    successful = false;
                }
                break;
            case 'W':
                currentY++;

                if (currentY > board[currentX].length) {
                    lastMoveInfo = "Can't go East.";
                    successful = false;
                }
                break;
            case 'E':
                currentY--;
                if (currentY < 0) {
                    lastMoveInfo = "Can't go West.";
                    successful = false;
                }
                break;
        }
        return successful;
    }


    private void rotateLeft() {
        switch (currentHeading) {
            case 'N':
                currentHeading = 'W';
                break;
            case 'S':
                currentHeading = 'E';
                break;
            case 'W':
                currentHeading = 'S';
                break;
            case 'E':
                currentHeading = 'N';
                break;
        }
    }

    private void rotateRight() {
        switch (currentHeading) {
            case 'N':
                currentHeading = 'E';
                break;
            case 'S':
                currentHeading = 'W';
                break;
            case 'W':
                currentHeading = 'N';
                break;
            case 'E':
                currentHeading = 'S';
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