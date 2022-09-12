package com.sparta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArrayClassTest {

    public ArrayClass arrayClass;

    @BeforeEach
    public void setup() {
        arrayClass = new ArrayClass();
    }

    @Test
    public void insertWordTest() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Apple"); words.add("Banana"); words.add("Cherry");
        ArrayList<String> newWords = arrayClass.insertWord(words, "Blueberry");
        Assertions.assertEquals(4, newWords.size());
    }

    @Test
    public void insertWordTestOrder() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Apple"); words.add("Banana"); words.add("Cherry");
        ArrayList<String> newWords = arrayClass.insertWord(words, "Blueberry");
        StringBuilder wordStream = new StringBuilder();
        for (String word : newWords) {
            wordStream.append(word);
        }
        Assertions.assertEquals("AppleBananaBlueberryCherry", wordStream.toString());
    }

    @Test
    public void insertWordTestEnd() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Apple"); words.add("Banana"); words.add("Cherry");
        ArrayList<String> newWords = arrayClass.insertWord(words, "Dog");
        StringBuilder wordStream = new StringBuilder();
        for (String word : newWords) {
            wordStream.append(word);
        }
        Assertions.assertEquals("AppleBananaCherryDog", wordStream.toString());
    }

    @Test
    public void insertWordTestStart() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Apple"); words.add("Banana"); words.add("Cherry");
        ArrayList<String> newWords = arrayClass.insertWord(words, "Ace");
        StringBuilder wordStream = new StringBuilder();
        for (String word : newWords) {
            wordStream.append(word);
        }
        Assertions.assertEquals("AceAppleBananaCherry", wordStream.toString());
    }

    @Test
    public void insertWordArrayTest() {
        String[] words = {"Apple","Banana","Cherry"};
        String[] newWords = arrayClass.insertWordArray(words, "Blueberry");
        Assertions.assertEquals(4, newWords.length);
    }

    @Test
    public void insertWordArrayTestOrder() {
        String[] words = {"Apple","Banana","Cherry"};
        String[] newWords = arrayClass.insertWordArray(words, "Blueberry");
        StringBuilder wordStream = new StringBuilder();
        for (String word : newWords) {
            wordStream.append(word);
        }
        Assertions.assertEquals("AppleBananaBlueberryCherry", wordStream.toString());
    }

    @Test
    public void insertWordArrayTestEnd() {
        String[] words = {"Apple","Banana","Cherry"};
        String[] newWords = arrayClass.insertWordArray(words, "Dog");
        StringBuilder wordStream = new StringBuilder();
        for (String word : newWords) {
            wordStream.append(word);
        }
        Assertions.assertEquals("AppleBananaCherryDog", wordStream.toString());
    }

    @Test
    public void insertWordArrayTestStart() {
        String[] words = {"Apple","Banana","Cherry"};
        String[] newWords = arrayClass.insertWordArray(words, "Ace");
        StringBuilder wordStream = new StringBuilder();
        for (String word : newWords) {
            wordStream.append(word);
        }
        Assertions.assertEquals("AceAppleBananaCherry", wordStream.toString());
    }
}
