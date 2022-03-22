package framepractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FrameFileFirstExcercise {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\FrameFirstExcersise.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet("Sheet1");
		int r1 = s.getPhysicalNumberOfRows();
		System.out.println("Total Rows : "+ r1);
		Row row = s.getRow(7);
		int cel = row.getPhysicalNumberOfCells();
		System.out.println("Total Columns : " + cel);
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			 Cell c = r.getCell(j);
				int cellType = c.getCellType();
				String data = "";
				if(cellType==1) {
					data = c.getStringCellValue();
				}
				else if(DateUtil.isCellDateFormatted(c)) {
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
					data = sf.format(dateCellValue);
				}
				else {
					double numericCellValue = c.getNumericCellValue();
					long l = (long)numericCellValue;
					data = String.valueOf(l);
				}
				System.out.println(data);
			}
		}
	}
}
