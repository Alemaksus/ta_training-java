package com.epam.training.student_aleksandr_maksakov.spiral;

class Spiral {
    public static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];

        int number = 1;
        int max = rows * columns;

        int rmin = 0, rmax = rows - 1;
        int cmin = 0, cmax = columns - 1;

        while (number <= max) {
            // проход влево по верхней строке, инкремент столбцов
            for (int i = cmin; number <= max && i <= cmax; i++) {
                array[rmin][i] = number++;
            }
            rmin++;
            // проход вниз по правому краю, инкремент строк
            for (int i = rmin; number <= max && i <= rmax; i++) {
                array[i][cmax] = number++;
            }
            cmax--;
            // проход вправо по нижней строке, декремент столбцов
            for (int i = cmax; number <= max && i >= cmin; i--) {
                array[rmax][i] = number++;
            }
            rmax--;
            // проход вверх по левому краю, декремент строк
            for (int i = rmax; number <= max && i >= rmin; i--) {
                array[i][cmin] = number++;
            }
            cmin++;
        }

        return array;
    }

    public static void main(String[] args) {

        int[][] spiral = Spiral.spiral(5, 5);

        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.print(String.format("%4s", spiral[i][j]));
            }
            System.out.println();
        }
    }
}