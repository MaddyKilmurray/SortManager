package com.sparta.controllers.sorters;

public class TwoArrayMerge {

    public int[] sort(int[] numbers1, int[] numbers2) {
        int[] sortedNumbers = new int[numbers1.length + numbers2.length];
        int numbers1Position, numbers2Position, sortedPosition;
        numbers1Position = numbers2Position = sortedPosition = 0;

        while (numbers1Position < numbers1.length && numbers2Position < numbers2.length) {
            if (numbers1[numbers1Position] == numbers2[numbers2Position]) {
                sortedNumbers[sortedPosition++] = numbers1[numbers1Position++];
                numbers2Position++;
            }
            else if (numbers1[numbers1Position] < numbers2[numbers2Position]) {
                sortedNumbers[sortedPosition++] = numbers1[numbers1Position++];
            }
            else if (numbers1[numbers1Position] > numbers2[numbers2Position]) {
                sortedNumbers[sortedPosition++] = numbers2[numbers2Position++];
            }
        }

        while (numbers1Position < numbers1.length) {
            sortedNumbers[sortedPosition++] = numbers1[numbers1Position++];
        }

        while (numbers2Position < numbers2.length) {
            sortedNumbers[sortedPosition++] = numbers2[numbers2Position++];
        }
        return sortedNumbers;
    }
}
