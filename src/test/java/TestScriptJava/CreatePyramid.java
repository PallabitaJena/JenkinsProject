package TestScriptJava;

import org.testng.annotations.Test;

public class CreatePyramid {

    @Test
    public void pramid()
    {
        int count=1;
        for(int i=0; i<3;i++)
        {
            for(int j=0;j<i+1; j++)
            {
                System.out.print(count);
                count++;
            }
            System.out.println("");
        }

    }

}
