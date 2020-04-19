package java;

/**
 * Cheap stack implementation for integers using an integer (int) array.
 */
class IntegerStack {
    private int[] stack;
    private int position;
    private static final int EMPTY = '_';

    public IntegerStack(int size) {
        stack = new int[size];
        position = -1;
    }

    public void push(int value) {
        stack[++position] = value;
    }

    public int pop() {
        int value = stack[position];
        stack[position--] = EMPTY;
        return value;
    }

    public boolean isEmpty() {
        return position == 0;
    }
}