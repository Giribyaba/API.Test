package api.utilitie;

import java.io.IOException;

public class DataProvider 
{
	@org.testng.annotations.DataProvider(name="data")
	public String[][] gtAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum = xl.getrowCount("Sheet1");
		int cellcount = xl.getCellCount("sheet1", 1);
		
		String apidata[][]=new String[rownum][cellcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("sheet1", i, j);
			}
		}
		return apidata;
	}
	
	@org.testng.annotations.DataProvider(name="UserName")
	public String[] getuserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+ "//testData//userdata.xlsx";
		XLUtility xl=new XLUtility(path);
		int rownum = xl.getrowCount("sheet1");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("sheet1", i, 1);
		}
		return apidata;
		
		
	}
	
	
}
