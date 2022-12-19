package com.epam.training.student_aleksandr_maksakov.optional_max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if (values == null || values.length == 0) {
            return OptionalInt.empty();
        }
        int max = values[0];

        for (int el : values) {
            if (el > max) {
                max = el;
            }
        }
        return OptionalInt.of(max);
    }
}
