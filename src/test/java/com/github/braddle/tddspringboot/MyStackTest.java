package com.github.braddle.tddspringboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    void newSetIsEmpty() {
        MySet empty = new MySet();

        assertTrue(empty.isEmpty());
    }

    @Test
    void addSomethingSetNotEmpty() {
        MySet one = new MySet();
        one.add("blue");

        assertFalse(one.isEmpty());
    }

    @Test
    void size() {
        MySet empty = new MySet();

        MySet one = new MySet();
        one.add("blue");

        MySet two = new MySet();
        two.add("blue");
        two.add("red");

        assertEquals(0, empty.size());
        assertEquals(1, one.size());
        assertEquals(2, two.size());
    }
}
