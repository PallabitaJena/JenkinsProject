package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBConnection {
    static Connection connection;
    static String dataBasename="dta_ccp_database";
    static String url="jdbc:mysql://aersfyfy.mysql.database.azure.com:3306"+dataBasename;

    static String username="paljena";
    static String password="shdhds";

    public static List<HashMap<String, String>> connectDB(String query) throws SQLException {
        Throwable localthrowable4=null;
        List<HashMap<String, String>> result= new ArrayList<>();
        connection= DriverManager.getConnection(url,username,password);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Statement statement = connection.createStatement();

                try {
                    ResultSet rs = statement.executeQuery(query);
                    try
                    {
                        ResultSetMetaData rsMetaData=rs.getMetaData();
                        while(rs.next())
                        {
                            HashMap<String,String> data= new HashMap<>();
                            for(int i=1;i< rsMetaData.getColumnCount();i++)
                            {
                                data.put(rsMetaData.getCatalogName(i),rs.getString(i));
                            }
                            result.add(data);
                        }
                    }
                    catch (Throwable localThrowable)
                    {
                        throw localThrowable;
                    }
                }
                catch (Throwable localThrowable1)
                {
                    throw localThrowable1;
                }
            }
            catch (Throwable localThrowable2)
            {
                localthrowable4=localThrowable2;
                throw localThrowable2;
            }
            finally {
                if(connection != null)
                {
                    if(localthrowable4 != null)
                    {
                        try {
                            connection.close();
                        }
                        catch (Throwable localthrowable3)
                        {
                            localthrowable4.addSuppressed(localthrowable3);
                        }
                    }
                    else
                    {
                        connection.close();
                    }
                }
            }
        }

        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
