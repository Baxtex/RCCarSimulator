package com.company.Tests;

import com.company.Shared.DataWrapper;
import com.company.Shared.Heading;
import com.company.Shared.Move;
import com.company.Utilities.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for the input class.
 * Methods that test for invalid input has to swallow NoSuchElementException because the method
 * is waiting for more input. In real usage, this error won't occur and thus can be ignored here.
 */
class InputTest {
    @Test
    void inputBoardSizeValid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "1 1";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputBoardSize();
        int[] expected = new int[]{1, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputBoardSizeValid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputBoardSize();
        int[] expected = new int[]{100, 100};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputBoardSizeValid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483646 2147483646";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputBoardSize();
        int[] expected = new int[]{2147483646, 2147483646};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputBoardSizeValid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483647 2147483647";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputBoardSize();
        int[] expected = new int[]{2147483647, 2147483647};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputBoardSizeValid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100 ";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        int[] actual = input.inputBoardSize();
        int[] expected = new int[]{100, 100};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "-1 -1";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "10 0";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 10";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483648 2147483648";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not a valid integer.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid6() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 XX";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not a valid integer.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid7() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "XX 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not a valid integer.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid8() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100  100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid9() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = " 100 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid10() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = " 100 100 100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputBoardSizeInvalid11() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputBoardSize();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputStartPositionValid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 N";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputStartPosition();

        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals(Heading.NORTH, dw.heading);
    }

    @Test
    void inputStartPositionValid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 S";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputStartPosition();

        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals(Heading.SOUTH, dw.heading);
    }

    @Test
    void inputStartPositionValid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 W";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputStartPosition();

        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals(Heading.WEST, dw.heading);
    }

    @Test
    void inputStartPositionValid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0001 00 W";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputStartPosition();

        int[] expected = new int[]{1, 0};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals(Heading.WEST, dw.heading);
    }

    @Test
    void inputStartPositionValid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100 N";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputStartPosition();

        int[] expected = new int[]{100, 100};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals(Heading.NORTH, dw.heading);
    }

    @Test
    void inputStartPositionValid6() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483647 2147483647 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        DataWrapper dw = input.inputStartPosition();

        int[] expected = new int[]{2147483647, 2147483647};
        assertArrayEquals(expected, dw.coordinates);
        assertEquals(Heading.EAST, dw.heading);
    }

    @Test
    void inputStartPositionInvalid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "0 0 e";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStartPosition();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, heading is incorrect.";

        assertEquals(expected, actual);
    }

    @Test
    void inputStartPositionInvalid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "2147483648 2147483648 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStartPosition();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not valid input";

        assertEquals(expected, actual);
    }

    @Test
    void inputStartPositionInvalid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "-1 -1 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStartPosition();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, number is to small.";

        assertEquals(expected, actual);
    }

    @Test
    void inputStartPositionInvalid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "XX 100 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStartPosition();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not valid input";

        assertEquals(expected, actual);
    }

    @Test
    void inputStartPositionInvalid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 XXX E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStartPosition();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, that is not valid input";

        assertEquals(expected, actual);
    }

    @Test
    void inputStartPositionInvalid7() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "100 100 100 E";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStartPosition();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, make sure you only input 2 integers and one character that are space separated.";

        assertEquals(expected, actual);
    }

    @Test
    void inputStepSequenceValid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "F";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        Move[] actual = input.inputStepSequence();
        Move[] expected = new Move[]{Move.FORWARD};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputStepSequenceValid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "B";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        Move[] actual = input.inputStepSequence();
        Move[] expected = new Move[]{Move.BACKWARD};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputStepSequenceValid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "L";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        Move[] actual = input.inputStepSequence();
        Move[] expected = new Move[]{Move.ROTATE_LEFT};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputStepSequenceValid4() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "R";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        Move[] actual = input.inputStepSequence();
        Move[] expected = new Move[]{Move.ROTATE_RIGHT};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputStepSequenceValid5() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "FBLR";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        Move[] actual = input.inputStepSequence();
        Move[] expected = new Move[]{Move.FORWARD, Move.BACKWARD, Move.ROTATE_LEFT, Move.ROTATE_RIGHT};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputStepSequenceValid6() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "FBLRFFFBBBLLLRRRFF";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        Move[] actual = input.inputStepSequence();
        Move[] expected = new Move[]{Move.FORWARD, Move.BACKWARD, Move.ROTATE_LEFT, Move.ROTATE_RIGHT, Move.FORWARD, Move.FORWARD, Move.FORWARD, Move.BACKWARD, Move.BACKWARD, Move.BACKWARD, Move.ROTATE_LEFT, Move.ROTATE_LEFT, Move.ROTATE_LEFT, Move.ROTATE_RIGHT, Move.ROTATE_RIGHT, Move.ROTATE_RIGHT, Move.FORWARD, Move.FORWARD};
        assertArrayEquals(expected, actual);
    }

    @Test
    void inputStepSequenceInvalid1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "fblr";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStepSequence();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, unknown commands.";

        assertEquals(expected, actual);
    }

    @Test
    void inputStepSequenceInvalid2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "FB   ";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStepSequence();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, unknown commands.";

        assertEquals(expected, actual);
    }

    @Test
    void inputStepSequenceInvalid3() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String consoleInput = "\n";
        System.setIn(new ByteArrayInputStream(consoleInput.getBytes()));
        System.setIn(System.in);

        Input input = new Input();
        try {
            input.inputStepSequence();
        } catch (NoSuchElementException e) {
        }

        String actual = byteArrayOutputStream.toString().trim();
        String expected = "Try again, can't be less than 1";

        assertEquals(expected, actual);
    }
}