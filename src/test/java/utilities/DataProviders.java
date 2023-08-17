package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Iterator;

public class DataProviders {
    @DataProvider(name="LoginData")
    public Object [][] getData() throws IOException
    {
        String path=".//testData//Opencart_Login.xlsx";//taking xl file from testData

        ExcelUtils xlutil=new ExcelUtils(path);//creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
            for(int j=0;j<totalcols;j++)  //0    i is rows j is col
            {
                logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata;//returning two dimension array

    }

    //DataProvider 2

}
