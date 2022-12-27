package com.epam.training.student_aleksandr_maksakov.sum_of_previous.task_carousel;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private final int MAX_COUNTER;
    private int spinCounter = 0;
    private final List<Task> myList = new ArrayList<>();

    public TaskCarousel(int capacity) {
        if (capacity < 0) {
            throw new UnsupportedOperationException();
        }
        MAX_COUNTER = capacity;
    }

    public boolean addTask(Task task) {
        if (!isFull() && !task.isFinished()) {
            myList.add(task);
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        rewriteSpinCounter();
        myList.get(spinCounter).execute();
        if (myList.get(spinCounter).isFinished()) {
            myList.remove(spinCounter);
        } else {
            spinCounter++;
        }
        return true;
    }

    public boolean isFull() {
        return myList.size() == MAX_COUNTER;
    }

    public boolean isEmpty() {
        return myList.size() == 0;
    }
    private void rewriteSpinCounter() {
        if (spinCounter >= myList.size()) spinCounter = 0;
    }

}
