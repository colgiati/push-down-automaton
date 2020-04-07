import java.util.Set;

public class PushDownAutomaton {
    private String word;
    private IntegerStack stack;
    private Set<Character> operations;


    public PushDownAutomaton(String word) {
        this.word = word;
        stack = new IntegerStack(word.length() + 1);
        stack.push('$');
        operations = Set.of('+', '-', '*', '/');
    }

    public void start() {
        while (!word.isEmpty()) {
            char current = word.charAt(0);
            if (Character.isDigit(current)) {
                int digit = Character.getNumericValue(current);
                stack.push(digit);
                word = word.substring(1);
            }

            if (operations.contains(current)) {
                if (stack.isEmpty()) throw new IllegalArgumentException("Invalid expression.");
                int second = stack.pop();
                if (stack.isEmpty()) throw new IllegalArgumentException("Invalid expression.");
                int first = stack.pop();
                stack.push(makeOperation(first, second, current));
                word = word.substring(1);
            }
        }
        System.out.println(stack.pop());
    }

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

    public static void main(String[] args) {
        try {
            new PushDownAutomaton("34+").start();
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
}

class IntegerStack {
    private int[] stack;
    private int position;

    public IntegerStack(int size) {
        stack = new int[size];
        position = -1;
    }

    public void push(int value) {
        stack[++position] = value;
    }

    public int pop() {
        return stack[position--];
    }

    public boolean isEmpty() {
        return position == 0;
    }
}
