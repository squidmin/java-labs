package bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingExample {
    public static void main(String[] args) {
        // Define the original value
        BigDecimal originalValue = new BigDecimal("123.4567");

        // Round the value to the nearest cent using HALF_UP rounding mode
        BigDecimal roundedValue = originalValue.setScale(2, RoundingMode.HALF_UP);

        // Print the original and rounded values
        System.out.println("Original Value: " + originalValue);
        System.out.println("Rounded Value: " + roundedValue);
    }
}
