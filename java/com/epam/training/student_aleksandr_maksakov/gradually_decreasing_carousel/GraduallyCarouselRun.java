package com.epam.training.student_aleksandr_maksakov.gradually_decreasing_carousel;

public class GraduallyCarouselRun extends CarouselRun {
    private final int[] array = GraduallyDecreasingCarousel.carouselArray;
    private int position;
    private int decrement = 1;

    @Override
    public int next() {
        if (isFinished()) {
            return -1;
        }
        while (array[position] <= 0) {
            if (position >= array.length - 1) {
                position = 0;
                decrement++;
                continue;
            }
            position++;
        }
        int currentElement = array[position];
        array[position] -= decrement;
        position++;
        if (position == array.length) {
            position = 0;
            decrement++;
        }
        return currentElement;
    }
    @Override
    public boolean isFinished() {
        for (int var: array) {
            if (var > 0) return false;
        }
        return true;
    }
}
