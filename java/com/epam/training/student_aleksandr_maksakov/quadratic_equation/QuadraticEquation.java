package com.epam.training.student_aleksandr_maksakov.quadratic_equation;

import java.util.Locale;
import java.util.Scanner;



public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        final double discriminant = (b * b) - (4 * a * c);

        if (discriminant > 0) {

            double result = (-(b) - (Math.pow(discriminant, 0.5))) / (2 * a);
            double result2 = (-(b) + (Math.pow(discriminant, 0.5))) / (2 * a);
            System.out.print(result + " " + result2);

        }

        else if (discriminant == 0) {

            double result = -b / 2 * a;
            System.out.print((int)result);
        }

        else {

            System.out.print("no roots");

        }

    }

}
