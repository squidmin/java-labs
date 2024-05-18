package textformatting;

import java.text.NumberFormat;

public class DollarFormatter {

    public static void main(String[] args) {
        double amount = 1234567.89;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String formattedAmount = formatter.format(amount);
        System.out.println(formattedAmount);
    }

}
