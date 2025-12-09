package programs.mydatecalendar; // <-- Correct package declaration

import java.util.Scanner;
import core.ProgramInterface; // Required for the interface

/**
     * MyDate class represents a date with year, month, and day.
     * This program provides methods to manipulate and retrieve date information.
     *
     * @author Neil Nino Rozen N. Sudaria
     * Description: MyDate class with various date manipulation methods It includes validation for dates, leap year calculations, and methods to
       move to the next or previous day, month, or year. 
     */
public class MyDateCalendarProgram implements ProgramInterface {
    
    public String getName() { 
        return "My Date Calendar"; 
    }
    
    public String getDescription() { 
        return "Interactive calendar with date navigation and validation."; 
    }
    
    public String getAuthor() { 
        return "Neil Sudaria"; 
    }
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        MyDate currentDate = null;
        
        System.out.println("=== My Date Calendar ===");
        System.out.println("Interactive date manipulation program\n");
        
        // Initialize date
        while (currentDate == null) {
            try {
                System.out.print("Enter year (1-9999): ");
                int year = sc.nextInt();
                System.out.print("Enter month (1-12): ");
                int month = sc.nextInt();
                System.out.print("Enter day: ");
                int day = sc.nextInt();
                
                currentDate = new MyDate(year, month, day);
                System.out.println("\nCurrent date: " + currentDate + "\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.\n");
                sc.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers only.\n");
                sc.nextLine(); // Clear buffer
            }
        }
        
        // Menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- Date Operations ---");
            System.out.println("1. Next Day");
            System.out.println("2. Next Month");
            System.out.println("3. Next Year");
            System.out.println("4. Previous Day");
            System.out.println("5. Previous Month");
            System.out.println("6. Previous Year");
            System.out.println("7. Check if Leap Year");
            System.out.println("8. Set New Date");
            System.out.println("9. Show Current Date");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            try {
                int choice = sc.nextInt();
                System.out.println();
                
                switch (choice) {
                    case 1:
                        currentDate.nextDay();
                        System.out.println("New date: " + currentDate);
                        break;
                    case 2:
                        currentDate.nextMonth();
                        System.out.println("New date: " + currentDate);
                        break;
                    case 3:
                        currentDate.nextYear();
                        System.out.println("New date: " + currentDate);
                        break;
                    case 4:
                        currentDate.previousDay();
                        System.out.println("New date: " + currentDate);
                        break;
                    case 5:
                        currentDate.previousMonth();
                        System.out.println("New date: " + currentDate);
                        break;
                    case 6:
                        currentDate.previousYear();
                        System.out.println("New date: " + currentDate);
                        break;
                    case 7:
                        boolean isLeap = currentDate.isLeapYear(currentDate.getYear());
                        System.out.println(currentDate.getYear() + " is " + 
                            (isLeap ? "a leap year" : "NOT a leap year"));
                        break;
                    case 8:
                        System.out.print("Enter year: ");
                        int y = sc.nextInt();
                        System.out.print("Enter month: ");
                        int m = sc.nextInt();
                        System.out.print("Enter day: ");
                        int d = sc.nextInt();
                        currentDate.setDate(y, m, d);
                        System.out.println("Date updated: " + currentDate);
                        break;
                    case 9:
                        System.out.println("Current date: " + currentDate);
                        break;
                    case 0:
                        System.out.println("Exiting Date Calendar. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option! Please choose 0-9.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear buffer
            }
        }
    }
    
    // Inner MyDate class
    static class MyDate {
        private int year;
        private int month;
        private int day;
        
        public static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        public static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", 
            "Thursday", "Friday", "Saturday"};
        public static final int[] DAY_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public MyDate(int year, int month, int day) {
            setDate(year, month, day);
        }

        public boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        public boolean isValidDate(int year, int month, int day) {
            if (year < 1 || year > 9999 || month < 1 || month > 12) return false;
            int dayMax = DAY_IN_MONTHS[month - 1];
            if(month == 2 && isLeapYear(year)) dayMax = 29;
            return day > 0 && day <= dayMax;
        }

        public static int getDayOfWeek(int year, int month, int day) {
            if (month < 3) { month += 12; year--; }
            int century = year / 100;
            year %= 100;
            int dayOfWeek = (day + ((13 * (month + 1)) / 5) + year + (year / 4) + 
                (century / 4) + (5 * century)) % 7;
            return (dayOfWeek + 6) % 7;
        }

        public void setDate(int year, int month, int day) {
            if(!isValidDate(year, month, day)) 
                throw new IllegalArgumentException("Invalid year, month, or day!");
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public void setYear(int year) {
            if(year < 1 || year > 9999) throw new IllegalArgumentException("Invalid year!");
            this.year = year;
        }

        public void setMonth(int month) {
            if(month < 1 || month > 12) throw new IllegalArgumentException("Invalid month!");
            this.month = month;
        }

        public void setDay(int day) {
            int dayMax = DAY_IN_MONTHS[month - 1];
            if(month == 2 && isLeapYear(year)) dayMax = 29;
            if(day < 1 || day > dayMax) throw new IllegalArgumentException("Invalid day!");
            this.day = day;
        }

        public int getYear() { return this.year; }
        public int getMonth() { return this.month; }
        public int getDay() { return this.day; }

        @Override
        public String toString() {
            int dayOfWeek = getDayOfWeek(this.year, this.month, this.day);
            return DAYS[dayOfWeek] + " " + this.day + " " + MONTHS[this.month - 1] + " " + year;
        }

        public MyDate nextDay() {
            int dayMax = DAY_IN_MONTHS[month - 1];
            if(this.month == 2 && isLeapYear(this.year)) dayMax = 29;
            if((this.day + 1) > dayMax) { 
                nextMonth(); 
                this.day = 1; 
            } else {
                this.day++;
            }
            return this;
        }

        public MyDate nextMonth() {
            if(this.month == 12) { 
                this.month = 1; 
                this.year++; 
            } else {
                this.month++;
            }
            int dayMax = DAY_IN_MONTHS[month - 1];
            if(month == 2 && isLeapYear(year)) dayMax = 29;
            if(this.day > dayMax) this.day = dayMax;
            return this;
        }

        public MyDate nextYear() {
            if(year >= 9999) throw new IllegalArgumentException("Year out of range!");
            this.year++;
            if(!isLeapYear(this.year) && this.month == 2 && this.day == 29) {
                this.day = 28;
            }
            return this;
        }

        public MyDate previousDay() {
            if(this.day == 1) {
                previousMonth();
                int dayMax = DAY_IN_MONTHS[this.month - 1];
                if(this.month == 2 && isLeapYear(this.year)) dayMax = 29;
                this.day = dayMax;
            } else {
                this.day--;
            }
            return this;
        }

        public MyDate previousMonth() {
            if(this.month == 1) { 
                this.month = 12; 
                this.year--; 
            } else {
                this.month--;
            }
            int dayMax = DAY_IN_MONTHS[month - 1];
            if(month == 2 && isLeapYear(year)) dayMax = 29;
            if(this.day > dayMax) this.day = dayMax;
            return this;
        }

        public MyDate previousYear() {
            this.year--;
            int dayMax = DAY_IN_MONTHS[month - 1];
            if(month == 2 && isLeapYear(year)) dayMax = 29;
            if(day > dayMax) this.day = dayMax;
            return this;
        }
    }
}
