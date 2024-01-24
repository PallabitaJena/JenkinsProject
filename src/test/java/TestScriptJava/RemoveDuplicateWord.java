package TestScriptJava;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWord {
    @Test
    public void testcase1()
    {

        String input=" name of Pallabita is name as of pallabita";
        String[] words=input.split("\\s+");
        StringBuilder result=new StringBuilder();

        Set<String> unique=new LinkedHashSet<>();

        for(String word:words)
        {
            unique.add(word.toLowerCase());
        }

        for(String ch:unique)
        {
            result.append(ch).append(" ");
        }

        System.out.println("The unique charater word is:"+result.toString());

    }
}
