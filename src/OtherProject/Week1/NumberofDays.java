package OtherProject.Week1;

import java.util.Scanner;

public class NumberofDays {
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

            int month;

            switch (monthInput) {
                case "January":
                case "Jan.":
                case "Jan":
                case "1":
                    month = 1;
                    validInput = true;
                    break;
                case "February":
                case "Feb.":
                case "Feb":
                case "2":
                    month = 2;
                    validInput = true;
                    break;
                case "March":
                case "Mar.":
                case "Mar":
                case "3":
                    month = 3;
                    validInput = true;
                    break;
                case "April":
                case "Apr.":
                case "Apr":
                case "4":
                    month = 4;
                    validInput = true;
                    break;
                case "May":
                case "5":
                    month = 5;
                    validInput = true;
                    break;
                case "June":
                case "Jun.":
                case "Jun":
                case "6":
                    month = 6;
                    validInput = true;
                    break;
                case "July":
                case "Jul.":
                case "Jul":
                case "7":
                    month = 7;
                    validInput = true;
                    break;
                case "August":
                case "Aug.":
                case "Aug":
                case "8":
                    month = 8;
                    validInput = true;
                    break;
                case "September":
                case "Sep.":
                case "Sep":
                case "9":
                    month = 9;
                    validInput = true;
                    break;
                case "October":
                case "Oct.":
                case "Oct":
                case "10":
                    month = 10;
                    validInput = true;
                    break;
                case "November":
                case "Nov.":
                case "Nov":
                case "11":
                    month = 11;
                    validInput = true;
                    break;
                case "December":
                case "Dec.":
                case "Dec":
                case "12":
                    month = 12;
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid month input. Please try again.");
                    continue;
            }

            if (year <= 0) {
                System.out.println("Invalid year input. Please enter a non-negative number.");
                validInput = false;
            } else {
                days = getDaysInMonth(month, year);
                System.out.println("Number of days in the entered month (" + monthInput + "/" + year + "): " + days);
            }
        }

        scanner.close();
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