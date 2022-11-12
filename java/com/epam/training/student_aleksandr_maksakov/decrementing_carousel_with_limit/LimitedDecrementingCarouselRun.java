package com.epam.training.student_aleksandr_maksakov.decrementing_carousel_with_limit;

public class LimitedDecrementingCarouselRun extends CarouselRun {
    private final int[] decrementingArray = DecrementingCarouselWithLimitedRun.carouselArray;
    private final int actionLimit = DecrementingCarouselWithLimitedRun.actionLimit;
    private boolean flag = false;
    int actions = 0;

    @Override
    public int next() {
        if (isFinished()) {
            return -1;
        }
        if (position == decrementingArray.length) {
            position = 0;
        }
        while (decrementingArray[position] <= 0) {
            position++;
            if (position == decrementingArray.length) {
                position = 0;
            }
        }
        actions++;
        if (actions == actionLimit) {
            flag = true;
        }
        return decrementingArray[position++]--;
    }

    @Override
    public boolean isFinished() {
        if (!flag) {
            for (int var : decrementingArray) {
                if (var > 0) return false;
            }
            return true;
        }
        else {
            return actions == actionLimit;
        }
    }
}