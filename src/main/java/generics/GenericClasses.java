package generics;

import java.util.ArrayList;

class Stack<E> {
    private ArrayList<E> list = new ArrayList<>();

    public int getSize() { return list.size(); }

    public E peek() { return list.get(getSize() - 1); }

    public void push(E o) { list.add(o); }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() { return list.isEmpty(); }
}

public class GenericClasses {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Ok");
        stack.push("I");
        stack.push("pull");
        stack.push("up");

        Stack<Integer> _stack = new Stack<>();
        _stack.push(0);
        _stack.push(1);
        _stack.push(2);
        _stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(_stack.pop());
        System.out.println(_stack.pop());
        System.out.println(_stack.pop());
        System.out.println(_stack.pop());
    }

}
