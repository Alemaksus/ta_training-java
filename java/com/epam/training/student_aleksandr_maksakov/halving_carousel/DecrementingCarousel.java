package com.epam.training.student_aleksandr_maksakov.halving_carousel;

public class DecrementingCarousel {
    static int[] carouselArray;
    static int capacity;
    private boolean isCarouselRunning = false;
    private int carouselRunCounter = 0;
    int counter = 0;

    public DecrementingCarousel(int capacity) {
        DecrementingCarousel.capacity = capacity;
        carouselArray = new int[capacity];
    }

    public boolean addElement(int element){
        if (counter < capacity && element > 0 && !isCarouselRunning) {
            carouselArray[counter] = element;
            counter++;
            return true;
        }
        return false;
    }

    public CarouselRun run(){
        if (carouselRunCounter == 0) {
            isCarouselRunning = true;
            carouselRunCounter++;
            return new CarouselRun();
        }
        return null;
    }
}