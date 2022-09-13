package com.sparta.controllers;

import com.sparta.controllers.interfaces.Sorter;
import com.sparta.controllers.sorters.ArrayBinarySort;
import com.sparta.controllers.sorters.ArrayBubbleSort;
import com.sparta.controllers.sorters.ArrayMergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortManagerTest {

    SortManager sortManager;

    @BeforeEach
    public void setup() {
        sortManager = new SortManager();
    }

    @Test
    public void generateRandomArray_arrayGenerated() {
        int[] testArray = sortManager.generateRandomArray();
        Assertions.assertEquals(50, testArray.length);
    }

    @Test
    public void generateRandomArrayWithLength_ArrayGenerated() {
        int[] testArray = sortManager.generateRandomArrayWithLength(75);
        Assertions.assertEquals(75, testArray.length);
    }

    @Test
    public void sorterType_OutOfRange_Low() {
        Sorter sorter = sortManager.sorterType(-1);
        Assertions.assertNull(sorter);
    }

    @Test
    public void sorterType_OutOfRange_High() {
        Sorter sorter = sortManager.sorterType(4);
        Assertions.assertNull(sorter);
    }

    @Test
    public void sorterType_BinarySort() {
        Sorter sorter = sortManager.sorterType(1);
        Assertions.assertEquals(ArrayBinarySort.class, sorter.getClass());
    }

    @Test
    public void sorterType_BinarySort_NotEquals() {
        Sorter sorter = sortManager.sorterType(2);
        Assertions.assertNotEquals(ArrayBinarySort.class, sorter.getClass());
    }

    @Test
    public void sorterType_BubbleSort() {
        Sorter sorter = sortManager.sorterType(2);
        Assertions.assertEquals(ArrayBubbleSort.class, sorter.getClass());
    }

    @Test
    public void sorterType_BubbleSort_NotEquals() {
        Sorter sorter = sortManager.sorterType(3);
        Assertions.assertNotEquals(ArrayBubbleSort.class, sorter.getClass());
    }

    @Test
    public void sorterType_MergeSort() {
        Sorter sorter = sortManager.sorterType(3);
        Assertions.assertEquals(ArrayMergeSort.class, sorter.getClass());
    }

    @Test
    public void sorterType_MergeSort_NotEquals() {
        Sorter sorter = sortManager.sorterType(1);
        Assertions.assertNotEquals(ArrayMergeSort.class, sorter.getClass());
    }
}
