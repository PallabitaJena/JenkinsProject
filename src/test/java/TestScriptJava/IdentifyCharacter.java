package TestScriptJava;

import org.testng.annotations.Test;

public class IdentifyCharacter {

        @Test
        public void checkCharacterFromaString() {
            String input="gafhgs$#%$#%23345";

            StringBuilder result=new StringBuilder();
            for(char ch:input.toCharArray())
            {
                if(Character.isLetter(ch))
                {
                    result.append(ch);
                } else if (Character.isDigit(ch)) {

                    System.out.println("It is a digit :"+ch);

                } else if (!Character.isDigit(ch) && !Character.isLetter(ch)) {
                    System.out.println("It is a symbol :"+ch);
                }
            }
            System.out.println("The characters in the string :"+result.toString());



        }
    }


