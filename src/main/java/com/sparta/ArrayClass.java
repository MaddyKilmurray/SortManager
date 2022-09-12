package com.sparta;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayClass {

    public ArrayList<String> insertWord(ArrayList<String> existingWords, String newWord) {
        int index = -1;
        for (int i = 0; i < existingWords.size(); i++) {
            if (existingWords.get(i).compareToIgnoreCase(newWord) > 0) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            existingWords.add(index, newWord);
        }
        else {
            existingWords.add(newWord);
        }
        return existingWords;
    }

    public String[] insertWordArray(String[] existingWords, String newWord) {
        String[] insertedWords = new String[existingWords.length + 1];
        for (int i = 0; i < existingWords.length; i++) {
            insertedWords[i] = existingWords[i];
        }
        insertedWords[existingWords.length] = newWord;
        for (int i = 0; i < insertedWords.length; i++) {
            for (int j = 0; j < insertedWords.length - i - 1; j++) {
                if (insertedWords[j].compareTo(insertedWords[j + 1]) > -1) {
                    String temp = insertedWords[j];
                    insertedWords[j] = insertedWords[j + 1];
                    insertedWords[j + 1] = temp;
                }
            }
        }
        return insertedWords;
    }
}
