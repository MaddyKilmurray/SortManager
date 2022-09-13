package com.sparta.models;

public class BinaryTree {

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

