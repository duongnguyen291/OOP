package OOP.labs.lab1;

import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        System.out.println("The sum: " + sum);

        double dif = num1 - num2;
        System.out.println("The difference: " + dif);

        double mul = num1 * num2;
        System.out.println("The Product: " + mul);

        if(num2 != 0){
            double div = num1 / num2;
            System.out.println("The Quotient: " + div); 
        }
        else{
            System.out.println("Can not division for zero!");
        }
        scanner.close();
    }
}
