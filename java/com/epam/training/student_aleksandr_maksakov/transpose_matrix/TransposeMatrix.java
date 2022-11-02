package com.epam.training.student_aleksandr_maksakov.transpose_matrix;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {

        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        // System.out.println(Arrays.deepToString(transpose(matrix)));
        System.out.println("Test your code here!\n");

        // Get a result of your code


    }

}
