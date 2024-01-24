package TestScriptJava;

import org.testng.annotations.Test;

public class SwapWithoutThirdVariable {
    @Test
    public void testcase1()
    {

        String s1="Coding";
        String s2="ninja";

        System.out.println("Before swapping :"+s1 +" And "+s2);

        s1=s1+s2;
        s2=s1.substring(0,s1.length()-s2.length());
        s1=s1.substring(s2.length());



        System.out.println("After swapping :"+s1 +" And "+s2);
    }
}
