package Lab01;

import java.util.Scanner;

public class Numberdaymonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the month (full name, abbreviation, or number): ");
            String monthInput = scanner.nextLine().toLowerCase();

            System.out.print("Enter the year: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            int month = getMonthFromInput(monthInput);

            if (month != -1 && year > 0) {
                days = getDaysInMonth(month, year);
                System.out.println("Number of days in the entered month (" + month + "/" + year + "): " + days);
                validInput = true;
            } else {
                System.out.println("Invalid month input or year. Please try again.");
            }
        }

        scanner.close();
    }
    //function
    private static int getMonthFromInput(String monthInput) {
        switch (monthInput) {
            case "january":
            case "jan.":
            case "jan":
            case "1":
            case "January":
            case "Jan.":
            case "Jan":
                return 1;
            case "february":
            case "feb.":
            case "feb":
            case "2":
            case "February":
            case "Feb.":
            case "Feb":
                return 2;
            case "march":
            case "mar.":
            case "mar":
            case "3":
            case "March":
            case "Mar.":
            case "Mar":
                return 3;
            case "april":
            case "apr.":
            case "apr":
            case "4":
            case "April":
            case "Apr.":
            case "Apr":
                return 4;
            case "may":
            case "5":
            case "May":
                return 5;
            case "june":
            case "jun.":
            case "jun":
            case "6":
            case "June":
            case "Jun.":
            case "Jun":
                return 6;
            case "july":
            case "jul.":
            case "jul":
            case "7":
            case "July":
            case "Jul.":
            case "Jul":
                return 7;
            case "august":
            case "aug.":
            case "aug":
            case "8":
            case "August":
            case "Aug.":
            case "Aug":
                return 8;
            case "september":
            case "sep.":
            case "sep":
            case "9":
            case "September":
            case "Sep.":
            case "Sep":
                return 9;
            case "october":
            case "oct.":
            case "oct":
            case "10":
            case "October":
            case "Oct.":
            case "Oct":
                return 10;
            case "november":
            case "nov.":
            case "nov":
            case "11":
            case "November":
            case "Nov.":
            case "Nov":
                return 11;
            case "december":
            case "dec.":
            case "dec":
            case "12":
            case "December":
            case "Dec.":
            case "Dec":
                return 12;
            default:
                return -1; // Invalid month
        }
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1; // Invalid month
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
