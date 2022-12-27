package com.epam.training.student_aleksandr_maksakov.average;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int sum = 0;
        int count = 0;
        do {
            n = scanner.nextInt();
            sum += n;
            count++;
        } while (n != 0);

        System.out.println((sum) / (count - 1));
    }
}
