package TestScriptJava;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateCharacter {
    @Test
    public void testcase1()
    {

        String input="Pallabita";
        StringBuilder result=new StringBuilder();

        Set<Character> unique=new LinkedHashSet<>();

        for(char ch:input.toCharArray())
        {
            unique.add(ch);
        }

        for(Character ch:unique)
        {
            result.append(ch);
        }

        System.out.println("The unique charater word is:"+result.toString());

    }
}
