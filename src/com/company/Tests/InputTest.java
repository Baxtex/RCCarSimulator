package com.company.Tests;

import com.company.Utilities.DataWrapper;
import com.company.Utilities.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputTest {
    @Test
    void inputTwoNumbersValidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "1 1";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputTwoNumbersBoard();
        int[] expected = new int[]{1, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersValidInput2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputTwoNumbersBoard();
        int[] expected = new int[]{100, 100};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersValidInput3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483647 2147483647";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputTwoNumbersBoard();
        int[] expected = new int[]{2147483647, 2147483647};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersValidInput4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100 ";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputTwoNumbersBoard();
        int[] expected = new int[]{100, 100};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "-1 -1";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483648 2147483648";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not a valid integer.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 XX";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not a valid integer.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "XX 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not a valid integer.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100  100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput6() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = " 100 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput7() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = " 100 100 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersInvalidInput8() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoard();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingValid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 N";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputTwoNumbersBoardAndHeading();

        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals('N', dw.heading);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingValid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 S";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputTwoNumbersBoardAndHeading();

        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals('S', dw.heading);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingValid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 W";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputTwoNumbersBoardAndHeading();

        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals('W', dw.heading);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingValid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100 N";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputTwoNumbersBoardAndHeading();

        int[] expected = new int[]{100, 000};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals('W', dw.heading);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingValid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483647 2147483647 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputTwoNumbersBoardAndHeading();

        int[] expected = new int[]{2147483647, 2147483647};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals('E', dw.heading);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingInvalid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 e";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoardAndHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, heading is incorrect.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingInvalid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483648 2147483648 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoardAndHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not valid input";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingInvalid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "-1 -1 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoardAndHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingInvalid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "XX 100 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoardAndHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not valid input";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingInvalid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 XXX E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoardAndHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not valid input";

        assertEquals(expected, actual);
    }

    @Test
    void inputTwoNumbersBoardAndHeadingInvalid6() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100 100 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputTwoNumbersBoardAndHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers and one character that are space separated.";

        assertEquals(expected, actual);
    }

    //TODO Write more tests.

    @Test
    void inputSimulationSequenceValidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "F";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char[] actual = input.inputSimulationSequence();
        char[] expected = new char[]{'F'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceValidInput2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "B";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char[] actual = input.inputSimulationSequence();
        char[] expected = new char[]{'B'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceValidInput3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "L";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char[] actual = input.inputSimulationSequence();
        char[] expected = new char[]{'L'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceValidInput4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "R";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char[] actual = input.inputSimulationSequence();
        char[] expected = new char[]{'R'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceValidInput5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "FBLR";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char[] actual = input.inputSimulationSequence();
        char[] expected = new char[]{'F', 'B', 'L', 'R'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceValidInput6() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "FBLRFFFBBBLLLRRRFF";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char[] actual = input.inputSimulationSequence();
        char[] expected = new char[]{'F', 'B', 'L', 'R', 'F', 'F', 'F', 'B', 'B', 'B', 'L', 'L', 'L', 'R', 'R', 'R', 'F', 'F'};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceInvalidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "fblr";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputSimulationSequence();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, unknown commands.";

        assertEquals(expected, actual);
    }

    @Test
    void inputSimulationSequenceInvalidInput2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "FB   ";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputSimulationSequence();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, unknown commands.";

        assertEquals(expected, actual);
    }
}