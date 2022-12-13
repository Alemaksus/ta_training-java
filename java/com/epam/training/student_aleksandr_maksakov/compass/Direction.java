package com.epam.training.student_aleksandr_maksakov.compass;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;
    private static int toRange(int degrees) {
        while (degrees < 0) degrees += 360;
        return degrees % 360;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = toRange(degrees);
        for (Direction dir: Direction.values()) {
            if (dir.degrees == degrees)
                return dir;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = toRange(degrees);
        if (degrees < 25) return N;
        else if (degrees < 70) return NE;
        else if (degrees < 115) return E;
        else if (degrees < 150) return SE;
        else if (degrees < 205) return S;
        else if (degrees < 250) return SW;
        else if (degrees < 295) return W;
        else if (degrees < 340) return NW;
        return N;
    }

    public Direction opposite() {
        switch (this) {
            case N:
                return S;
            case NE:
                return SW;
            case E:
                return W;
            case SE:
                return NW;
            case S:
                return N;
            case SW:
                return NE;
            case W:
                return E;
            case NW:
                return SE;
        }
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(this.degrees - direction.degrees);
        return Math.min(difference, 360 - difference);
    }
}