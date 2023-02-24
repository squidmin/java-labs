package practice.binary;

public class BinaryLiterals {

    public static Integer convertBinaryToDecimal(Integer binaryNumber) {
        return -1;
    }

    public static Integer convertDecimalToBinary(Integer decimalNumber) {
        return -1;
    }

    // Addition of binary numbers.
    public static Integer addBinaryNumber(Integer firstNum, Integer secondNum) {
        return -1;
    }

    /**
     * Get one's complement of a binary number.
     * Note: The ones' complement of a binary number is the value obtained by inverting all the bits in the binary
     * representation of the number (swapping 0s and 1s).
     */
    public static Integer getOnesComplement(Integer num) {
        return -1;
    }

    // Subtract binary numbers.
    public static Integer subtractBinaryNumber(Integer firstNum, Integer secondNum) {
        return -1;
    }

    public static void main(String[] args) {
        byte a1 = 0b011;  // Byte type Binary Literal
        byte a2 = 0B101;  // The b can be lower or upper case
        System.out.println("Binary Literal in Byte----->");
        System.out.println("a1 = " + a1 + ", " + "a2 = " + a2);

        short b1 = 0b101;  // Short type Binary Literal
        short b2 = 0B111;  // The b can be lower or upper case
        System.out.println("Binary Literal in Short----->");
        System.out.println("b1 = " + b1 + ", " + "b2 = " + b2);

        int c1 = 0b011;  // Int type Binary literal
        int c2 = 0B111;  // The b can be lower or upper case
        System.out.println("Binary Literal in Integer----->");
        System.out.println("c1 = " + c1 + ", " + "c2 = " + c2);

        long d1 = 0b0000011111100011;  // Long type Binary literal
        long d2 = 0B0000011111100001;  // The b can be lower or upper case
        System.out.println("Binary Literal in Long----->");
        System.out.println("d1 = " + d1 + ", " + "d2 = " + d2);
    }

}
