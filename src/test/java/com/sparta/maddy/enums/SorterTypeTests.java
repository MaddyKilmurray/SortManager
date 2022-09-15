package com.sparta.maddy.enums;

import com.sparta.maddy.models.enums.SorterType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SorterTypeTests {

    @Test
    public void getSortName_Binary_ExpectedResult() {
        String sorterName = SorterType.valueOf("BINARYSORT").getSortName();
        Assertions.assertEquals("Binary Sort", sorterName);
    }

    @Test
    public void getSortName_Merge_ExpectedResult() {
        String sorterName = SorterType.valueOf("MERGESORT").getSortName();
        Assertions.assertEquals("Merge Sort", sorterName);
    }

    @Test
    public void getSortName_Bubble_ExpectedResult() {
        String sorterName = SorterType.valueOf("BUBBLESORT").getSortName();
        Assertions.assertEquals("Bubble Sort", sorterName);
    }

    @Test
    public void getSortName_Binary_IncorrectResult() {
        String sorterName = SorterType.valueOf("BUBBLESORT").getSortName();
        Assertions.assertNotEquals("Binary Sort", sorterName);
    }

    @Test
    public void getSortName_Merge_IncorrectResult() {
        String sorterName = SorterType.valueOf("BINARYSORT").getSortName();
        Assertions.assertNotEquals("Merge Sort", sorterName);
    }

    @Test
    public void getSortName_Bubble_IncorrectResult() {
        String sorterName = SorterType.valueOf("MERGESORT").getSortName();
        Assertions.assertNotEquals("Bubble Sort", sorterName);
    }

    @Test
    public void getID_Binary_ExpectedResult() {
        int sorterID = SorterType.valueOf("BINARYSORT").getId();
        Assertions.assertEquals(1, sorterID);
    }

    @Test
    public void getID_Merge_ExpectedResult() {
        int sorterID = SorterType.valueOf("MERGESORT").getId();
        Assertions.assertEquals(3, sorterID);
    }

    @Test
    public void getID_Bubble_ExpectedResult() {
        int sorterID = SorterType.valueOf("BUBBLESORT").getId();
        Assertions.assertEquals(2, sorterID);
    }

    @Test
    public void getID_Binary_IncorrectResult() {
        int sorterID = SorterType.valueOf("BINARYSORT").getId();
        Assertions.assertNotEquals(3, sorterID);
    }

    @Test
    public void getID_Merge_IncorrectResult() {
        int sorterID = SorterType.valueOf("MERGESORT").getId();
        Assertions.assertNotEquals(2, sorterID);
    }

    @Test
    public void getID_Bubble_IncorrectResult() {
        int sorterID = SorterType.valueOf("BUBBLESORT").getId();
        Assertions.assertNotEquals(1, sorterID);
    }
}
