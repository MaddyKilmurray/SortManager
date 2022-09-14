package com.sparta.maddy.controllers.util;

import java.util.HashSet;
import java.util.Set;

public class DuplicateRemover {

    public int[] removeDuplicates(int[] arrayToBeCleaned) {
        if (arrayToBeCleaned == null) {
            return null;
        }
        Set<Integer> duplicatesRemoved = new HashSet();
        for (int i = 0; i < arrayToBeCleaned.length; i++) {
            duplicatesRemoved.add(arrayToBeCleaned[i]);
        }
        int[] duplicatesRemovedArray = new int[duplicatesRemoved.size()];
        int j = 0;
        for (Integer number:duplicatesRemoved) {
            duplicatesRemovedArray[j++] = number;
        }
        return duplicatesRemovedArray;
    }
}
