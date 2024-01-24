package TestScriptJava;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfWord {
     @Test
    public void testcase1()
    {
      String input="My name is matching with my name";
      String[] words=input.split("\\s+");

        Map<String,Integer> wordOf=new HashMap<>();
        for(String word: words)
        {
            String lowercase=word.toLowerCase();
            wordOf.put(lowercase,wordOf.getOrDefault(lowercase,0)+1);
        }

        for(Map.Entry<String,Integer> entry: wordOf.entrySet())
        {
            System.out.println("The word :"+entry.getKey()+" has occurrence: "+entry.getValue());
        }
    }
}
