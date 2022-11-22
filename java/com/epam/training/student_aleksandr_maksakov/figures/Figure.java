package com.epam.training.student_aleksandr_maksakov.figures;
abstract class Figure{

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {

        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();
}
