package adactin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Select s;
	public static String orderNumber;
	public static void launchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get(url);
	}
	public static void enterText(WebElement element,String userDetails) {
		element.sendKeys(userDetails);
	}
	public String readExcel(String sheet, int row, int cell) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\Adactin.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int cellType = c.getCellType();
		String data = null;
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
		return data;
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public static void selectById(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}
	public static void clear(WebElement element) {
		element.clear();
	}
	public static String orderNum(String Loc) {
		WebElement order = driver.findElement(By.id(Loc));
		orderNumber = order.getAttribute("value");
		System.out.println(orderNumber);
		return orderNumber;
	}
	public static void writeExcel(int rowNo, int cellNo, String orderNo) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\AdactinOrder.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Output");
		Row r = s.createRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(orderNo);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		System.out.println("done");
	}
}
