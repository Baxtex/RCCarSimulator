package com.company.Utilities;

import java.util.Scanner;

public class Input {

    private final Scanner scanInput = new Scanner(System.in);

    public int[] inputTwoNumbersBoard() {
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

    public DataWrapper inputTwoNumbersBoardAndHeading() {
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

            if (h == 'N' || h == 'S' || h == 'W' || h == 'E') {
                break;
            } else {
                System.out.println("Try again, heading is incorrect.");
            }
        }
        return new DataWrapper(new int[]{x, y}, h);
    }

    public char[] inputSimulationSequence() {
        char[] inputAsChars;
        while (true) {
            boolean wrongInput = true;
            String inputConsoleString = scanInput.nextLine();
            inputAsChars = inputConsoleString.toCharArray();
            for (char c : inputAsChars) {
                if (c != 'F' && c != 'B' && c != 'L' && c != 'R') {
                    System.out.println("Try again, unknown commands. ");
                    wrongInput = false;
                    break;
                }
            }
            if (wrongInput) {
                break;
            }
        }
        return inputAsChars;
    }
}
