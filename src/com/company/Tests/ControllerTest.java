package com.company.Tests;

import com.company.Controllers.Controller;
import com.company.Models.SimulationModel;
import com.company.Views.View;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {

    @Test
    void invalidInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream old = System.out;
        System.setOut(printStream);

        //String input = "XX 10\n0 0\nN\nBB"; valid
        String input = "XX 10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setIn(System.in);

        try {
            new Controller(new View(), new SimulationModel()).start();
        } catch (Exception e) { /* do nothing */ }

        //Put things back
        //System.out.flush();
        //System.setOut(old);
        String x = byteArrayOutputStream.toString();
        assertEquals("Welcome to the RCCarSimulator! Please enter size as rows and columns:\r\nTry again, that is not a number. \r\n", byteArrayOutputStream.toString());
    }

    @Test
    void validInput1() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        String input = "10 10\n0 0\nS\nFFFF";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setIn(System.in);

        View view = new View();
        SimulationModel simulationModel = new SimulationModel();
        Controller controller = new Controller(view, simulationModel);
        try {
            controller.start();
        } catch (Exception e) { /* do nothing */ }
        String x = byteArrayOutputStream.toString();
        assertArrayEquals(simulationModel.getBoardSize(),new int[]{10,10});
    }
}