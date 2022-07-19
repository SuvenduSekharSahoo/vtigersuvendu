package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcelText {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx ");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet2");
		sh.createRow(0).createCell(0).setCellValue("suvendu");
		System.out.println("1st done");
		sh.createRow(1).createCell(0).setCellValue("Automation");
		System.out.println("2nd done");
		FileOutputStream fos=new FileOutputStream("F:\\TestYantra Note\\V-Tiger Excel.xlsx ");
		book.write(fos);
		//fos.flush();
		fos.close();
		System.out.println("pass");
		}

	}

