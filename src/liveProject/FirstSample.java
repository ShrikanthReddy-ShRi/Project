package liveProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FirstSample {
//Write a script to count number of rows in a sheet and number of column in first row.
	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("D:/FirstSample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		XSSFRow row = ws.getRow(0);
		int cc = row.getLastCellNum();
		System.out.println("No of Rows are::"+rc+"   "+"No of Cells are::"+cc);
		fi.close();
		wb.close();

	}

}
