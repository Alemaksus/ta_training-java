package com.epam.training.student_aleksandr_maksakov.pizza_split;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int slicesInPizza = scanner.nextInt();

        int pizza = 1;
        int countOfPiec = slicesInPizza;

        while(people > 0) {
            slicesInPizza = countOfPiec;
            slicesInPizza *= pizza;
            if(slicesInPizza % people == 0){
                break;
            }
            pizza++;
        }
        System.out.println(pizza);
    }
}

