package binary;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BitwiseOperatorsDemo {

    private static String formatBinary(int num) {
        return String.format("%4s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    private static void echoBinaryOperands(int num1, int num2) {
        System.out.println(formatBinary(num1));
        System.out.println(formatBinary(num2));
    }

    private static void echoBinaryOp(String operation, BiFunction<Integer, Integer, Integer> fn) {
        int num1 = 5, num2 = 3;
        echoBinaryOperands(num1, num2);
        System.out.println(operation + ":");
        Integer fnResult = fn.apply(num1, num2);
        System.out.println(formatBinary(fnResult));
        System.out.println("Decimal: " + fnResult);
        System.out.println("-".repeat(30));
    }

    private static void echoUnaryOp(String operation, Function<Integer, Integer> fn) {
        int num = Integer.MAX_VALUE;
        System.out.println(formatBinary(num));
        System.out.println(operation + ":");
        Integer fnResult = fn.apply(num);
        System.out.println(formatBinary(fnResult));
        System.out.println("Decimal: " + fnResult);
        System.out.println("-".repeat(30));
    }

    public static void main(String[] args) {
        echoBinaryOp("Bitwise AND", (a, b) -> (a & b));
        echoBinaryOp("Bitwise OR", (a, b) -> (a | b));
        echoBinaryOp("Bitwise XOR", (a, b) -> (a ^ b));
        echoUnaryOp("Bitwise NOT", a -> (~a));
        echoBinaryOp("Bitwise Left Shift", (a, b) -> (a << b));
        echoBinaryOp("Bitwise Right Shift", (a, b) -> (a >> b));
        echoBinaryOp("Bitwise Unsigned Right Shift", (a, b) -> (a >>> b));
    }

}
