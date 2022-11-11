package com.github.braddle.tddspringboot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumeralTest {

    @Test
    void oneIsI() {
        Numeral n = new Numeral();

        assertEquals("I", n.convert(1));
    }

    @Test
    void twoIsII() {
        Numeral n = new Numeral();

        assertEquals("II", n.convert(2));
    }

    @Test
    void threeIsIII() {
        Numeral n = new Numeral();

        assertEquals("III", n.convert(3));
    }

    @Test
    void fiveIsV() {
        Numeral n = new Numeral();

        assertEquals("V", n.convert(5));
    }

    @Test
    void TenIsX() {
        Numeral n = new Numeral();

        assertEquals("X", n.convert(10));
    }

    @Test
    void sixIsVI() {
        Numeral n = new Numeral();

        assertEquals("VI", n.convert(6));
    }

    @Test
    void sevenIsVII() {
        Numeral n = new Numeral();

        assertEquals("VII", n.convert(7));
    }

    @Test
    void eightIsVIII() {
        Numeral n = new Numeral();

        assertEquals("VIII", n.convert(8));
    }
}
