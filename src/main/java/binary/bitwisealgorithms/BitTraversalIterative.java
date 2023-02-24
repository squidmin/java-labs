package binary.bitwisealgorithms;

public class BitTraversalIterative {

    private static String formatBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
    }

    private static void echoNumber(int n) {
        System.out.println("Binary: " + formatBinary(n));
        System.out.println("Decimal: " + n);
    }

    static void traverse(int n) {
        while (n > 0) {
            echoNumber(n);
            n >>= 1;
        }
        echoNumber(n);
    }

    public static void main(String[] args) {
        traverse(11);
    }

}
