package TestScriptJava;

import org.testng.annotations.Test;

public class CheckVowelinaString {

    @Test
    public void test1()
    {



                System.out.println(stringContainsVowels("Hello")); // true
                System.out.println(stringContainsVowels("TV")); // false





    }
    public static boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
