package collections.arraylist.exercises;

public class SimplifiedStackUsingArrayList<T> {

    private Object[] array; // Using Object array to store any type of items
    private int size = 0; // Current number of items in the stack
    private int capacity; // Maximum capacity of the stack

    public SimplifiedStackUsingArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public void push(T item) {
        if (size == capacity) {
            throw new StackOverflowError("Stack is full");
        }
        array[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[--size];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        SimplifiedStackUsingArrayList<Integer> stack = new SimplifiedStackUsingArrayList<>(10);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element (peek): " + stack.peek()); // Should print 3
        System.out.println("Pop element: " + stack.pop()); // Should remove and print 3
        System.out.println("Next top element (peek): " + stack.peek()); // Should print 2

        // Demonstrate pushing beyond capacity
        try {
            for (int i = 0; i < 10; i++) {
                stack.push(i);
            }
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
        }
    }

}

