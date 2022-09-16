package com.sparta.maddy.models.enums;

import com.sparta.maddy.models.interfaces.Sorter;
import com.sparta.maddy.models.sorters.ArrayBinarySort;
import com.sparta.maddy.models.sorters.ArrayBubbleSort;
import com.sparta.maddy.models.sorters.ArrayMergeSort;
import com.sparta.maddy.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum SorterType {
    BINARYSORT(1,"Binary Sort", new ArrayBinarySort()),
    BUBBLESORT(2,"Bubble Sort", new ArrayBubbleSort()),
    MERGESORT(3,"Merge Sort", new ArrayMergeSort());

    private int id;
    private String sortName;
    private Sorter sortType;
    private static Logger logger = LogManager.getLogger(SorterType.class);

    SorterType(int id, String sortName, Sorter sortType) {
        this.id = id;
        this.sortName = sortName;
        this.sortType = sortType;
    }

    public int getId() {
        return id;
    }

    public String getSortName() {
        return sortName;
    }

    public Sorter getSortType() {
        return sortType;
    }

    public static SorterType getById(int id) {
        for(SorterType sorter: SorterType.values()) {
            if(sorter.id == id) {
                logger.info("Sorter selected from Sorter Type class. Sorter type: " + sorter.getSortName());
                return sorter;
            }
        }
        return null;
    }
}
