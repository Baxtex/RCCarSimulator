package com.company.Controllers;

import java.util.Scanner;

public class Input {

    private final Scanner scanInput = new Scanner(System.in);

    public int[] inputTwoNumbers() {
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

            if (x < 0 || y < 0) {
                System.out.println("Try again, number is to small.");
                continue;
            }

            return new int[]{x, y};
        }
    }

    public char inputHeading() {
        while (true) {
            String inputConsoleString = scanInput.nextLine();
            if (inputConsoleString.length() > 1) {
                System.out.println("Try again, too many characters");
                continue;
            }

            char c = inputConsoleString.charAt(0);
            if (c == 'N' || c == 'S' || c == 'W' || c == 'E') {
                return c;
            }
            System.out.println("Try again, unknown direction, did you use valid uppercase characters?");
        }
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
