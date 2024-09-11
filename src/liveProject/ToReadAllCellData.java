package liveProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ToReadAllCellData {

	public static void main(String[] args) throws Throwable {
		// Write a Script to Read All Cell Data
		FileInputStream fi = new FileInputStream("D:/FirstSample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		System.out.println("No of Rows are::"+rc);
		for(int i=1; i<=rc; i++) {
			String fname = ws.getRow(i).getCell(0).getStringCellValue();
			String mname = ws.getRow(i).getCell(1).getStringCellValue();
			String lname = ws.getRow(i).getCell(2).getStringCellValue();
			int eid = (int) ws.getRow(i).getCell(3).getNumericCellValue();
			System.out.println(fname+"   "+mname+"   "+lname+"   "+eid);
			// Write script to write some text into Status cell.
			ws.getRow(i).createCell(4).setCellValue("PASS");
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D:/Results.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
