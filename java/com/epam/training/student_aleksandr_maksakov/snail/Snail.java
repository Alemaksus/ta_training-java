package com.epam.training.student_aleksandr_maksakov.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args) {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int h = input.nextInt();

        if (a >= h) {
            System.out.println(1);
        } else if (a <= b) {
            System.out.println("Impossible");
        } else {
            int computer = 0;
            int dayTrip = 0;
            while (dayTrip < h) {
                computer++;
                dayTrip = dayTrip + a;
                if (dayTrip >= h) {
                    break;
                } else {
                    dayTrip = dayTrip - b;
                }
            }
            System.out.println(computer);
        }
    }
}
