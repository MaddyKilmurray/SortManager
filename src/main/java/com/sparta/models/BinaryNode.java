package com.sparta.models;

public class BinaryNode {

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
