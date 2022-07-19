package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class AllDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("CommonData/V-Tiger Excel.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		int lastrow=sh.getLastRowNum();
		for(int i=0;i<=lastrow;i++)
		{
			Row row=sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				DataFormatter format=new DataFormatter();
				String data=format.formatCellValue(row.getCell(j));
				System.out.print(data+"\t");
			}
			System.out.println();
		}
	}

}

