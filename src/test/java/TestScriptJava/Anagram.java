package TestScriptJava;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    @Test
    public void checkAnagram()
    {

        String s1="listen";
        String s2="silent";

        if(s1.length()==s2.length())
        {
            char[] char1=s1.toCharArray();
            char[] char2=s2.toCharArray();
int a=0;
            Arrays.sort(char1);

            Arrays.sort(char2);
            
            if(Arrays.equals(char1,char2))

            {
                System.out.println("it is Anagram");
            }
            else {
                System.out.println("it is not Anagram");
            }
        }

    }
}
