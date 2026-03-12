import java.util.Scanner;
import java.util.Stack;

public class palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String input = scanner.nextLine();

        // Start time
        long startTime = System.nanoTime();

        boolean result = checkPalindrome(input);

        // End time
        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("Is Palindrome?: " + result);
        System.out.println("Execution Time : " + executionTime + " ns");
    }

    /**
     * Palindrome checking using Stack
     */
    public static boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

