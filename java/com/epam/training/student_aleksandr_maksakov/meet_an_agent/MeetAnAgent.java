package com.epam.training.student_aleksandr_maksakov.meet_an_agent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here
        Scanner reply = new Scanner(System.in);
        int agentPass = reply.nextInt();
        if (agentPass == PASSWORD) {
            System.out.print("Hello, Agent");
        } else {
            System.out.print("Access denied");
        }
    }
}
