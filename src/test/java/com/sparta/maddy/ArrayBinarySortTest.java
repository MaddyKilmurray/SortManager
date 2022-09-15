package com.sparta.maddy;

import com.sparta.maddy.models.sorters.ArrayBinarySort;
import com.sparta.maddy.controllers.util.SortTimer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayBinarySortTest {

    ArrayBinarySort sorter;

    SortTimer timer;

    @BeforeEach
    public void setup() {
        sorter = new ArrayBinarySort();
        timer = new SortTimer();
    }

    @Test
    public void mergeSort_ExpectedResult() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        actual = sorter.sortArray(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort_SortedArrays() {
        int[] actual = { 1, 2, 3, 4, 5, 6 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        actual = sorter.sortArray(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort_OneOff() {
        int[] actual = { 6, 2, 3, 4, 5, 1 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        actual = sorter.sortArray(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void mergeSort_Duplicates() {
        int[] actual = { 2, 2, 2, 2, 2, 2 };
        int[] expected = { 2 };
        actual = sorter.sortArray(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void binarySort_Time() {
        long averageTime = timer.sortTime(sorter);
        Assertions.assertTrue(averageTime < 100000);
    }
}
