package generics;

import java.util.ArrayList;

class GenericStack<E> {
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

public class GenericClassDemo {

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Ok");
        stack.push("I");
        stack.push("pull");
        stack.push("up");

        GenericStack<Integer> _stack = new GenericStack<>();
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
