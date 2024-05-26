package OOP.labs.lab1;
import java.util.Scanner;

public class MonthDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arrays to hold month names, abbreviations, and number representations
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthAbbreviations = {"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
        String[] monthThreeLetter = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] monthNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        
        int month;
        int year;
        
        while (true) {
            System.out.print("Enter the month: ");
            String inputMonth = scanner.nextLine().trim();
            
            // Convert the input month to lowercase for case-insensitive comparison
            inputMonth = inputMonth.toLowerCase();
            
            // Check if the input month is valid
            if (isValidMonth(inputMonth, monthNames, monthAbbreviations, monthNumbers, monthThreeLetter)) {
                month = getMonthIndex(inputMonth, monthNames, monthAbbreviations, monthNumbers,monthThreeLetter) + 1; // Adding 1 because month index starts from 0
                break;
            } else {
                System.out.println("Invalid month. Please enter again.");
            }
        }
        
        while (true) {
            System.out.print("Enter the year: ");
            String inputYear = scanner.nextLine().trim();
            
            // Check if the input year is valid
            if (isValidYear(inputYear)) {
                year = Integer.parseInt(inputYear);
                break;
            } else {
                System.out.println("Invalid year. Please enter again.");
            }
        }
        
        // Calculate and display the number of days in the entered month and year
        int daysInMonth = calculateDaysInMonth(month, year);
        System.out.println("Number of days in " + monthNames[month - 1] + " " + year + ": " + daysInMonth);
        
        scanner.close();
    }
    
    // Method to check if the entered month is valid
    public static boolean isValidMonth(String inputMonth, String[] monthNames, String[] monthAbbreviations, String[] monthNumbers, String[] monthThreeLetter) {
        for (String month : monthNames) {
            if (month.toLowerCase().equals(inputMonth)) {
                return true;
            }
        }
        for (String month : monthAbbreviations) {
            if (month.toLowerCase().equals(inputMonth)) {
                return true;
            }
        }
        for (String month : monthNumbers) {
            if (month.equals(inputMonth)) {
                return true;
            }
        }
        for (String month : monthThreeLetter) {
            if (month.toLowerCase().equals(inputMonth)) {
                return true;
            }
        }
        for (String month : monthNumbers) {
            if (month.equals(inputMonth)) {
                return true;
            }
        }
        return false;
    }
    
    // Method to get the index of the entered month
    public static int getMonthIndex(String inputMonth, String[] monthNames, String[] monthAbbreviations, String[] monthNumbers, String[] monthThreeLetter) {
        for (int i = 0; i < monthNames.length; i++) {
            if (monthNames[i].toLowerCase().equals(inputMonth)) {
                return i;
            }
        }
        for (int i = 0; i < monthAbbreviations.length; i++) {
            if (monthAbbreviations[i].toLowerCase().equals(inputMonth)) {
                return i;
            }
        }
        for (int i = 0; i < monthNumbers.length; i++) {
            if (monthNumbers[i].equals(inputMonth)) {
                return i;
            }
        }
        for (int i = 0; i < monthThreeLetter.length; i++) {
            if (monthThreeLetter[i].toLowerCase().equals(inputMonth)) {
                return i;
            }
        }
        return -1;
    }
    
    // Method to check if the entered year is valid
    public static boolean isValidYear(String inputYear) {
        try {
            int year = Integer.parseInt(inputYear);
            return year >= 0 && inputYear.length() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // Method to calculate the number of days in the entered month and year
    public static int calculateDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
    
    // Method to check if the entered year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
