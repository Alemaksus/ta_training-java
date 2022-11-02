package com.epam.training.student_aleksandr_maksakov.line_intersection;

public class Line {
    final int k;
    final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        // throw new UnsupportedOperationException();
        if (this.k == other.k) {
            return null;
        }
        int x = (other.b - this.b) / (this.k - other.k);
        int y = this.k * x + this.b;
        return new Point(x, y);
        }
}

