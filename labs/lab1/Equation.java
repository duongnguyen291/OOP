package OOP.labs.lab1;

import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose the type of equation!");
            System.out.println("1. The first-degree equation (linear equation) with one variable");
            System.out.println("2. The system of first-degree equations (linear system) with two variables");
            System.out.println("3. The second-degree equation with one variable");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    solveFirstDegreeEquation();
                    break;
                case 2:
                    solveLinearSystem();
                    break;
                case 3:
                    solveSecondDegreeEquation();
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    private static void solveFirstDegreeEquation() {
        Scanner scanner = new Scanner(System.in);
        // Implement solving first-degree equation logic here
        System.out.println("Solving first-degree equation: ax + b = 0");
        System.out.println("Enter a: ");
        int a =  scanner.nextInt();
        System.out.println("Enter b: ");
        int b =  scanner.nextInt();
        if(a == 0){
            if(b==0) System.out.println("Infinity solution");
            else System.out.println("No solution");
        }
        else {
            double sol = - b /a;
            System.out.println("The solution is: " + sol);
        }
    }

    private static void solveLinearSystem() {
        // Implement solving linear system logic here
        // A system of first-degree equations with two variables x and y can be written as follows:
        // ax + by = c
        // dx + ey = f
        // You should prompt the user to enter the coefficients a, b, c, d, e, and f,
        // and then solve the system of equations using appropriate mathematical techniques.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving linear system of equations (ax + by = c, dx + ey = f)");
        System.out.println("Enter coefficients for the first equation (ax + by = c):");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        System.out.println("Enter coefficients for the second equation (dx + ey = f):");
        System.out.print("Enter d: ");
        double d = scanner.nextDouble();
        System.out.print("Enter e: ");
        double e = scanner.nextDouble();
        System.out.print("Enter f: ");
        double f = scanner.nextDouble();
        
        double determinant = a * e - b * d;
        if (determinant == 0) {
            System.out.println("This system of equations has no unique solution.");
        } else {
            double x = (c * e - b * f) / determinant;
            double y = (a * f - c * d) / determinant;
            System.out.println("The solution for the system of equations is:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }
    
    private static void solveSecondDegreeEquation() {
        // Implement solving second-degree equation logic here
        // A second-degree equation with one variable (i.e., quadratic equation) can have a form such as ax^2 + bx + c = 0,
        // where x is the variable, and a, b, and c are coefficients (a ≠ 0).
        // You should prompt the user to enter the coefficients a, b, and c,
        // and then solve the equation using the quadratic formula.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Solving second-degree equation (ax^2 + bx + c = 0)");
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        if (a == 0) {
            System.out.println("This is not a second-degree equation.");
            scanner.close();
            return;
        }
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
    
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are real and distinct:");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The root is real and equal:");
            System.out.println("Root = " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("The roots are complex:");
            System.out.println("Root 1 = " + realPart + " + " + imaginaryPart + "i");
            System.out.println("Root 2 = " + realPart + " - " + imaginaryPart + "i");
        }
    }
}
