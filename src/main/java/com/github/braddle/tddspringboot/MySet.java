package com.github.braddle.tddspringboot;

public class MySet {

    private int size = 0;
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String value) {
        size++;
    }

    public int size() {
        return size;
    }
}
