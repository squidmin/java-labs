package binaryliterals;

public class BinaryLiterals {

    public Integer convertBinaryToDecimal(Integer binaryNumber) {
        int decimalNumber = 0;
        int base = 1;

        while (binaryNumber > 0) {
            int lastDigit = binaryNumber % 10;
            binaryNumber = binaryNumber / 10;
            decimalNumber += lastDigit * base;
            base = base * 2;
        }
        return decimalNumber;
    }

    public Integer convertDecimalToBinary(Integer decimalNumber) {
        if (decimalNumber == 0) { return decimalNumber; }

        StringBuilder binaryNumber = new StringBuilder();
        int quotient = decimalNumber;

        while (quotient > 0) {
            int remainder = quotient % 2;
            binaryNumber.append(remainder);
            quotient /= 2;
        }

        return Integer.valueOf(binaryNumber.reverse().toString());
    }

    // Addition of binary numbers
    public Integer addBinaryNumber(Integer firstNum, Integer secondNum) {
        StringBuilder output = new StringBuilder();
        int carry = 0;
        int temp;
        while (firstNum != 0 || secondNum != 0) {
            temp = (firstNum % 10 + secondNum % 10 + carry) % 2;
            output.append(temp);

            carry = (firstNum % 10 + secondNum % 10 + carry) / 2;
            firstNum = firstNum / 10;
            secondNum = secondNum / 10;
        }
        if (carry != 0) output.append(carry);
        return Integer.valueOf(output.reverse().toString());
    }

    // Get one's complement of a binary number
    public Integer getOnesComplement(Integer num) {
        StringBuilder onesComplement = new StringBuilder();
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit == 0) onesComplement.append(1);
            else onesComplement.append(0);
            num = num / 10;
        }
        return Integer.valueOf(onesComplement.reverse().toString());
    }

    // Subtract binary numbers
    public Integer substractBinaryNumber(Integer firstNum, Integer secondNum) {
        int onesComplement = Integer.valueOf(getOnesComplement(secondNum));
        StringBuilder output = new StringBuilder();
        int carry = 0;
        int temp;
        while (firstNum != 0 || onesComplement != 0) {
            temp = (firstNum % 10 + onesComplement % 10 + carry) % 2;
            output.append(temp);
            carry = (firstNum % 10 + onesComplement % 10 + carry) / 2;
            firstNum = firstNum / 10;
            onesComplement = onesComplement / 10;
        }
        String additionOfFirstNumAndOnesComplement = output.reverse().toString();
        if (carry == 1) return addBinaryNumber(Integer.valueOf(additionOfFirstNumAndOnesComplement), carry);
        else return getOnesComplement(Integer.valueOf(additionOfFirstNumAndOnesComplement));
    }

    public static void main(String[] args) {
        byte a1 = 0b011;  // Byte type Binary Literal

        // The b can be lower or upper case
        byte a2 = 0B101;
        System.out.println("Binary Literal in Byte----->");
        System.out.println("a1 = " + a1 + ", " + "a2 = " + a2);

        short b1 = 0b101;  // Short type Binary Literal

        // The b can be lower or upper case
        short b2 = 0B111;
        System.out.println("Binary Literal in Short----->");
        System.out.println("b1 = " + b1 + ", " + "b2 = " + b2);

        int c1 = 0b011;  // Int type Binary literal

        // The b can be lower or upper case
        int c2 = 0B111;
        System.out.println("Binary Literal in Integer----->");
        System.out.println("c1 = " + c1 + ", " + "c2 = " + c2);

        long d1 = 0b0000011111100011;  // Long type Binary literal

        // The b can be lower or upper case
        long d2 = 0B0000011111100001;

        System.out.println("Binary Literal in Long----->");
        System.out.println("d1 = " + d1 + ", " + "d2 = " + d2);
    }

}
