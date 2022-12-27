package com.epam.training.student_aleksandr_maksakov.sum_of_previous.task_carousel;

public class CompleteByRequestTask implements Task {
    private boolean isCompleted = false;
    private boolean isExecuted = false;

    @Override
    public void execute() {
        if (isCompleted) isExecuted = true;
    }

    @Override
    public boolean isFinished() {
        return isExecuted;
    }

    public void complete() {
        isCompleted = true;
    }
}
