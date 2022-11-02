package com.epam.training.student_aleksandr_maksakov.segments;

import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Segment)) return false;
        Segment segment = (Segment) o;
        return start.equals(segment.start) && end.equals(segment.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;

        if (start == null || end == null) {
            throw new IllegalArgumentException("Arguments can't be null");
        }
        if (start.equals(end)) {
            throw new IllegalArgumentException("The points must be different");
        }
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
    }

    double length() {
        double xLengthSquared = Math.pow(end.getX() - start.getX(), 2);
        double yLengthSquared = Math.pow(end.getY() - start.getY(), 2);
        return Math.sqrt(xLengthSquared + yLengthSquared);
    }

    Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    Point intersection(Segment another) {
        Point start2 = another.start;
        Point end2 = another.end;

        double v = ((((start.getX() - start2.getX()) * (start2.getY() - end2.getY()))
                - ((start.getY() - start2.getY()) * (start2.getX() - end2.getX())))
                / ((((start.getX() - end.getX()) * (start2.getY() - end2.getY()))
                - ((start.getY() - end.getY()) * (start2.getX() - end2.getX())))));

        double s = ((((start.getX() - start2.getX()) * (start.getY() - end.getY()))
                - ((start.getY() - start2.getY()) * (start.getX() - end.getX())))
                / ((((start.getX() - end.getX()) * (start2.getY() - end2.getY()))
                - ((start.getY() - end.getY()) * (start2.getX() - end2.getX())))));

        double x = (start.getX() + v * (end.getX() - start.getX()));
        double y = (start.getY() + v * (end.getY() - start.getY()));

        if (0.0 <= v && v <= 1.0 && 0.0 <= s && s <= 1.0) {
            return new Point(x, y);
        } else {
            return null;
        }
    }
}
