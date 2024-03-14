package Lab01;

import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       //****
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. First-degree equation (Linear equation)");
            System.out.println("2. System of first-degree equations with two variables");
            System.out.println("3. Second-degree equation (Quadratic equation)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    solveLinearEquation(scanner);
                    break;
                case 2:
                    solveSystemOfEquations(scanner);
                    break;
                case 3:
                    solveQuadraticEquation(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
//solved
    private static void solveLinearEquation(Scanner scanner) {
        System.out.println("First-degree equation (Linear equation) with one variable (ax+b=0):");
        System.out.print("Enter the value for a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the value for b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double x = -b / a;
            System.out.println("Solution is: x =" + x);
        } else if (b == 0) {
            System.out.println("Infinite solutions (0x = 0 for any x)");
        } else {
            System.out.println("No solution (0x = " + b + ")");
        }
    }

    private static void solveSystemOfEquations(Scanner scanner) {
        System.out.println("System of first-degree equations with two variables:");
        System.out.print("Enter the values for a11, a12, b1, a21, a22, b2 (separated by spaces): ");
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        double determinant = a11 * a22 - a12 * a21;

        if (determinant != 0) {
            double x = (b1 * a22 - b2 * a12) / determinant;
            double y = (a11 * b2 - a21 * b1) / determinant;
            System.out.println("Unique solution: x = " + x + ", y = " + y);
        } else if ((b1 * a22 - b2 * a12 == 0) && (a11 * b2 - a21 * b1 == 0)) {
            System.out.println("Infinite solutions (Dependent equations)");
        } else {
            System.out.println("No solution (Inconsistent system)");
        }
    }
//hhihihi
    private static void solveQuadraticEquation(Scanner scanner) {
        System.out.println("Second-degree equation with one variable (Quadratic equation):");
        System.out.print("Enter the values for a, b, c (separated by spaces): ");
        double quadA = scanner.nextDouble();
        double quadB = scanner.nextDouble();
        double quadC = scanner.nextDouble();

        double discriminant = quadB * quadB - 4 * quadA * quadC;

        if (discriminant > 0) {
            double root1 = (-quadB + Math.sqrt(discriminant)) / (2 * quadA);
            double root2 = (-quadB - Math.sqrt(discriminant)) / (2 * quadA);
            System.out.println("Two distinct real roots: x1 = " + root1 + ", x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -quadB / (2 * quadA);
            System.out.println("One real root (double root): x = " + root);
        } else {
            System.out.println("No real roots (Complex roots)");
        }
    } //hu//
}
