package java;

import java.util.Set;

/**
 * Class to calculate the solution of a given word representing a mathematical expression in RPN.
 * If the given word is a valid expression, the solution will be printed out.
 * If the given word is not valid, program will throw an exception.
 * <p>
 * The program operates using a Push-Down-Automaton implementation.
 */
public class RPNCalculator extends RPNChecker {
    private static final Set<Character> OPERATIONS = Set.of('+', '-', '*', '/');

    /**
     * Initialises the stack needed for the automaton and stores the word that will be calculated.
     *
     * @param word Word that should be calculated.
     */
    public RPNCalculator(String word) {
        super(word);
    }

    /**
     * Makes the calculation.
     * Prints the result or throws IllegalArgumentException if expression is invalid.
     */
    public void calculate() {
        while (!word.isEmpty()) {
            char current = word.charAt(0);
            if (Character.isDigit(current)) {
                int digit = Character.getNumericValue(current);
                stack.push(digit);
                word = word.substring(1);
            }

            if (OPERATIONS.contains(current)) {
                if (stack.isEmpty()) throw new IllegalArgumentException(INVALID_EXPRESSION);
                int second = stack.pop();
                if (stack.isEmpty()) throw new IllegalArgumentException(INVALID_EXPRESSION);
                int first = stack.pop();
                stack.push(makeOperation(first, second, current));
                word = word.substring(1);
            }
        }
        int result = stack.pop();
        if (stack.pop() == END) System.out.println(result);
        else throw new IllegalArgumentException(INVALID_EXPRESSION);
    }

    /**
     * Makes the necessary calculations (addition, subtraction, multiplication, division).
     *
     * @param first     First argument of calculation.
     * @param second    Second argument of calculation.
     * @param operation Operation that the calculation should perform.
     * @return Result of calculation.
     */
    private int makeOperation(int first, int second, char operation) {
        switch (operation) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            default:
                if (second == 0) throw new ArithmeticException("Can't divide by zero.");
                return first / second;
        }
    }
}