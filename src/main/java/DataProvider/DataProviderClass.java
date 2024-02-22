package DataProvider;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProviderClass {

    public static String getFunctionName(Method method)
    {
        String functionName="";
        try
        {
            functionName=((TestCaseName) method.getAnnotation(TestCaseName.class)).value()[0];
        }
        catch (Exception e)
        {
            functionName=method.getName();
        }
       return functionName;

    }

    public static ArrayList<Object> getDataForPage(String pagename, String functionName)
    {
        ArrayList<Object> data=new ArrayList<>();

        try
        {
            String testData= "";
            List<String> lines= Files.readAllLines(Paths.get(""), StandardCharsets.UTF_8);
            for(String line: lines)
            {
                testData=testData+line;
            }
            JsonPath jsonPath=new JsonPath(testData);
            int size=jsonPath.getInt("testData.size()");
            outerloop:
            for(int i=0;i<size;i++)
            {
                String page_name=jsonPath.getString("testData["+i+"].pageName");
                if(page_name.equalsIgnoreCase(pagename))
                {
                    size=jsonPath.getInt("testData["+i+"].pageData.size()");
                    for(int j=0;j<size;j++)
                    {
                        String testCasename=jsonPath.getString("testData["+i+"].pageData["+j+"].testCaseName");
                        if(testCasename.equalsIgnoreCase(functionName))
                        {
                            data=(ArrayList<Object>) jsonPath.getList("testData["+i+"].pageData["+j+"].data");
                            break outerloop;
                        }
                    }
                }
            }
            data.removeIf(n -> (check(n)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    private static boolean check(Object d)
    {
        return ((HashMap<String,Object>) d).get("runMode").equals(false) ? true : false;
    }
}
