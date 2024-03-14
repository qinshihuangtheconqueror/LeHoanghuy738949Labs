package Lab01;

import javax.swing.JOptionPane;
//hi
public class CalculatorWithDialog {
    public static void main(String[] args) {
        // Input the first double number using a dialog
        String input1 = JOptionPane.showInputDialog("Enter the first double number:");
        double num1 = Double.parseDouble(input1);

        // Input the second double number using a dialog
        String input2 = JOptionPane.showInputDialog("Enter the second double number:");
        double num2 = Double.parseDouble(input2);

        // Calculate and display the sum using a dialog
        double sum = num1 + num2;
        JOptionPane.showMessageDialog(null, "Sum: " + sum);

        // Calculate and display the difference using a dialog
        double difference = num1 - num2;
        JOptionPane.showMessageDialog(null, "Difference: " + difference);

        // Calculate and display the product using a dialog
        double product = num1 * num2;
        JOptionPane.showMessageDialog(null, "Product: " + product);

        // Check if the second number is not zero before calculating the quotient
        if (num2 != 0) {
            // Calculate and display the quotient using a dialog
            double quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, "Quotient: " + quotient);
        } else {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero. Quotient is undefined.");
        }
    }
}
