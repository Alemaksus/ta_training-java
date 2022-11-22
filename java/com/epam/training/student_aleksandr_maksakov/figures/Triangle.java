package com.epam.training.student_aleksandr_maksakov.figures;

class Triangle extends Figure {
    private final double x1, x2, x3, y1, y2, y3;

    Triangle(Point a, Point b, Point c) {
        x1 = a.getX();
        x2 = b.getX();
        x3 = c.getX();
        y1 = a.getY();
        y2 = b.getY();
        y3 = c.getY();
    }

    @Override
    public double area() {
        return 0.5 * Math.abs((x1 - x3) * (y2 - y1) - (x1 - x2) * (y3 - y1));
    }

    @Override
    public String pointsToString() {
        return "(" + x1 + "," + y1 + ")" + "(" + x2 + "," + y2 + ")" + "(" + x3 + "," + y3 + ")";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(findMinX(), findYForMinX());
    }

    private double findMinX() {
        return Math.min(x1, Math.min(x2, x3));
    }

    private double findYForMinX() {
        if (findMinX() == x1) {
            return x1;
        } else if (findMinX() == x2) {
            return y2;
        } else {
            return y3;
        }
    }
}
