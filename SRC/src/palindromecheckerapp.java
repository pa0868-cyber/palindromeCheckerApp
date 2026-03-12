import java.util.*;

/**
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 *
 * Demonstrates Strategy Pattern for palindrome checking.
 */
public class palindromecheckerapp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input: ");
        String input = scanner.nextLine();

// Choose strategy dynamically
        PalindromeStrategy strategy;

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        int choice = scanner.nextInt();

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.check(input);

        System.out.println("Is Palindrome: " + result);
    }
}


/**
 * INTERFACE - PalindromeStrategy
 * Defines contract for palindrome checking algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}


/**
 * CLASS - StackStrategy
 * Implements palindrome check using Stack (LIFO).
 */
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

// Push characters into stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

// Compare with original string
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


/**
 * CLASS - DequeStrategy
 * Implements palindrome check using Deque.
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

// Add characters to deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

// Compare front and rear
        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }
}

