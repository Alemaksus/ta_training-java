package com.epam.training.student_aleksandr_maksakov.halving_carousel;

public class HalvingCarouselRun extends CarouselRun{

    int position = 0;
    int sum = 0;
    int[] halvingArray = HalvingCarousel.carouselArray;

    HalvingCarouselRun() {
        for (int element: halvingArray) {
            sum += element;
        }
    }

    @Override
    public int next() {

        int count = 0;
        int currentItem;
        while (count < halvingArray.length && halvingArray[position %= halvingArray.length] <= 0) {
            count++;
            position++;
        }
        if (count == halvingArray.length) return -1;
        currentItem = halvingArray[position];
        halvingArray[position] /= 2;
        sum = sum - halvingArray[position] - currentItem % 2;
        position++;
        return currentItem;
    }

    @Override
    public boolean isFinished() {
        for (int var: halvingArray) {
            if (var > 0) return false;
        }
        return true;
    }
}