/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

/**
 *
 * @author muska
 */
import java.util.Scanner;

class Calculator {

    // Method to add two numbers
    public void add(double a, double b) {
        System.out.println("Result of addition: " + (a + b));
    }

    // Method to subtract two numbers
    public void subtract(double a, double b) {
        System.out.println("Result of subtraction: " + (a - b));
    }

    // Method to multiply two numbers
    public void multiply(double a, double b) {
        System.out.println("Result of multiplication: " + (a * b));
    }

    // Method to divide two numbers
    public void divide(double a, double b) {
        if (b != 0) {
            System.out.println("Result of division: " + (a / b));
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }

    // Method to display the menu and handle operations
    public void displayMenu() {
        System.out.println("Welcome to the Calculator!");  // Welcome message

        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1, num2;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();

                switch (choice) {
                    case 1:
                        add(num1, num2);
                        break;
                    case 2:
                        subtract(num1, num2);
                        break;
                    case 3:
                        multiply(num1, num2);
                        break;
                    case 4:
                        divide(num1, num2);
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        System.out.println("Exiting the calculator. Goodbye!");
        scanner.close();
    }
}
class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.displayMenu();
    }
}
