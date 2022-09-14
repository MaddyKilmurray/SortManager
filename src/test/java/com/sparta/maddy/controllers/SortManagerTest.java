package com.sparta.maddy.controllers;

import com.sparta.maddy.models.enums.SorterType;
import com.sparta.maddy.models.interfaces.Sorter;
import com.sparta.maddy.models.sorters.ArrayBinarySort;
import com.sparta.maddy.models.sorters.ArrayBubbleSort;
import com.sparta.maddy.models.sorters.ArrayMergeSort;
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
        SorterType sorter = sortManager.sorterType(-1);
        Assertions.assertNull(sorter);
    }

    @Test
    public void sorterType_OutOfRange_High() {
        SorterType sorter = sortManager.sorterType(4);
        Assertions.assertNull(sorter);
    }

    @Test
    public void sorterType_BinarySort() {
        SorterType sorter = sortManager.sorterType(1);
        Assertions.assertEquals(ArrayBinarySort.class, sorter.getSortType().getClass());
    }

    @Test
    public void sorterType_BinarySort_NotEquals() {
        SorterType sorter = sortManager.sorterType(2);
        Assertions.assertNotEquals(ArrayBinarySort.class, sorter.getSortType().getClass());
    }

    @Test
    public void sorterType_BubbleSort() {
        SorterType sorter = sortManager.sorterType(2);
        Assertions.assertEquals(ArrayBubbleSort.class, sorter.getSortType().getClass());
    }

    @Test
    public void sorterType_BubbleSort_NotEquals() {
        SorterType sorter = sortManager.sorterType(3);
        Assertions.assertNotEquals(ArrayBubbleSort.class, sorter.getSortType().getClass());
    }

    @Test
    public void sorterType_MergeSort() {
        SorterType sorter = sortManager.sorterType(3);
        Assertions.assertEquals(ArrayMergeSort.class, sorter.getSortType().getClass());
    }

    @Test
    public void sorterType_MergeSort_NotEquals() {
        SorterType sorter = sortManager.sorterType(1);
        Assertions.assertNotEquals(ArrayMergeSort.class, sorter.getSortType().getClass());
    }
}
