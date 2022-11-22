package com.epam.training.student_aleksandr_maksakov.figures;

class Quadrilateral extends Figure {
    private final double x1, x2, x3, x4, y1, y2, y3, y4;

    Quadrilateral(Point a, Point b, Point c, Point d) {
        x1 = a.getX();
        x2 = b.getX();
        x3 = c.getX();
        x4 = d.getX();
        y1 = a.getY();
        y2 = b.getY();
        y3 = c.getY();
        y4 = d.getY();
    }

    @Override
    public double area() {
        return 0.5 * Math.abs((x1*y2 + x2*y3 + x3*y4 + x4*y1) - (x2*y1 + x3*y2 + x4*y3 + x1*y4));
    }

    @Override
    public String pointsToString() {
        return "(" + x1 + "," + y1 + ")" + "(" + x2 + "," + y2 + ")" + "(" + x3 + "," + y3 + ")" + "(" + x4 + "," + y4 + ")";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(findMinX(), findYForMinX());
    }

    private double findMinX() {
        return Math.min(x1, Math.min(x2, Math.min(x3, x4)));
    }

    private double findYForMinX() {
        if (findMinX() == x1) {
            return x1;
        } else if (findMinX() == x2) {
            return y2;
        } else if (findMinX() == x3){
            return y3;
        } else {
            return y4;
        }
    }
}