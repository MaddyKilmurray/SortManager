package com.sparta.maddy;

import com.sparta.maddy.models.sorters.ArrayBubbleSort;
import com.sparta.maddy.controllers.util.SortTimer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    ArrayBubbleSort tester;

    SortTimer timer;

    @BeforeEach
    public void setup() {
        tester = new ArrayBubbleSort();
        timer = new SortTimer();
    }

    @Test
    public void sortArrayTest_ExpectedResult() {
        int[] testArray1 = {5,2,1,6,7,3,4,9,8,10};
        int[] sortedArray = tester.sortArray(testArray1);

        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(4, sortedArray[3]);
    }

    @Test
    public void sortArrayTest_ExpectedResult_SortedArray() {
        int[] testArray1 = {1,2,3,4,5,6};
        int[] sortedArray = tester.sortArray(testArray1);

        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(4, sortedArray[3]);
    }

    @Test
    public void sortArrayTest_ExpectedResult_LastOrder() {
        int[] testArray1 = {6,2,3,4,5,1};
        int[] sortedArray = tester.sortArray(testArray1);

        Assertions.assertEquals(1, sortedArray[0]);
        Assertions.assertEquals(2, sortedArray[1]);
        Assertions.assertEquals(3, sortedArray[2]);
        Assertions.assertEquals(4, sortedArray[3]);
    }

    @Test
    public void sortArrayTest_Time() {
        long averageTime = timer.sortTime(tester);
        Assertions.assertTrue(averageTime < 90000);
    }

    @Test
    public void sortArrayTest_NullTest() {
        int[] sortedArray = tester.sortArray(null);
        int[] expectedResult = new int[0];
        Assertions.assertArrayEquals(expectedResult,sortedArray);
    }
}
