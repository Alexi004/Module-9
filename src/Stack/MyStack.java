package Stack;

import java.util.EmptyStackException;

public class MyStack {
    private Object[] stack;
    private int top;

    public MyStack(){
        stack = new Object[12];
        top = -1;
    }

    public void push(Object value) {
        if (top == stack.length - 1) {
            // The stack array is full, we need to expand it
            Object[] newStack = new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++top] = value;
    }

    public void remove(int index) {
        if (index < 0 || index > top) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index < top) {
            // Shift the elements after the removed element
            System.arraycopy(stack, index + 1, stack, index, top - index);
        }
        stack[top--] = null; // Clear the reference to the removed element
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public Object peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public Object pop() {
        Object value = peek();
        stack[top--] = null; // Clear the reference to the removed element
        return value;
    }
}
