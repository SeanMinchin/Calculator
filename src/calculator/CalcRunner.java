package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcRunner {
    public static void main(String[] args) {
        final Scanner SCANNER = new Scanner(System.in);
        String expression;
        int userChoice;
        boolean menuIsRunning;

        while(true) {
            menuIsRunning = true;

            System.out.println("Please enter a space-separated expression to be calculated.");
            expression = SCANNER.nextLine();

            if(Conditions.isLegalInput(expression.split(" "))) {
                Calculator.evaluatePostfix(InputParser.toPostfix(expression));
                Memory.printLastValue();

                while(menuIsRunning) {
                    userChoice = 0;
                    System.out.println("\n1. Calculate a new expression");
                    System.out.println("2. Display last value in memory");
                    System.out.println("3. Remove last value from memory");
                    System.out.println("4. Clear memory history");
                    System.out.println("5. Display all history");
                    System.out.println("6. Quit calculator");

                    try {
                        userChoice = SCANNER.nextInt();
                    } catch(InputMismatchException e) {
                        SCANNER.nextLine();
                    }

                    switch (userChoice) {
                        case 1:
                            SCANNER.nextLine();
                            menuIsRunning = false;
                            break;
                        case 2:
                            Memory.printLastValue();
                            break;
                        case 3:
                            Memory.removeLastValue();
                            break;
                        case 4:
                            Memory.clearHistory();
                            break;
                        case 5:
                            Memory.displayHistory();
                            break;
                        case 6:
                            return;
                        default:
                            System.out.println("Invalid input. Try again.");
                            break;
                    }
                }
            }
        }
    }
}