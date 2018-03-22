package com.company.Tests;

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

        String consoleInput = "0 0";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputTwoNumbers();
        int[] expected = new int[]{0, 0};
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
        int[] actual = input.inputTwoNumbers();
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
        int[] actual = input.inputTwoNumbers();
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
        int[] actual = input.inputTwoNumbers();
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
            input.inputTwoNumbers();
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
            input.inputTwoNumbers();
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
            input.inputTwoNumbers();
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
            input.inputTwoNumbers();
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
            input.inputTwoNumbers();
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
            input.inputTwoNumbers();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingValidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "N";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char actual = input.inputHeading();
        char expected = 'N';
        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingValidInput2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "S";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char actual = input.inputHeading();
        char expected = 'S';
        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingValidInput3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "W";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char actual = input.inputHeading();
        char expected = 'W';
        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingValidInput4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        char actual = input.inputHeading();
        char expected = 'E';
        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingInvalidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "e";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, unknown direction, did you use valid uppercase characters?";

        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingInvalidInput2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "A";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, unknown direction, did you use valid uppercase characters?";

        assertEquals(expected, actual);
    }

    @Test
    void inputHeadingInvalidInput3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "EE";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputHeading();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, too many characters";

        assertEquals(expected, actual);
    }

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