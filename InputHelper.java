/**
 * InputHelper - Utility class for managing user input.
 *
 * InputHelper makes it easier to get user input by providing methods to
 * capture strings, integers, doubles, and lists of integers with validation.
 * It also has a close method to release the scanner resource.
 *
 * How to Use:
 *  - Create an InputHelper instance to access its input methods.
 *  - Call getString, getInt, getDouble, or getIntList to capture validated input.
 *  - Always call close() to release the scanner after you are done.
 *
 * Example:
 *  ```
 *  InputHelper inputHelper = new InputHelper();
 *  int amount = inputHelper.getInt("Enter amount: ");
 *  inputHelper.close();
 *  ```
 */



// Imports
import java.util.ArrayList;
import java.util.Scanner;

// class
public class InputHelper {
    // attributes
    private Scanner scanner;

    // constructor
    public InputHelper() {
        this.scanner = new Scanner(System.in); // new object read from KB
    }

    // Methods

    // Get String user input via prompt argument
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Get Int user input via prompt argument, validate type mismatch block
    public int getInt(String prompt) {
        int result;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) { // if block for Validate type mismatch
                result = scanner.nextInt();
                scanner.nextLine(); // clear newline character
                break;
            }
            else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return result;
    }

    // Get double user input via prompt argument, validate type mismatch block
    public double getDouble(String prompt) {
        double result;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) { // if block for Validate type mismatch
                result = scanner.nextDouble();
                scanner.nextLine(); // clear newline character
                break;
            }
            else {
                System.out.println("Invalid input. Please enter a decimal number.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return result;
    }

    // Get a list of integers from the user with validation
    public ArrayList<Integer> getIntList(String prompt, ArrayList<Integer> referenceList) {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println(prompt);

        while (true) {
            System.out.print("Enter a number (or type 'quit' to finish): ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (referenceList.contains(input)) {
                    numbers.add(input); // Add input if in reference list
                } else {
                    System.out.println("Invalid number. Please enter a valid number from the list.");
                }
            } else if (scanner.hasNext() && scanner.next().equalsIgnoreCase("quit")) {
                break; //Exit if user types "quit"
            } else {
                System.out.println("Invalid input. Please enter a number or type 'quit' to finish.");
            }
            scanner.nextLine(); //Clear remaining input
        }

        return numbers;
    }

    // Close scanner when done
    public void close() {
        scanner.close();
    }


}
