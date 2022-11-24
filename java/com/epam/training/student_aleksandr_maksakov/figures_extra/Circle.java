package com.epam.training.student_aleksandr_maksakov.figures_extra;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static java.lang.Math.sqrt;
class Circle extends Figure {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0){
            throw new IllegalArgumentException();
        }

        if (center == null){
            throw new IllegalArgumentException();
        }

        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public String pointsToString() {
        return "(" + center.getX() + "," + center.getY() + ")";
    }

    public Point leftmostPoint() {
        double x = center.getX() - radius;
        return new Point(x, center.getY());
    }

    @Override
    public String toString() {
        return "Circle[" + "(" + center.getX() + "," + center.getY() + ")" + radius + "]";
    }

    @Override
    public Point centroid() {
        return new Point(center.getX(), center.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() == Triangle.class){
            return false;
        }

        if (figure.getClass() == Quadrilateral.class){
            return false;
        }

        Circle circle = (Circle) figure;

        BigDecimal x = new BigDecimal(Double.toString(circle.center.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal y = new BigDecimal(Double.toString(circle.center.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal r1 = new BigDecimal(Double.toString(circle.radius)).setScale(1, RoundingMode.HALF_UP);

        BigDecimal x2 = new BigDecimal(Double.toString(this.center.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal y2 = new BigDecimal(Double.toString(this.center.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal r2 = new BigDecimal(Double.toString(this.radius)).setScale(1, RoundingMode.HALF_UP);


        return (x.equals(x2)) && (y.equals(y2)) && (r1.equals(r2));
    }
}