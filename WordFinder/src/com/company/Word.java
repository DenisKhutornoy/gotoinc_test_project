package com.company;

public class Word {

    private String value;
    private int count;


    public Word(String value, int count) {
        this.value = value;
        this.count = count;
    }

    public String toString() {
        return value + " - " + count;
    }
}
