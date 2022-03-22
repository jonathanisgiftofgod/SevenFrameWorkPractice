package adactinjunit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static String orderNumber;
	public static void launchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	public void enterText(WebElement element, String userDetails) {
		element.sendKeys(userDetails);
	}
	public void btnclick(WebElement element) {
		element.click();
	}
	public String readExcel(String sheet, int row, int column) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\Adactin.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		int cellType = c.getCellType();
		String data = null;
		if (cellType==1) {
			data = c.getStringCellValue();
		} else if(DateUtil.isCellDateFormatted(c)){
			Date d = new Date();			
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			data = sf.format(d);
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long)numericCellValue;
			data = String.valueOf(l);
		}
		return data;
	}
	public void selectById(WebElement element, int index) {
		Select s = new Select(element);
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
	public static void writeExcel(int row, int column, String orderNo) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\OrderForAdactin.xlsx");
		f.createNewFile();
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Sheet1");
		Row r = s.createRow(row);
		Cell c = r.createCell(column);
		c.setCellValue(orderNo);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		System.out.println("Done");
	}
}
