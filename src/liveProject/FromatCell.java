package liveProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FromatCell {

	public static void main(String[] args) throws Throwable {
		// Write a Script to format Cells
		FileInputStream fi = new FileInputStream("D:/FirstSample.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("Emp");
		int rc = ws.getLastRowNum();
		System.out.println("No of Rows are::"+rc);
		for(int i=1; i<=rc;i++){
			ws.getRow(i).createCell(4).setCellValue("Pass");
			//ws.getRow(i).createCell(4).setCellValue("Fail");
			//ws.getRow(i).createCell(4).setCellValue("Blocked");
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			//font.setColor(IndexedColors.BLUE.getIndex());
			//font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(i).getCell(4).setCellStyle(style);
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D:/Results.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
