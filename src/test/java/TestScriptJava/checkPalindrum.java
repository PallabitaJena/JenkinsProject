package TestScriptJava;

import org.testng.annotations.Test;

public class checkPalindrum {

    @Test
    public void checkingnumberAsPalindrum()
    {
        int num=4547;
        int temp=num,check,sum=0;
        while(num>0)
        {
            check=num%10;
            sum=(sum*10)+check;
            num=num/10;
        }
        if(temp==sum)
        {
            System.out.println("Number is palindrum");
        }
        else {
            System.out.println("Number is not palindrum");
        }
    }
}
