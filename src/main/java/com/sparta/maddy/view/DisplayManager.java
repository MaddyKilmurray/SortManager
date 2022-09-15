package com.sparta.maddy.view;

import com.sparta.maddy.controllers.SortManager;
import com.sparta.maddy.controllers.exceptions.RunTimeException;
import com.sparta.maddy.controllers.util.ConsoleColors;
import com.sparta.maddy.models.enums.SorterType;
import com.sparta.maddy.controllers.util.SortTimer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DisplayManager {

    Logger logger = LogManager.getLogger(DisplayManager.class);
    Scanner userInput;
    int[] arrayToBeSorted;
    SortManager sortManager = new SortManager();
    SortTimer timer = new SortTimer();
    SorterType sorter;
    long startTimeInNano; long endTimeInNano;
    int arrayLength;

    public void menu() {
        while (true) {
            resetValues();

            System.out.println(ConsoleColors.YELLOW + "Welcome to SortManager" + ConsoleColors.RESET);

            while(arrayToBeSorted == null) {
                setArray();
            }

            chooseComparision();

            if (!continueRunning()) {
                break;
            }
        }
    }

    public void resetValues() {
        sorter = null;
        arrayToBeSorted = null;
    }

    public void setArray() {
        userInput = new Scanner(System.in);

        System.out.println("Time to generate your array");
        System.out.println("Please type (in numbers) the length of the array you would like to sort");

        try {
            arrayLength = Integer.parseInt(userInput.nextLine());
            arrayToBeSorted = new int[arrayLength];
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            System.out.println("Please only type numbers greater than 0");
        }
    }


    public void chooseComparision() {
        userInput = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice == 0) {
            System.out.println(ConsoleColors.YELLOW + "Type 1 to use one sort method, or type 2 to compare 3 different methods"  + ConsoleColors.RESET);
            String choiceInput = userInput.nextLine();
            try {
                userChoice = Integer.parseInt(choiceInput);
                if (userChoice == 1) {
                    useOneSortAlgorithm();
                } else if (userChoice == 2) {
                    compareThreeSortAlgorithms();
                } else {
                    System.out.println(ConsoleColors.RED + "Please type 1 or 2" + ConsoleColors.RESET);
                    userChoice = 0;
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                System.out.println(ConsoleColors.RED + "Please type 1 or 2" + ConsoleColors.RESET);
            }
        }
    }

    public boolean continueRunning() {
        userInput = new Scanner(System.in);
        System.out.println(ConsoleColors.RED + "Would you like to continue? Type yes to continue or q to quit");
        String continueInput = userInput.nextLine();
        if (continueInput.equals("q") || continueInput.equals("Q")) {
            System.out.println("Thanks!");
            return false;
        }
        return true;
    }

    public void useOneSortAlgorithm() {
        while(sorter == null) {
            sorterSelector();
        }
        arrayToBeSorted = sortManager.generateRandomArrayWithLength(arrayLength);

        printUnsortedArray(arrayToBeSorted);

        printSorterName();

        sortArray();

        printSortedArray(arrayToBeSorted);

        try {
            printRunTime(startTimeInNano,endTimeInNano);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void compareThreeSortAlgorithms() {
        int i = 1;
        while (i < 4) {
            arrayToBeSorted = sortManager.generateRandomArrayWithLength(arrayLength);
            printUnsortedArray(arrayToBeSorted);
            sorter = SorterType.getById(i);
            printSorterName();
            sortArray();
            printSortedArray(arrayToBeSorted);
            try {
                printRunTime(startTimeInNano,endTimeInNano);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            i++;
        }

    }

    public void sorterSelector() {
        userInput = new Scanner(System.in);

        System.out.println("How would you like to sort your array?");
        System.out.println("Type 1 to sort with the Binary Sort method");
        System.out.println("Type 2 to sort with the Bubble Sort method");
        System.out.println("Type 3 to sort with the Merge Sort method");

        try {
            sorter = sortManager.sorterType(Integer.parseInt(userInput.nextLine()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            System.out.println("Please type 1, 2 or 3");
        }
    }

    public void printUnsortedArray(int[] arrayToBeSorted) {
        System.out.println(ConsoleColors.CYAN + "Your unsorted array is: ");
        printArray(arrayToBeSorted);
        System.out.println(" " + ConsoleColors.RESET);
    }

    public void printSorterName() {
        System.out.println("This will be sorted using a " + ConsoleColors.BLUE + sorter.getSortName() + ConsoleColors.RESET + " method");
    }

    public void sortArray() {
        startTimeInNano = timer.sortTimeInNano();
        arrayToBeSorted = sortManager.sortArray(sorter,arrayToBeSorted);
        endTimeInNano = timer.sortTimeInNano();
    }

    public void printSortedArray(int[] arrayToBeSorted) {
        System.out.println(ConsoleColors.PURPLE + "Your sorted array is: ");
        printArray(arrayToBeSorted);
        System.out.println(" " + ConsoleColors.RESET);
    }

    public void printRunTime(long startTimeInNano, long endTimeInNano) throws RunTimeException {
        long runTime = sortManager.runTime(startTimeInNano, endTimeInNano);
        if (runTime != -1) {
            System.out.println("And it took: " + runTime + " nano seconds");
        } else {
            throw new RunTimeException("End time is before start time");
        }
    }

    public void printArray(int[] arrayToPrint) {
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(arrayToPrint[i] + " ");
        }
    }
}
