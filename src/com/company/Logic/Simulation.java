package com.company.Logic;


import com.company.Models.Model;


public class Simulation {

    private final Model model;
    private int[][] board;
    private int currentX, currentY;
    private char currentHeading = 0;
    private String lastMoveInfo = "";

    public Simulation(Model model) {
        this.model = model;
    }

    //Logic for running the simulation
    public void run() {
        board = createBoard(model.getBoardSize()[0], model.getBoardSize()[1]);
        runSimulation(model.getStartCoordinates(), model.getHeading(), model.getSimulationSequence());
        if (!model.isSuccessful()) {
            System.out.println("Simulation failed: " + lastMoveInfo);
        }
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
        model.setSuccessful(successful);
        model.setCoordinates(new int[]{currentX, currentY});
        model.setHeading(currentHeading);
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