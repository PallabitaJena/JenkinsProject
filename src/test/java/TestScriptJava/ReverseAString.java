package TestScriptJava;

import org.testng.annotations.Test;

public class ReverseAString {
    @Test
    public void testcase1(){
        String originalString = "Hello, World!";

        // Using a custom method to reverse the string
        String reversedString = reverseString(originalString);

        // Print the original and reversed strings
        System.out.println("Original String: " + originalString);
        System.out.println("Reversed String: " + reversedString);
    }

    private static String reverseString(String str) {
        char[] charArray = str.toCharArray();

        // Single-pointer approach to reverse the character array
        int length = charArray.length;
        for (int i = 0; i < length / 2; i++) {
            // Swap characters at i and (length - 1 - i) indices
            char temp = charArray[i];
            charArray[i] = charArray[length - 1 - i];
            charArray[length - 1 - i] = temp;
        }

        // Convert the reversed character array back to a string
        return new String(charArray);
    }
}

