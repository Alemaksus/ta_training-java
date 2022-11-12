package com.epam.training.student_aleksandr_maksakov.halving_carousel;

public class CarouselRun {


    int[] array = DecrementingCarousel.carouselArray;
    int position = 0;

    public int next() {
        int count = 0;
        while (count < array.length && array[position %= array.length] <= 0) {
            position++;
            count++;
        }
        if (count == array.length) return -1;
        return array[position++]--;
    }

    public boolean isFinished() {
        for (int el: array) {
            if (el > 0) return false;
        }
        return true;
    }

}