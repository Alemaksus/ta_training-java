package com.epam.training.student_aleksandr_maksakov.go_dutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        int friends = input.nextInt();
        if (amount < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (friends <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            int tips = amount/10;
            int myPart = (amount+tips)/friends;
            System.out.println(myPart);
        }
    }
}