package api.utilitie;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class XLUtility {

public XSSFWorkbook workbook;
public XSSFSheet sheet;
public FileInputStream fi;
public XSSFRow  row;
public XSSFCell cell;
String path;

   public XLUtility(String path)
   
   {
	   this.path=path;
   }
public int getrowCount(String sheetName) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	workbook.getSheet(sheetName);
	sheet=workbook.getSheet(sheetName);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	return rowcount;
}
public int getCellCount(String sheetName ,int rownum) throws IOException
{
	fi=new FileInputStream(path);
	workbook=new XSSFWorkbook(fi);
	workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	workbook.close();
	fi.close();
	return cellcount;
	
}
	public String getCellData(String sheetName, int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter formatter =new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);  //retrun the formatted value of the cell as a string regadless of
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		
		
	}
	

}
