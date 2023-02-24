package binary.bitwisealgorithms;

public class BitTraversalRecursive {

    private static String formatBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0');
    }

    private static void echoNumber(int n) {
        System.out.println("Binary: " + formatBinary(n));
        System.out.println("Decimal: " + n);
    }

    private static void traverse(int n) {
        if (n > 0) {
            echoNumber(n);
            traverse(n >> 1);
        }
    }

    public static void main(String[] args) {
        traverse(11);
    }

}
