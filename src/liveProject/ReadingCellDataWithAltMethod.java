package liveProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingCellDataWithAltMethod {

	public static void main(String[] args) throws Throwable {
		// Write a Script to read cell data with Alternate Method.
		FileInputStream fi = new FileInputStream("D:/FirstSample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		System.out.println("No of Rows are::"+rc);
		String fname = ws.getRow(6).getCell(0).getStringCellValue();
		String mname = ws.getRow(9).getCell(1).getStringCellValue();
		String lname = ws.getRow(12).getCell(2).getStringCellValue();
		int eid = (int) ws.getRow(14).getCell(3).getNumericCellValue();
		System.out.println(fname+"   "+mname+"   "+lname+"   "+eid);
		fi.close();
		wb.close();
	}

}
