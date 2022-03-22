package framepractice;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DoubtReverseOfFirstExcersise {
	public static void main(String[] args) throws IOException {
		// if i add more than one string value, the existing one was deleted. How to add more than one values?  
		File f= new File("C:\\Users\\Britto\\Desktop\\JAVA\\inputData.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Input");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue("Britto");
		
		Row r1 = s.createRow(0);
		Cell c1 = r1.createCell(1);
		c1.setCellValue("Java");
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		System.out.println("All the Best");
	}
}
