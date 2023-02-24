package binary;

import java.util.function.BiFunction;

public class BitwiseOperators {

    private static String formatBinary(int num) {
        return String.format("%4s", Integer.toBinaryString(num)).replace(' ', '0');
    }

    private static void echoTheOp(String operation, BiFunction<Integer, Integer, Integer> fn) {
        int num1 = 5, num2 = 9;
        System.out.println(formatBinary(num1));
        System.out.println(formatBinary(num2));
        System.out.println(operation + ":");
        Integer fnResult = fn.apply(num1, num2);
        System.out.println(formatBinary(fnResult));
        System.out.println("Decimal: " + fnResult);
        System.out.println("-".repeat(30));
    }

    public static void main(String[] args) {
        echoTheOp("Bitwise AND", (a, b) -> (a & b));
        echoTheOp("Bitwise OR", (a, b) -> (a | b));
        echoTheOp("Bitwise XOR", (a, b) -> (a ^ b));
        echoTheOp("Bitwise NOT", (a, b) -> (a ^ b));
        echoTheOp("Bitwise Left Shift", (a, b) -> (a << b));
        echoTheOp("Bitwise Right Shift", (a, b) -> (a >> b));
        echoTheOp("Bitwise Unsigned Right Shift", (a, b) -> (a >>> b));
    }

}
