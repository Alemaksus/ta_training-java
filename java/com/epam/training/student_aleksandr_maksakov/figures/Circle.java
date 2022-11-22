package com.epam.training.student_aleksandr_maksakov.figures;

class Circle extends Figure {
    private final double radius;
    private final double x, y;

        Circle(Point center, double radius) {
        this.radius = radius;
        x = center.getX();
        y = center.getY();
        }

    @Override
    public double area() {
            return Math.PI * Math.pow(radius, 2);
            }

    @Override
    public String pointsToString() {
            return "(" + x + "," + y + ")";
            }

    @Override
    public Point leftmostPoint() {
            return new Point(x - radius, y);
            }

    @Override
    public String toString() {
            return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
            }
            }