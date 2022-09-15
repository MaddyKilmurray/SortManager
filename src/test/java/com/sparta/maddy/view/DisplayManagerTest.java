package com.sparta.maddy.view;

import com.sparta.maddy.controllers.exceptions.RunTimeException;
import com.sparta.maddy.controllers.util.ConsoleColors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DisplayManagerTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    int[] testArray;
    DisplayManager displayManager;

    @BeforeEach
    public void setup() {
        displayManager = new DisplayManager();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void printUnsortedArray_ExpectedResult() {
        testArray = new int[]{1, 6, 7, 2, 4, 1, 10, 3, 5, 8};
        displayManager.printUnsortedArray(testArray);
        Assertions.assertEquals("[0;36mYour unsorted array is: \r\n1 6 7 2 4 1 10 3 5 8  \u001B[0m", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void printSortedArray_ExpectedResult() {
        testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        displayManager.printSortedArray(testArray);
        Assertions.assertEquals("[0;35mYour sorted array is: \r\n1 2 3 4 5 6 7 8 9 10  \u001B[0m", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void printRunTime_ExpectedResult() throws RunTimeException {
        displayManager.printRunTime(500,1000);
        Assertions.assertEquals("And it took: 500 nano seconds", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void printRunTime_ExceptionThrown() throws RunTimeException {
        Assertions.assertThrows(RunTimeException.class, () -> {
            displayManager.printRunTime(5000,1000);
        });
    }

    @Test
    public void printArray_ExpectedResult() {
        testArray = new int[]{1, 6, 7, 2, 4, 1, 10, 3, 5, 8};
        displayManager.printArray(testArray);
        Assertions.assertEquals("1 6 7 2 4 1 10 3 5 8", outputStreamCaptor.toString()
                .trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
