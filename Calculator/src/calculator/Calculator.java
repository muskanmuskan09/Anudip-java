/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;
import java.util.*;

/**
 *
 * @author muska
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int result = 0;
        System.out.println("Calculator");

        while (true) {
            System.out.println("Enter first number:");
            int input1 = s.nextInt();

            System.out.println("Enter an operator (+, -, *, /) or  'quit' to exit:");
            String operator = s.next();

            if (operator.equals("quit")) {
                break;
            }

            System.out.println("Enter second number:");
            int input2 = s.nextInt();

            switch (operator) {
                case "+":
                    result = input1 + input2;
                    break;
                case "-":
                    result = input1 - input2;
                    break;
                case "*":
                    result = input1 * input2;
                    break;
                case "/":
                    if (input2 != 0) {
                        result = input1 / input2;
                    } else {
                        System.out.println("Error: ");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operator");
                    continue;
            }
            System.out.println("Result: " + result);
        }
        s.close();
    }
}