package liveProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FirstClass {

	public static void main(String[] args) throws Throwable {
		// Write a Script to read specific row cell data in a sheet.
		FileInputStream fi = new FileInputStream("D:/FirstSample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheetAt(0);
		int rc = ws.getLastRowNum();
		System.out.println("No fo Rows are::"+rc);
		XSSFRow row = ws.getRow(5);
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		String fname = c1.getStringCellValue();
		String mname = c2.getStringCellValue();
		String lname = c3.getStringCellValue();
		int eid = (int) c4.getNumericCellValue();
		System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
		fi.close();
		wb.close();
		

	}

}
