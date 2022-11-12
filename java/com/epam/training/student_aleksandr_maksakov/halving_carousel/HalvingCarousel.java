package com.epam.training.student_aleksandr_maksakov.halving_carousel;

public class HalvingCarousel extends DecrementingCarousel {

    static int[] carouselArray;
    private boolean isCarouselRunning = false;
    private int carouselRunCounter = 0;

    public HalvingCarousel(final int capacity) {
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
            return new HalvingCarouselRun();
        }
        return null;
    }
}