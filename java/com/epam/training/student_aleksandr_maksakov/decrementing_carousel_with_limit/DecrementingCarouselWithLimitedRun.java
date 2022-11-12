package com.epam.training.student_aleksandr_maksakov.decrementing_carousel_with_limit;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    static int actionLimit;
    static int[] carouselArray;
    private boolean isCarouselRunning = false;
    private int carouselRunCounter = 0;
    int counter = 0;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        DecrementingCarouselWithLimitedRun.actionLimit = actionLimit;
        carouselArray = new int[capacity];
    }

    @Override
    public boolean addElement(int element) {
        if (counter < capacity && element > 0 && !isCarouselRunning) {
            carouselArray[counter] = element;
            counter++;
            return true;
        }
        return false;
    }

    @Override
    public CarouselRun run() {
        if (carouselRunCounter == 0) {
            isCarouselRunning = true;
            carouselRunCounter++;
            return new LimitedDecrementingCarouselRun();
        }
        return null;
    }
}