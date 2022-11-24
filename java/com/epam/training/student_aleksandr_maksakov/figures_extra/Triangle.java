package com.epam.training.student_aleksandr_maksakov.figures_extra;

class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    double AB;
    double AC;
    double BC;

    public Triangle(Point a, Point b, Point c) {
        if (a == null){
            throw new IllegalArgumentException();
        }

        if (b == null){
            throw new IllegalArgumentException();
        }

        if (c == null){
            throw new IllegalArgumentException();
        }

        AB = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
        AC = Math.sqrt(Math.pow((c.getX() - a.getX()), 2) + Math.pow((c.getY() - a.getY()), 2));
        BC = Math.sqrt(Math.pow((c.getX() - b.getX()), 2) + Math.pow((c.getY() - b.getY()), 2));

        if ((c.getX() - a.getX()) / (b.getX() - a.getX()) == (c.getY() - a.getY()) / (b.getY() - a.getY())){
            throw new IllegalArgumentException();
        }


        if (area() == 0){
            throw new IllegalArgumentException();
        }



        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }


    }

    public double area() {
        double s = 0.5 * (AB + AC + BC);

        return Math.sqrt(s*(s-AB)*(s-AC)*(s-BC));
    }


    @Override
    public Point centroid() {
        double x = 1.0/3.0 * (a.getX() + b.getX() + c.getX());
        double y = 1.0/3.0 * (a.getY() + b.getY() + c.getY());
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return false;
    }
}