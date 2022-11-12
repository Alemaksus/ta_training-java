package com.epam.training.student_aleksandr_maksakov.gradually_decreasing_carousel;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    private boolean isCarouselRunning = false;
    private int carouselRunCounter = 0;
    static int[] carouselArray;
    int counter = 0;
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
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
            return new GraduallyCarouselRun();
        }
        return null;
    }
}
