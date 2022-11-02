package com.epam.training.student_aleksandr_maksakov.cycle_swap;

import java.util.Arrays;

class CycleSwap {
    public static void main(String[] args) {
        int[] array = new int[]{ 1, 3, 2, 7, 4 };
        int shift = 2;
        CycleSwap.cycleSwap(array, shift);
        System.out.println(Arrays.toString(array));
    }

    static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    static void cycleSwap(int[] array, int shift) {
        int[] arr2 = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = arr2[(array.length + i - shift) % array.length];
        }

    }
}
