package com.sparta.maddy;

import com.sparta.maddy.models.sorters.TwoArrayMerge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoArrayMergeTest {

    TwoArrayMerge tester;

    @BeforeEach
    public void setup() {
        tester = new TwoArrayMerge();
    }

    @Test
    public void twoArrayTest_ExpectedOutcome() {
        int[] num1 = { 1,5,8,10,15};
        int[] num2 = { 2,3,9,11,16};
        int[] sortedArray = tester.sort(num1,num2);
        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(5, sortedArray[3]);
    }

    @Test
    public void twoArrayTest_DifferentLengths() {
        int[] num1 = { 1,5,8,10,15};
        int[] num2 = { 2,3,9};
        int[] sortedArray = tester.sort(num1,num2);
        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(5, sortedArray[3]);
    }

    @Test
    public void twoArrayTest_DuplicateItems_SecondInput() {
        int[] num1 = { 1,2,8,10,15};
        int[] num2 = { 2,3,9};
        int[] sortedArray = tester.sort(num1,num2);
        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(8, sortedArray[3]);
    }

    @Test
    public void twoArrayTest_DuplicateItemsAll_SecondInput() {
        int[] num1 = { 1,2,3,4,5};
        int[] num2 = { 2,3,4,5,6};
        int[] sortedArray = tester.sort(num1,num2);
        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(4, sortedArray[3]);
    }

    @Test
    public void twoArrayTest_DuplicateItems_FirstInput() {
        int[] num1 = { 2,3,9};
        int[] num2 = { 1,2,8,10,15};
        int[] sortedArray = tester.sort(num1,num2);
        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(8, sortedArray[3]);
    }

    @Test
    public void twoArrayTest_DuplicateItemsAll_FirstInput() {
        int[] num1 = { 2,3,4,5,6};
        int[] num2 = { 1,2,3,4,5};
        int[] sortedArray = tester.sort(num1,num2);
        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(4, sortedArray[3]);
    }
}
