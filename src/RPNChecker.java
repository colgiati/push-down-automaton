/**
 * Class to check if a certain sequence of digits and operation symbols is a valid RPN (Reversed Polish Notation) expression.
 * To check this, an implementation of a Keller-Automaton or Push-Down-Automaton was chosen.
 * Input is a string consisting of 'D' (for digit) and 'O' (for operation).
 * So for example 34+62+* -> "DDODDOO"
 * <p>
 * If the word is not valid, an exception will be thrown (IllegalArgumentException).
 */
abstract class RPNChecker {
    protected String word;
    protected IntegerStack stack;
    private static final char DIGIT = 'D';
    private static final char OPERATION = 'O';
    protected static final char END = '$';

    /**
     * Initialises the stack needed for the automaton and stores the word that will be checked.
     *
     * @param word Word that should be checked for validity.
     */
    RPNChecker(String word) {
        this.word = word;
        stack = new IntegerStack(word.length() + 1);
        stack.push(END);
    }

    /**
     * Starts the automaton.
     */
    public void check() {
        digitState();
    }

    /**
     * Represents state q0 from exercise 1).
     */
    private void digitState() {
        char current = '_';
        if (!word.isEmpty()) {
            current = word.charAt(0);
            word = word.substring(1);
        }
        int popped = stack.pop();
        if (current == DIGIT && (popped == DIGIT || popped == END)) {
            stack.push(popped);
            stack.push(current);
            digitState();
        } else if (current == OPERATION && popped == DIGIT) {
            operationState();
        } else if (word.isEmpty() && popped == DIGIT) {
            emptyStackState();
        } else {
            throw new IllegalArgumentException(RPNCalculator.INVALID_EXPRESSION);
        }
    }

    /**
     * Represents state q1 from exercise 1).
     */
    private void operationState() {
        char current = '_';
        if (!word.isEmpty()) {
            current = word.charAt(0);
            word = word.substring(1);
        }
        int popped = stack.pop();
        if (current == OPERATION && popped == DIGIT) {
            operationState();
        } else if (current == DIGIT && popped == DIGIT) {
            stack.push(popped);
            stack.push(current);
            digitState();
        } else if (word.isEmpty() && popped == DIGIT) {
            emptyStackState();
        } else {
            throw new IllegalArgumentException(RPNCalculator.INVALID_EXPRESSION);
        }
    }

    /**
     * Represents state q2 from exercise 1).
     */
    private void emptyStackState() {
        int popped = stack.pop();
        if (word.isEmpty() && popped == END) {
            stack.push(popped);
            acceptingState();
        } else {
            throw new IllegalArgumentException(RPNCalculator.INVALID_EXPRESSION);
        }
    }

    /**
     * Represents state q3 from exercise 1).
     * Is the accepting state.
     */
    private void acceptingState() {
        System.out.println("Word is valid");
    }
}
