package com.github.braddle.tddspringboot;

public class Numeral {
    public String convert(int i) {

        if (i == 10) {
            return "X";
        }

        String numeral = "";

        while (i > 0) {
            if (i > 4) {
                numeral = numeral + "V";
                i = i - 5;
                continue;
            }
            numeral = numeral + "I";
            i--;
        }

        return numeral;
    }
}
