package com.company.Controllers;

import com.company.Logic.Simulation;
import com.company.Models.Model;
import com.company.Views.View;

import java.util.Scanner;

public class Controller {

    private final Scanner scanInput = new Scanner(System.in);
    private final View view;
    private final Model model;

    /**
     * Constructor that setups objects.
     *
     * @param view
     * @param model
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        getInput();
        updateView();
        Simulation simulation = new Simulation(model);
        simulation.start();
        updateViewResults();
    }


    private void getInput() {
        System.out.println("Welcome to the RCCarSimulator! Please enter size:");
        model.setBoardSize(inputTwoNumbers());
        System.out.println("Enter the starting coordinates");
        model.setStartCoordinates(inputTwoNumbers());
        System.out.println("Enter the starting startHeading, choose from N, S, W or E");
        model.setStartHeading(inputHeading());
        System.out.println("Enter the sequence to simulate, choose multiple from F, B, L or R");
        model.setSimulationSequence(inputSimulationSequence());
        System.out.println("Thanks for your configuration. Starting simulation...");
    }

    private int[] inputTwoNumbers() {
        int x, y;
        while (true) {
            String inputConsoleString = scanInput.nextLine();
            String[] parts = inputConsoleString.split(" ");
            if (parts.length < 2 || parts.length > 2) {
                System.out.println("Try again, make sure you only input 2 integers that is space separated.");
                continue;
            }
            try {
                x = Integer.parseInt(parts[0]);
                y = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Try again, That is not a number. ");
                continue;
            }
            return new int[]{x, y};
        }
    }

    private char inputHeading() {
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

    private char[] inputSimulationSequence() {
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

    private void startSimulation() {

    }


    public void updateView() {
        view.printCarDetails(model.getBoardSize(), model.getStartCoordinates(), model.getStartHeading(), model.getSimulationSequence());
    }

    private void updateViewResults() {
        view.printResults();
    }


}
