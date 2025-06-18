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
		Row row = sheet.getRow(rowNum - 1);
		Cell cell = row.getCell(cellNum - 1);
		String data = cell.getStringCellValue();
		return data;
	}

	public static String[][] getMultipleDataFromExcel(String sheetName) {
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
		int rowNum = sheet.getPhysicalNumberOfRows();
		int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rowNum - 1][cellNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;

	}

}
