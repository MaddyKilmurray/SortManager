package com.sparta.maddy.view;

import com.sparta.maddy.controllers.SortManager;
import com.sparta.maddy.models.enums.SorterType;
import com.sparta.maddy.models.interfaces.Sorter;
import com.sparta.maddy.controllers.util.SortTimer;

import java.util.Scanner;

public class DisplayManager {

    Scanner userInput;
    int[] arrayToBeSorted;
    SortManager sortManager = new SortManager();
    SortTimer timer = new SortTimer();
    SorterType sorter;
    long startTimeInNano; long endTimeInNano;

    public void menu() {
        while (true) {
            sorter = null;
            arrayToBeSorted = null;
            System.out.println("Welcome to SortManager");
            while(sorter == null) {
                sorter = sorterSelector();
            }
            while(arrayToBeSorted == null) {
                arrayToBeSorted = setArray();
            }
            System.out.println("Your unsorted array is: ");
            for (int i = 0; i < arrayToBeSorted.length; i++) {
                System.out.print(arrayToBeSorted[i] + " ");
            }

            System.out.println(" ");

            System.out.println("This will be sorted using a " + sorter.getSortName() + " method");

            startTimeInNano = timer.sortTimeInNano();
            arrayToBeSorted = sorter.getSortType().sortArray(arrayToBeSorted);
            endTimeInNano = timer.sortTimeInNano();

            System.out.println("Your sorted array is: ");
            for (int i = 0; i < arrayToBeSorted.length; i++) {
                System.out.print(arrayToBeSorted[i] + " ");
            }
            System.out.println(" ");

            System.out.println("And it took: " + (endTimeInNano - startTimeInNano) + " nano seconds");

            System.out.println("Would you like to continue? Type yes to continue or q to quit");
            String continueInput = userInput.nextLine();
            if (continueInput.equals("q") || continueInput.equals("Q")) {
                System.out.println("Thanks!");
                break;
            }
        }
    }

    public SorterType sorterSelector() {
        userInput = new Scanner(System.in);

        System.out.println("How would you like to sort your array?");
        System.out.println("Type 1 to sort with the Binary Sort method");
        System.out.println("Type 2 to sort with the Bubble Sort method");
        System.out.println("Type 3 to sort with the Merge Sort method");

        try {
            return sortManager.sorterType(Integer.parseInt(userInput.nextLine()));
        } catch (Exception e) {
            System.out.println("Please type 1, 2 or 3");
            return null;
        }
    }

    public int[] setArray() {
        userInput = new Scanner(System.in);
        String duplicates;

        System.out.println("Time to generate your array");
        System.out.println("Please type (in numbers) the length of the array you would like to sort");

        try {
            return sortManager.generateRandomArrayWithLength(Integer.parseInt(userInput.nextLine()));
        } catch (Exception e) {
            System.out.println("Please only type numbers greater than 0");
            return null;
        }
    }


}
