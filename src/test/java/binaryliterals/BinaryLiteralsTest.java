package binaryliterals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryLiteralsTest {

    @Test
    public void given_binaryLiteral_thenReturnDecimalValue() {
        byte five = 0b101;
        assertEquals((byte) 5, five);

        short three = 0b11;
        assertEquals((short) 3, three);

        int nine = 0B1001;
        assertEquals(9, nine);

        long twentyNine = 0B11101;
        assertEquals(29, twentyNine);

        int minusThirtySeven = -0B100101;
        assertEquals(-37, minusThirtySeven);
    }

    @Test
    public void given_decimalNumber_then_convertToBinaryNumber() {
        assertEquals("1000", Integer.toBinaryString(8));
        assertEquals("10100", Integer.toBinaryString(20));
    }

    @Test
    public void given_binaryNumber_then_ConvertToDecimalNumber() {
        assertEquals(8, Integer.parseInt("1000", 2));
        assertEquals(20, Integer.parseInt("10100", 2));
    }

    @Test
    public void convertBinaryToDecimal_givenBinaryNumber_returnDecimalNumber() {
        Integer result = BinaryLiterals.convertBinaryToDecimal(010101);
        assertEquals(Integer.valueOf(49), result);
    }

    @Test
    public void convertDecimalToBinary_givenDecimalNumber_returnBinaryNumber() {
        Integer result = BinaryLiterals.convertDecimalToBinary(15);
        assertEquals(Integer.valueOf(1111), result);
    }

}
