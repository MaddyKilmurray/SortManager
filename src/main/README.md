# Sort Manager

Sort Manager has multiple methods for sorting Arrays, including Bubble Sort and Merge Sort.



## ArrayBubbleSort()

Approximate run time: 30000 - 40000 nanoseconds

```java
public class ArrayBubbleSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        int counter = 0;
        do {
            for (int i = 0; i < arrayToSort.length; i++) {
                counter = 0;
                for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                    if (arrayToSort[j] > arrayToSort[j + 1]) {
                        int temp = arrayToSort[j];
                        arrayToSort[j] = arrayToSort[j + 1];
                        arrayToSort[j + 1] = temp;
                        counter++;
                    }
                }
            }
        } while (counter != 0);
        return arrayToSort;
    }
}
```

ArrayBubbleSort() uses a bubble sort algorithm to go sort an array of integers in ascending order.

The algorithm goes through the following steps:

1) It sets an int to zero. This is the counter variable, and is used as a flag to stop the bubble sort. If no swaps are made in a pass, the method stops.

2) There is a do...while loop which controls the flag. It will always check through the array once, and if no swaps are made, the array is returned.

3) Within the do...while loop, there is a loop that iterates over each item in the array. Each time this loop runs, the counter is reset to zero.

4) Within this loop there is another loop. This loops also iterates over each item in the array. It compares the first item with the one next to it.

    1) If the first item is bigger than the second, a temporary variable is initialised to hold the value of the first item.

    2) The first item's position is now replaced with the value of the second item.

    3) The second item's position is now replaced with the value of the temporary variable.

    4) The counter is incremented, signalling that a swap has taken place this round.

       ![image-20220912144915023](C:\Users\maddy\AppData\Roaming\Typora\typora-user-images\image-20220912144915023.png)

5) Once all items have been iterated over, or a pass has been made with no swaps, the method then returns the sorted array. 



