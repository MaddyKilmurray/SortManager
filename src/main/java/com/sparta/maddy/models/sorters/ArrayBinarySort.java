package com.sparta.maddy.models.sorters;

import com.sparta.maddy.controllers.util.DuplicateRemover;
import com.sparta.maddy.models.interfaces.Sorter;

public class ArrayBinarySort implements Sorter {

    DuplicateRemover duplicateRemover = new DuplicateRemover();
    int[] sortedArray;
    int index = 0;
    int arrayLength = 0;

    @Override
    public int[] sortArray(int[] arrayToSort) {
        arrayToSort = duplicateRemover.removeDuplicates(arrayToSort);
        arrayLength = arrayToSort.length;
        sortedArray = new int[arrayLength];
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

    private class BinaryTree {
        BinaryNode node;

        public BinaryTree(int value){
            node = new BinaryNode(value);
        }

        public BinaryNode getNode() {
            return node;
        }

        public BinaryNode insert(BinaryNode node, int value) {
            if (node == null) {
                return new BinaryNode(value);
            }
            if (value < node.value) {
                node.left = insert(node.left, value);
            }
            else if (value > node.value) {
                node.right = insert(node.right, value);
            }
            return node;
        }
    }

    private class BinaryNode {
        int value;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(int value){
            this.value = value;
            left = null;
            right = null;
        }

        public int getValue() {
            return value;
        }

        public BinaryNode getLeft() {
            return left;
        }

        public BinaryNode getRight() {
            return right;
        }
    }
}
