package com.company.Utilities;

import com.company.Shared.DataWrapper;
import com.company.Shared.Heading;
import com.company.Shared.Move;

import java.util.Scanner;

/**
 * Class responsible for receiving user input from the console and returning parsed values.
 */
public class Input {

    private final Scanner scanInput = new Scanner(System.in);

    /**
     * Reads the console for the number of rows and columns the board should have. Loops until valid input is received.
     *
     * @return - int array of the size that is bigger than 1,1.
     */
    public int[] inputBoardSize() {
        int x, y;
        while (true) {
            String inputConsoleString = scanInput.nextLine();
            String[] parts = inputConsoleString.split(" ");
            if (parts.length < 2 || parts.length > 2) {
                System.out.println("Try again, make sure you only input 2 integers that are space separated.");
                continue;
            }
            try {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Try again, that is not a valid integer.");
                continue;
            }

            if (x < 1 || y < 1) {
                System.out.println("Try again, number is to small.");
                continue;
            }

            return new int[]{x, y};
        }
    }

    /**
     * Reads the console for input for the starting position and the starting heading. Loops until valid input is received.
     *
     * @return - A wrapped object containing the starting position as ints and the start heading as Heading enum.
     */
    public DataWrapper inputStartPosition() {
        int x, y;
        char h;
        while (true) {
            String inputConsoleString = scanInput.nextLine();
            String[] parts = inputConsoleString.split(" ");
            if (parts.length < 3 || parts.length > 3) {
                System.out.println("Try again, make sure you only input 2 integers and one character that are space separated.");
                continue;
            }
            try {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
                h = parts[2].charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("Try again, that is not valid input");
                continue;
            }
            if (x < 0 || y < 0) {
                System.out.println("Try again, number is to small.");
                continue;
            }

            switch (h) {
                case 'N':
                    return new DataWrapper(new int[]{x, y}, Heading.NORTH);
                case 'S':
                    return new DataWrapper(new int[]{x, y}, Heading.SOUTH);
                case 'W':
                    return new DataWrapper(new int[]{x, y}, Heading.WEST);
                case 'E':
                    return new DataWrapper(new int[]{x, y}, Heading.EAST);
                default:
                    System.out.println("Try again, heading is incorrect.");
                    break;
            }
        }
    }

    /**
     * Reads the console for input for the simulation sequence. Loops until valid input is received.
     *
     * @return - An array of the steps.
     */
    public Move[] inputSimulationSequence() {
        Move[] simulationSequence;
        while (true) {
            boolean validInput = true;
            String inputConsoleString = scanInput.nextLine();
            char[] inputAsChars = inputConsoleString.toCharArray();
            simulationSequence = new Move[inputConsoleString.length()];

            label:
            for (int i = 0; i < inputAsChars.length; i++) {
                switch (inputAsChars[i]) {
                    case 'F':
                        simulationSequence[i] = Move.FORWARD;
                        break;
                    case 'B':
                        simulationSequence[i] = Move.BACKWARD;
                        break;
                    case 'L':
                        simulationSequence[i] = Move.ROTATE_LEFT;
                        break;
                    case 'R':
                        simulationSequence[i] = Move.ROTATE_RIGHT;
                        break;
                    default:
                        System.out.println("Try again, unknown commands. ");
                        validInput = false;
                        break label;
                }
            }
            if (validInput) {
                break;
            }
        }
        return simulationSequence;
    }
}
