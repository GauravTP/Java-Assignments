import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the action you want to perform:\n");
        System.out.print("1. Addition\n");
        System.out.print("2. Subtraction\n");
        System.out.print("3. Multiplication\n");
        System.out.print("4. Division\n");

        int operation;

        while (true) {
            System.out.print("Enter the operation you want to perform:\n");
            System.out.print("1. Addition\n");
            System.out.print("2. Subtraction\n");
            System.out.print("3. Multiplication\n");
            System.out.print("4. Division\n");

            operation = scanner.nextInt();

            if (operation >= 1 && operation <= 4) {
                break; // Valid choice, exit the loop
            } else {
                System.out.println("Invalid choice. Please select an operation between 1 and 4.");
            }
        }
        int result = 0; // Declare and initialize the result variable

        switch (operation) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                result = divide(num1, num2);
                break;
        }

        System.out.println("Answer: " + result);
    }

    public static int add(int numOne, int numTwo) {
        return numOne + numTwo;
    }

    public static int subtract(int numOne, int numTwo) {
        return numOne - numTwo;
    }

    public static int multiply(int numOne, int numTwo) {
        return numOne * numTwo;
    }

    public static int divide(int numOne, int numTwo) {
        if (numTwo != 0) {
            return numOne / numTwo;
        } else {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
    }
}