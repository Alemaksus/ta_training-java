package com.epam.training.student_aleksandr_maksakov.max;

public class MaxMethod {
    public static int max(int[] values) {
        int res = values[0];
        for (int i = 1; i < values.length; ++i) {
            if (values[i] > res) {
                res = values[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int[] intArray = { -2, 0, 10, 5};
        System.out.println(max(intArray));

    }
}