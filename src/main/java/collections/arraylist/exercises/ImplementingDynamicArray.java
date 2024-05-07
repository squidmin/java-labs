package collections.arraylist.exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class ImplementingDynamicArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("Enter strings to store in the dynamic array. Type 'stop' to finish.");

        while (true) {
            String input = scanner.nextLine();
            if ("stop".equalsIgnoreCase(input)) {
                break; // Exit the loop if user enters "stop"
            }
            inputs.add(input);
        }

        scanner.close(); // Close the scanner

        // Print all stored inputs
        System.out.println("You entered the following strings:");
        for (String str : inputs) {
            System.out.println(str);
        }
    }

}
