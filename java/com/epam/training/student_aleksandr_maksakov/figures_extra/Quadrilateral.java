package com.epam.training.student_aleksandr_maksakov.figures_extra;
import java.awt.geom.Line2D;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    double AB;
    double BC;
    double CD;
    double AD;
    double digAC;
    double digBD;


    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null){
            throw new IllegalArgumentException();
        }

        AB = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
        BC = Math.sqrt(Math.pow((c.getX() - b.getX()), 2) + Math.pow((c.getY() - b.getY()), 2));
        CD = Math.sqrt(Math.pow((d.getX() - c.getX()), 2) + Math.pow((d.getY() - c.getY()), 2));
        AD = Math.sqrt(Math.pow((d.getX() - a.getX()), 2) + Math.pow((d.getY() - a.getY()), 2));

        digAC = Math.sqrt(Math.pow((c.getX() - a.getX()), 2) + Math.pow((c.getY() - a.getY()), 2));
        digBD = Math.sqrt(Math.pow((d.getX() - b.getX()), 2) + Math.pow((d.getY() - b.getY()), 2));



        if (((a.getX() - b.getX()) / (c.getX() - b.getX()) ==
                ((a.getY() - b.getY()) / (c.getY() - b.getY()))) &&

                ((b.getX() - c.getX()) / (d.getX() - c.getX()) ==
                        (b.getY() - c.getY()) / (d.getY() - c.getY())) &&

                ((c.getX() - d.getX()) / (a.getX() - d.getX()) ==
                        (c.getY() - d.getY()) / (a.getY() - d.getY())) &&


                ((d.getX() - a.getX()) / (b.getX() - c.getX()) ==
                        (d.getY() - a.getY()) / (b.getY() - c.getY()))){
            throw new IllegalArgumentException();
        }

        if(((a.getX()-c.getX())/(b.getX()-c.getX()) == (a.getY()-c.getY())/(b.getY()-c.getY()))){
            throw new IllegalArgumentException();
        }


        if ((AB + BC) == digAC){
            throw new IllegalArgumentException();
        }


        if (!Line2D.linesIntersect(a.getX(), a.getY(), c.getX(), c.getY(), d.getX(), d.getY(), b.getX(), b.getY())){
            throw new IllegalArgumentException();
        }



        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double area() {
        return 0.25 * Math.sqrt(4.0 * Math.pow(digAC, 2) * Math.pow(digBD, 2) - Math.pow((Math.pow(AB, 2) + Math.pow(CD, 2) - Math.pow(BC, 2) - Math.pow(AD, 2)), 2));
    }




    @Override
    public Point centroid() {
        Point A = new Point(a.getX(), a.getY());
        Point B = new Point(b.getX(), b.getY());
        Point D = new Point(d.getX(), d.getY());
        Point C = new Point(c.getX(), c.getY());

        Triangle ABD = new Triangle(A, B, D);
        Triangle BCD = new Triangle(B, C, D);

        Point p = ABD.centroid();
        Point q = BCD.centroid();

        double g = ABD.area();
        double h = BCD.area();

        double x = (g * p.getX() + h * q.getX()) / (g + h);
        double y = (g * p.getY() + h * q.getY()) / (g + h);

        return new Point(x, y);

    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure.getClass() == Triangle.class){
            return false;
        }

        if (figure.getClass() == Circle.class){
            return false;
        }

        Quadrilateral quadrilateral = (Quadrilateral) figure;

        BigDecimal ax = new BigDecimal(Double.toString(this.a.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal bx = new BigDecimal(Double.toString(this.b.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal cx = new BigDecimal(Double.toString(this.c.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal dx = new BigDecimal(Double.toString(this.d.getX())).setScale(1, RoundingMode.HALF_UP);

        BigDecimal a2x = new BigDecimal(Double.toString(quadrilateral.a.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b2x = new BigDecimal(Double.toString(quadrilateral.b.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal c2x = new BigDecimal(Double.toString(quadrilateral.c.getX())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal d2x = new BigDecimal(Double.toString(quadrilateral.d.getX())).setScale(1, RoundingMode.HALF_UP);

        BigDecimal ay = new BigDecimal(Double.toString(this.a.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal by = new BigDecimal(Double.toString(this.b.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal cy = new BigDecimal(Double.toString(this.c.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal dy = new BigDecimal(Double.toString(this.d.getY())).setScale(1, RoundingMode.HALF_UP);

        BigDecimal a2y = new BigDecimal(Double.toString(quadrilateral.a.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal b2y = new BigDecimal(Double.toString(quadrilateral.b.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal c2y = new BigDecimal(Double.toString(quadrilateral.c.getY())).setScale(1, RoundingMode.HALF_UP);
        BigDecimal d2y = new BigDecimal(Double.toString(quadrilateral.d.getY())).setScale(1, RoundingMode.HALF_UP);


        return (ax.equals(a2x) || ax.equals(b2x) || ax.equals(c2x) || ax.equals(d2x)) &&
                (bx.equals(a2x) || bx.equals(c2x) || bx.equals(d2x) || bx.equals(b2x)) &&
                (cx.equals(a2x) || cx.equals(b2x) || cx.equals(d2x) || cx.equals(c2x)) &&
                (dx.equals(a2x) || dx.equals(b2x) || dx.equals(c2x) || dx.equals(d2x)) &&

                (ay.equals(a2y) || ay.equals(b2y) || ay.equals(c2y) || ay.equals(d2y)) &&
                (by.equals(a2y) || by.equals(c2y) || by.equals(d2y) || by.equals(b2y)) &&
                (cy.equals(a2y) || cy.equals(b2y) || cy.equals(d2y) || cy.equals(c2y)) &&
                (dy.equals(a2y) || dy.equals(b2y) || dy.equals(c2y) || dy.equals(d2y));
    }
}