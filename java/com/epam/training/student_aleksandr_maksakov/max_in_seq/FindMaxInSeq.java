package com.epam.training.student_aleksandr_maksakov.max_in_seq;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        // Put your code here

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int currentMax = number;

        while (true) {
            number = input.nextInt();
            if (number == 0)
                break;
            if (number >= currentMax) {
                currentMax = number;
            }
        }
        return currentMax;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
