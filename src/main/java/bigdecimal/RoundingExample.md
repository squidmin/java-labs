# Rounding Example

To round a number with precision in Java, you can use the `BigDecimal` class.
The `BigDecimal` class provides precise control over rounding behavior and is well-suited for financial calculations.

Here's an example:

## Example

### `RoundingExample.java`

```java
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
```

## Explanation

1. **Define the Original Value:**
    - `BigDecimal originalValue = new BigDecimal("123.4567");`
    - This creates a `BigDecimal` object representing the original value.

2. **Round the Value towards the "nearest neighbor" using the "half up" strategy:**
    - `BigDecimal roundedValue = originalValue.setScale(2, RoundingMode.HALF_UP);`
    - The `setScale` method is used to round the value to 2 decimal places using the `HALF_UP` rounding mode.

3. **Print the Original and Rounded Values:**
    - `System.out.println("Original Value: " + originalValue);`
    - `System.out.println("Rounded Value: " + roundedValue);`
    - These statements print the original and rounded values to the console.

## Output

When you run the above code, it will produce the following output:

```
Original Value: 123.4567
Rounded Value: 123.46
```

## Rounding Modes

The `RoundingMode.HALF_UP` is one of several rounding modes provided by the `BigDecimal` class:

- `RoundingMode.UP`: Rounds away from zero.
- `RoundingMode.DOWN`: Rounds towards zero.
- `RoundingMode.CEILING`: Rounds towards positive infinity.
- `RoundingMode.FLOOR`: Rounds towards negative infinity.
- `RoundingMode.HALF_UP`: Rounds towards the "nearest neighbor" unless both neighbors are equidistant, in which case, it rounds up.
- `RoundingMode.HALF_DOWN`: Rounds towards the "nearest neighbor" unless both neighbors are equidistant, in which case, it rounds down.
- `RoundingMode.HALF_EVEN`: Rounds towards the "nearest neighbor" unless both neighbors are equidistant, in which case, it rounds towards the even neighbor (also known as "bankers' rounding").
- `RoundingMode.UNNECESSARY`: Asserts that no rounding is necessary; if rounding is required, an `ArithmeticException` is thrown.
