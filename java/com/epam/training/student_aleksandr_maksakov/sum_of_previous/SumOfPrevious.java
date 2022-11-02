package com.epam.training.student_aleksandr_maksakov.sum_of_previous;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){

        boolean[] array2 = new boolean[array.length];
        array2[0] = false;
        array2[1] = false;
        for (int i = 2; i < array.length; i++) {
            array2[i] = array[i - 1] + array[i - 2] == array[i]; }
        return array2;
    }
}
