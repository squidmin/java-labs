package interfaces;

interface MathUtils {
    static int max(int a, int b) {
        return Math.max(a, b);
    }
}

class MathOperations implements MathUtils {
}

public class StaticMethods {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        int result = MathUtils.max(num1, num2);
        System.out.println("Max of " + num1 + " and " + num2 + " is: " + result);

        num1 = 5;
        num2 = 15;
        result = MathUtils.max(num1, num2);
        System.out.println("Max of " + num1 + " and " + num2 + " is: " + result);

        num1 = -8;
        num2 = -3;
        result = MathUtils.max(num1, num2);
        System.out.println("Max of " + num1 + " and " + num2 + " is: " + result);
    }

}
