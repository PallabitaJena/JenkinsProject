package TestScriptJava;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class OccuranceOfLetterInAStringOfWords {
    @Test
    public void testcase1()
    {
      String input="My name is matching with my name";
      //String[] words=input.split("\\s*");

        Map<Character,Integer> wordOf=new HashMap<>();
        for(char ch:input.toCharArray())
      {
//           if(ch != ' ')
//           {
//               wordOf.put(ch,wordOf.getOrDefault(ch,0)+1);
//           }
           if(!Character.isWhitespace(ch))
           {
               wordOf.put(ch,wordOf.getOrDefault(ch,0)+1);
           }
    }
int maxCount=0;
        char maxValue = 0;
        for(Map.Entry<Character,Integer> entry: wordOf.entrySet())
        {
            System.out.println("The letter :"+entry.getKey()+" has occurrence: "+entry.getValue());
            if(entry.getValue()> maxCount)
            {
                maxCount= entry.getValue();
                maxValue= entry.getKey();
            }
        }
        System.out.println("The maximum Occurance of character is :"+maxCount + "for the character :"+maxValue);
    }
}
