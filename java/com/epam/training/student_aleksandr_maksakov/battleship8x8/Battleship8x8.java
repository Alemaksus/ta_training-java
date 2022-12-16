package com.epam.training.student_aleksandr_maksakov.battleship8x8;


public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        long oneShot = 0b10000000_00000000_00000000_00000000_00000000_00000000_00000000_00000000L;
        switch (shot.charAt(0)) {
            case 'A': break;
            case 'B': oneShot >>>= 1; break;
            case 'C': oneShot >>>= 2; break;
            case 'D': oneShot >>>= 3; break;
            case 'E': oneShot >>>= 4; break;
            case 'F': oneShot >>>= 5; break;
            case 'G': oneShot >>>= 6; break;
            case 'H': oneShot >>>= 7; break;
            default: throw new IllegalArgumentException();
        }
        oneShot >>>= (8 * (shot.charAt(1) - 1));
        shots |= oneShot;
        return ships == (ships | oneShot);
    }

    public String state() {
        String shipsString = Long.toBinaryString(ships);
        String shotsString = Long.toBinaryString(shots);
        StringBuilder additionalZeros = new StringBuilder();
        if (shipsString.length() < 64) {
            additionalZeros.append("0".repeat(64 - shipsString.length()));
            shipsString = additionalZeros.append(shipsString).toString();
            additionalZeros.delete(0, additionalZeros.length());
        }
        if (shotsString.length() < 64) {
            additionalZeros.append("0".repeat(64 - shotsString.length()));
            shotsString = additionalZeros.append(shotsString).toString();
            additionalZeros.delete(0, additionalZeros.length());
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < shotsString.length(); i++) {
            if (i % 8 == 0) {
                res.append('\n');
            }
            if (shotsString.charAt(i) == '0' && shipsString.charAt(i) == '0') {
                res.append('.');
            } else if (shotsString.charAt(i) == '1' && shipsString.charAt(i) == '0') {
                res.append('×');
            } else if (shotsString.charAt(i) == '0' && shipsString.charAt(i) == '1') {
                res.append('☐');
            } else if (shotsString.charAt(i) == '1' && shipsString.charAt(i) == '1') {
                res.append('☒');
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

    }
}
