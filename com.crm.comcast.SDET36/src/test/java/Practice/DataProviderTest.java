package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.comcast.GENERICUTILITY.ExcelUtility;

public class DataProviderTest extends ExcelUtility{

	@Test(dataProvider="book_ticket_from_source_to_destination")
	public void bookTicketTest(String source, String destination)
	{
		System.out.println("Book Ticket From " +source+ " To " +destination);
	}
	
	@DataProvider
	public Object[][] book_ticket_from_source_to_destination() throws Throwable
	{
		Object[][] objarray = new Object[3][2];
		 
		objarray[0][0] = getDataFromExcel("Sheet3" , 0, 0); 
		objarray[0][1] = getDataFromExcel("Sheet3" , 0, 1);
		
		objarray[1][0] = getDataFromExcel("Sheet3" , 1, 0); 
		objarray[1][1] = getDataFromExcel("Sheet3" , 1, 1); 
		
		objarray[2][0] = getDataFromExcel("Sheet3" , 2, 0); 
		objarray[2][1] = getDataFromExcel("Sheet3" , 2, 1); 
		
//		ExcelUtility eu = new ExcelUtility();
//		FileInputStream fis  = new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx");
//		Workbook book = WorkbookFactory.create(fis);
//		Sheet sh = book.getSheet("Sheet3");
//		int lastrow = sh.getLastRowNum();
//		for(int i=0;i<=lastrow;i++)
//		{
//			Row row = sh.getRow(i);
//			for(int j=0;j<row.getLastCellNum();j++)
//			{
//				DataFormatter format = new DataFormatter();
//				format.formatCellValue(row.getCell(j));
//				objarray = new Object[i][j];
//				
//			}
//		}
		return objarray;
		
	}
}
