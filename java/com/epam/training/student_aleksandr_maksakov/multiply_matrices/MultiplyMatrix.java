package com.epam.training.student_aleksandr_maksakov.multiply_matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        // Put your code here
        int m1rows = matrix1.length;
        int m1cols = matrix1[0].length;
        int m2rows = matrix2.length;
        int m2cols = matrix2[0].length;

        int[][] result = new int[m1rows][m2cols];
        for (int i = 0; i < m1rows; i++) {
            for (int j = 0; j < m2cols; j++) {
                for (int k = 0; k < m1cols; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}};

        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}};

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}