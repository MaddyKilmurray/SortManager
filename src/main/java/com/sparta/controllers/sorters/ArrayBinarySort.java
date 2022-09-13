package com.sparta.controllers.sorters;

import com.sparta.controllers.interfaces.Sorter;
import com.sparta.models.BinaryNode;
import com.sparta.models.BinaryTree;

public class ArrayBinarySort implements Sorter {

    int[] sortedArray;
    int index = 0;

    @Override
    public int[] sortArray(int[] arrayToSort) {
        sortedArray = new int[arrayToSort.length];
        BinaryTree tree = new BinaryTree(arrayToSort[0]);
        for(int num : arrayToSort){
            tree.insert(tree.getNode(), num);
        }

        storeInOrder(tree.getNode());

        return sortedArray;
    }

    public void storeInOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        storeInOrder(node.getLeft());
        sortedArray[index++] = node.getValue();
        storeInOrder(node.getRight());
    }
}
