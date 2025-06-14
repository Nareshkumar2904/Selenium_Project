package Generic_Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_Utilities {
	public static String getPropertyData(String key) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/resources/commonData.properties");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = prop.getProperty(key);
		return value;
	}

	public static String getDataFromExcel(String sheetName, int rowNum, int cellNum) {
		FileInputStream fis = null;
		Workbook book = null;

		try {
			fis = new FileInputStream("./src/test/resources/DWS.xlsx");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.toString();
		return data;
	}

}
