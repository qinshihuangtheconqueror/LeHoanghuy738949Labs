import java.util.Scanner;

public class Numberdaymonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year, month;

        do {
            System.out.print("Enter the year (e.g., 2022): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid numerical value for the year.");
                scanner.next();
            }
            year = scanner.nextInt();

            System.out.print("Enter the month (1-12): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid numerical value for the month.");
                scanner.next();
            }
            month = scanner.nextInt();

            if (month < 1 || month > 12) {
                System.out.println("Invalid month. Please enter a number between 1 and 12.");
            }
        } while (month < 1 || month > 12);

        displayDaysInMonth(year, month);

        scanner.close();
    }

    private static void displayDaysInMonth(int year, int month) {
        try {
            int daysInMonth = java.time.YearMonth.of(year, month).lengthOfMonth();
            System.out.printf("The number of days in %s, %d is %d days.%n",
                    java.time.Month.of(month), year, daysInMonth);
        } catch (java.time.DateTimeException e) {
            System.out.println("Invalid year. Please enter a valid year.");
        }
    }
}
