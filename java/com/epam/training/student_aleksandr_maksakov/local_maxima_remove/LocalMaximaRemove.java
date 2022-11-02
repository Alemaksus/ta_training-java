package com.epam.training.student_aleksandr_maksakov.local_maxima_remove;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int localMaxNumber = 0;
        for (int i=0; i < array.length; i++) {
            if (i == 0) {
                if (array[i] > array[i+1]) {
                    localMaxNumber++;
                }
            } else if (i == array.length-1) {
                if (array[i] > array[i-1]) {
                    localMaxNumber++;
                    System.out.println(array[i]);
                }
            } else {
                if (array[i] > array[i-1] && array[i] > array[i+1]) {
                    localMaxNumber++;
                }
            }
        }
        int[] array2 = new int[array.length - localMaxNumber];
        if (localMaxNumber != 0) {
            int notLocalMaxNumberArrayIndex = 0;
            for (int i = 0; i < array.length; i++) {
                if (i == 0) {
                    if (array[i] < array[i + 1]) {
                        System.arraycopy(array, i, array2, i, 1);
                        notLocalMaxNumberArrayIndex++;
                    }
                } else if (i == array.length-1) {
                    if (array[i] < array[i - 1]) {
                        System.arraycopy(array, i, array2, array2.length - 1, 1 );
                    }
                } else {
                    if (array[i] <= array[i-1] || array[i] <= array[i+1]) {
                        System.arraycopy(array, i, array2, notLocalMaxNumberArrayIndex, 1);
                        notLocalMaxNumberArrayIndex++;
                    }
                }
            }
        } else {
            return array;
        }
        return array2;
    }
}
