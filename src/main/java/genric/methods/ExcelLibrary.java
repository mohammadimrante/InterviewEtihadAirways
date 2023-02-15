package genric.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary 
{
	public static String getCellValue(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(ReadTestData.propertyReader("Input_excel_path"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		String cellValue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return cellValue;	
	}
	
	public static void putCellValue(String sheet, int row, int cell, String cellData) throws IOException, InvalidFormatException
	{
		FileInputStream fis=new FileInputStream(ReadTestData.propertyReader("Ouput_excel_path"));
		Workbook wbook=WorkbookFactory.create(fis);
		Sheet sheetSelect=wbook.getSheet(ReadTestData.propertyReader("sheetname"));
		sheetSelect.getRow(row).createCell(cell).setCellValue(cellData);
		fis.close();
		FileOutputStream fos=new FileOutputStream(ReadTestData.propertyReader("Ouput_excel_path"));
		wbook.write(fos);
		fos.close();
		System.out.println("Data written to file succesfully");
	}
	
	public static String dateGetter(String sheetname, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(ReadTestData.propertyReader("Input_excel_path"));
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		DataFormatter formatter = new DataFormatter();
		String dateFromSheet = formatter.formatCellValue(sheet.getRow(row).getCell(cell));
		DateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
	    DateFormat inputFormat = new SimpleDateFormat("dd-MMM-yy", Locale.US);
	    Date date = inputFormat.parse(dateFromSheet);
	    String outputText = outputFormat.format(date);
	    workbook.close();
	    return outputText;
	}
	

}