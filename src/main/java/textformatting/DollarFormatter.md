# US Dollar Formatting with Commas

To format dollar amounts with commas in the US locale, you can use the `NumberFormat` class in Java. Here's an example:

```java
import java.text.NumberFormat;
import java.util.Locale;

public class DollarFormatter {
    public static void main(String[] args) {
        double amount = 1234567.89;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        String formattedAmount = formatter.format(amount);
        System.out.println(formattedAmount); // Output: $1,234,567.89
    }
}
```

### Explanation

1. **`NumberFormat.getCurrencyInstance(Locale.US)`**: This method returns a `NumberFormat` instance for formatting currency values in the US locale.
2. **`formatter.format(amount)`**: This method formats the given amount according to the US currency format, which includes commas and the dollar sign.

### Running the Code

When you run the above code, it will output:

```
$1,234,567.89
```

This output shows the dollar amount formatted with commas as thousands separators, which is the standard format for US currency.
