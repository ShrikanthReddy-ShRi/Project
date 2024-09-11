package liveProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertingIntToStringCellData {

	public static void main(String[] args) throws Throwable {
		// Write a Script to convert integer to string cell data.
		FileInputStream fi = new FileInputStream("D:/FirstSample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		System.out.println("No of Rows are::"+rc);
		for(int i=1; i<=rc; i++) {
			if (wb.getSheet("Emp").getRow(i).getCell(0).getCellType()==CellType.NUMERIC);
			{
				int celldata = (int) wb.getSheet("Emp").getRow(i).getCell(3).getNumericCellValue();
				String eid = String.valueOf(celldata);
				System.out.println(eid);
				ws.getRow(i).createCell(4).setCellValue("Fail");
			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D:/Result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
