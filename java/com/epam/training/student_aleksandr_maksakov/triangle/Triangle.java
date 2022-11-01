package com.epam.training.student_aleksandr_maksakov.triangle;

class Triangle {
    Point a,b,c;
    double length1,length2,length3;
    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException("Arguments can't be null");
        }

        this.a = a;
        this.b = b;
        this.c = c;

        length1 = length1();
        length2 = length2();
        length3 = length3();

        if (area() == 0.0) {
            throw new IllegalArgumentException("Triangle is degenerative");
        }

    }
    Point centroid(){
        double xc= (((a.getX() + b.getX() + c.getX()) / 3));
        double yc= (((a.getY() + b.getY() + c.getY()) / 3));
        return new Point(xc, yc);
    }

    private double length1() {
        double xLengthSquared = Math.pow(a.getX() - b.getX(), 2);
        double yLengthSquared = Math.pow(a.getY() - b.getY(), 2);
        return Math.sqrt(xLengthSquared + yLengthSquared);
    }
    double length2() {
        double xLengthSquared = Math.pow(a.getX() - c.getX(), 2);
        double yLengthSquared = Math.pow(a.getY() - c.getY(), 2);
        return Math.sqrt(xLengthSquared + yLengthSquared);
    }
    double length3() {
        double xLengthSquared = Math.pow(c.getX() - b.getX(), 2);
        double yLengthSquared = Math.pow(c.getY() - b.getY(), 2);
        return Math.sqrt(xLengthSquared + yLengthSquared);
    }

    public double area() {
        // return (length1 + length2 + length3) / 2;
        return Math.abs(0.5*((c.getX() - a.getX()) * (b.getY() - a.getY()) - (c.getY() - a.getY()) * (b.getX() -
                a.getX())));
    }
}
