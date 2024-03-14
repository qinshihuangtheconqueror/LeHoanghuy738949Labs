package Lab01;

import java.util.Scanner;
//calculator
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first double number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second double number: ");
        double num2 = scanner.nextDouble();


        double sum = num1 + num2;
        System.out.println("Sum: " + sum);

        double difference = num1 - num2;
        System.out.println("Difference: " + difference);


        double product = num1 * num2;
        System.out.println("Product: " + product);

        if (num2 != 0) {

            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot divide by zero. Quotient is undefined.");
        }


        scanner.close();
    }
}
