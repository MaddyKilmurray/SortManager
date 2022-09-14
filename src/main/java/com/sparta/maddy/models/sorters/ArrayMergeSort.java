package com.sparta.maddy.models.sorters;

import com.sparta.maddy.controllers.util.DuplicateRemover;
import com.sparta.maddy.models.interfaces.Sorter;

public class ArrayMergeSort implements Sorter {

    DuplicateRemover duplicateRemover = new DuplicateRemover();

    @Override
    public int[] sortArray(int[] arrayToSort) {
        arrayToSort = duplicateRemover.removeDuplicates(arrayToSort);
        return sortCleanedArray(arrayToSort);
    }

    public int[] sortCleanedArray(int[] arrayToSort) {
        int n = arrayToSort.length;
        if (n < 2) {
            return arrayToSort;
        }

        int middle = n/2;
        int[] left = new int[middle];
        int[] right = new int[n - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arrayToSort[i];
        }
        for (int j = middle; j < n; j++) {
            right[j - middle] = arrayToSort[j];
        }

        sortCleanedArray(left);
        sortCleanedArray(right);

        return merge(arrayToSort, left, right, middle, n-middle);
    }


    public int[] merge(int[] arrayToSort, int[] left, int[] right, int leftPosition, int rightPosition) {
        int i = 0, j = 0, k = 0;
        while (i < leftPosition && j < rightPosition) {
            if (left[i] <= right[j]) {
                arrayToSort[k++] = left[i++];
            }
            else {
                arrayToSort[k++] = right[j++];
            }
        }
        while (i < leftPosition) {
            arrayToSort[k++] = left[i++];
        }
        while (j < rightPosition) {
            arrayToSort[k++] = right[j++];
        }
        return arrayToSort;
    }

}
