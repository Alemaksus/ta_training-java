package com.epam.training.student_aleksandr_maksakov.meet_a_stranger;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {
        //Write a program, which read a String from System.in and print "Hello, <input string>"
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("Hello, " + input);
    }
}
